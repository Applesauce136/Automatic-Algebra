/**
 *Term class
 *Describes a mathematical term of the form ax^b * cy^d * ...
 */

public class Term
{

    private static final int NUM_POWS = 26;

    private int coeff;
    private int[] powers;

    //CONSTRUCTORS
    //----------------------------------------------------------------

    public Term(int coeff, Var... vars)
    {
    	this.coeff = coeff;
    	powers = new int[NUM_POWS];
	for (int index = 0; index < vars.length; index++)
	    {
		setPowerOf(vars[index].getName(), vars[index].getPower());
	    }
    }

    public Term(int coeff) { this(coeff, new Var[0]); }
    public Term (Var... vars) { this(1, vars); }

    public Term() { this(1, new Var[0]); }

    //================================================================

    //MAIN
    //----------------------------------------------------------------

    /**
     *Adds Term that to this one.  Modifies this, but not that.
     *@param that The term added to this term.
     *@throws IllegalArgumentException If that is of a different degree as this.
     */
    public void add(Term that)
    {
    	if (sameDegree(that))
    	    {
    		this.coeff += that.coeff;
    	    }
    	else
    	    {
    		throw new IllegalArgumentException("not of same degree");
    	    }
    }

    /**
     *Multiplies Term that to this one.  Modifies this, but not that.
     *@param that The term by which this one is mulitplied.
     */
    public void mlt(Term that)
    {
    	this.coeff *= that.coeff;
    	for (int index = 0; index < NUM_POWS; index++)
    	    {
    		this.powers[index] += that.powers[index];
    	    }
    }

    public String toString()
    {
    	//if (coeff == 0) return "0";
    	String output = coeff == 1 ? "" : Integer.toString(coeff);
    	for (int index = 0; index < powers.length; index++)
    	    {
    		if (powers[index] == 0)
    		    output += "";
    		else if (powers[index] == 1)
    		    output += ITN(index);
    		else
    		    output += String.format("(%c^%d)", ITN(index), powers[index]);
    	    }
    	return output;
    }

    //================================================================

    //UTILITY
    //----------------------------------------------------------------

    public boolean sameDegree(Term that)
    {
    	for (int index = 0; index < NUM_POWS; index++)
    	    {
    		if (this.powers[index] != that.powers[index])
    		    return false;
    	    }
    	return true;
    }

    public void setCoeff(int coeff) {this.coeff = coeff;}
    public void setPowerOf(int index, int power) {powers[index] = power;}
    public void setPowerOf(char name, int power) {setPowerOf(NTI(name), power);}

    public int getCoeff() { return coeff; }
    public int getPowerOf(int index) { return powers[index]; }
    public int getPowerOf(char name) { return getPowerOf(NTI(name)); }

    public static int numPows() { return NUM_POWS; }

    private static int NTI(char name)
    {
    	if (Character.isLowerCase(name))
	    return (int)name - (int)'a';
	else
	    throw new IllegalArgumentException("Must be lowercase");
    }

    private static char ITN(int index)
    {
	if (0 <= index && index <= NUM_POWS)
	    return (char)(index + (int)'a');
	else
	    throw new IllegalArgumentException(String.format("Must be [0, %d]", NUM_POWS));
    }

    //================================================================

}
