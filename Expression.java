public class Expression
{

    public static void main(String[] args)
    {
	Expression thing = new Expression(new Term(1,
						   new Var('x', 1),
						   new Var('y', 2),
						   new Var('z', 3)),
					  new Term(5,
						   new Var('a', 3),
						   new Var('b', 2),
						   new Var('c', 1)));
	System.out.println(thing);
    }

    private LinkedList[] table;
    private static final int TABLE_LENGTH = 100;

    //CONSTRUCTORS
    //----------------------------------------------------------------

    public Expression(Term... terms)
    {
	table = new LinkedList[100];
	for (int index = 0; index < terms.length; index++)
	    {
		add(terms[index]);
	    }
    }

    //================================================================

    //MAIN
    //----------------------------------------------------------------

    public void add(Term datum)
    {
	int index = hash(datum);
	if (table[index] == null)
	    {
		table[index] = new LinkedList(datum);
	    }
	else
	    {
		table[index].add(datum);
	    }
    }

    public String toString()
    {
	String output = "";
	for (int index = 0; index < table.length; index++)
	    {
		output += 
		    table[index] != null ? 
		    table[index]  + String.format(" + %n"):
		    "";
	    }
	return output;
    }

    //================================================================

    //HASH
    //----------------------------------------------------------------

    private int hash(Term datum)
    {
	int output = 0;
	for (int index = 0; index < Term.numPows(); index++)
	    {
		output += datum.getPowerOf(index);
	    }
	output %= table.length;
	return output;
    }

    //================================================================

    //LINKEDLIST
    //----------------------------------------------------------------
    private class LinkedList
    {

	private Node sent;
	private int size;

	public LinkedList(Term... data)
	{
	    sent = new Node(null);
	    size = data.length;
	    for (int index = 0; index < data.length; index++)
		{
		    add(data[index]);
		}
	}

	//MAIN
	//--------------------------------

	public void add(Term datum)
	{
	    Node newnode = new Node(datum);
	    newnode.setNext(sent.getNext());
	    sent.setNext(newnode);
	}

	public String toString()
	{
	    String output = "";
	    for (Node curr = sent.getNext(); curr != null; curr = curr.getNext())
		{
		    output += curr + " + ";
		}
	    return output;
	}

	//================================

	//UTIL
	//--------------------------------

	public int size() { return size; }

	//================================

	//NODE
	//--------------------------------
	private class Node
	{

	    private Term datum;
	    private Node next;

	    //CONSTRUCTORS
	    //----------------

	    public Node(Term datum, Node next)
	    {
		this.datum = datum;
		this.next = next;
	    }

	    public Node (Term datum) { this(datum, null); }

	    //================

	    //MAIN
	    //----------------
	    
	    public String toString()
	    {
		return datum.toString();
	    }

	    //================

	    //UTIL
	    //----------------

	    public Term getDatum() { return datum; }

	    public Node getNext() { return next; }
	    public void setNext(Node next) { this.next = next; }

	    //================

	}
	//================================
    }
    //================================================================
}