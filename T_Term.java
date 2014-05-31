// -*-Java-*-

public class T_Term
{
    //if using Emacs, use C-s //[WORDINCAPS] to jump to that section
    //if not, get Emacs <3

    public static void main(String[] args)
    {
	testAll();
    }

    private static void testAll()
    {
	test_add();
	test_mlt();
    }

    private static void test_add()
    {
	testing("add");
	Term term1 = new Term();
	term1.setCoeff(3);
	term1.setPowerOf('x', 1);
	term1.setPowerOf('y', 2);
	term1.setPowerOf('z', 3);
	System.out.println("term1: " + term1);
	Term term2 = new Term();
	term2.setCoeff(4);
	term2.setPowerOf('x', 1);
	term2.setPowerOf('y', 2);
	term2.setPowerOf('z', 3);
	System.out.println("term2: " + term2);
	term1.add(term2);
	System.out.println("term1 + term2 = " + term1);
    }

    private static void test_mlt()
    {
	testing("mlt");
	Term term1 = new Term();
	term1.setCoeff(3);
	term1.setPowerOf('x', 1);
	term1.setPowerOf('y', 2);
	term1.setPowerOf('z', 3);
	System.out.println("term1: " + term1);
	Term term2 = new Term();
	term2.setCoeff(4);
	term2.setPowerOf('x', 1);
	term2.setPowerOf('y', 2);
	term2.setPowerOf('z', 3);
	System.out.println("term2: " + term2);
	term1.mlt(term2);
	System.out.println("term1 * term2 = " + term1);
    }

    //UTILITY
    //----------------------------------------------------------------

    private static <T> void printw(int tabs, T input)
    {
	while (tabs-- > 0)
	    {
		System.out.print("\t");
	    }
	System.out.println(input);
    }

    private static void testing(String input)
    {
	printw(0, "TESTING " + input + "...");
    }

    private static void complete()
    {
	printw(0, "TESTING COMPLETE!");
    }

    //================================================================

}