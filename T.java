// -*-Java-*-
import java.util.Random;

public class T
{
    //if using Emacs, use C-s //[WORDINCAPS] to jump to that section
    //if not, get Emacs <3

    public static void main(String[] args)
    {
	testAll(0);
    }

    public static void testAll(int lev)
    {
	testing(lev++, "");

	complete(--lev);
    }

    //UTILITY
    //----------------------------------------------------------------64

    private static <T> void printw(int tabs, T input)
    {
	while (tabs-- > 0)
	    {
		System.out.print("\t");
	    }
	System.out.println(input);
    }

    private static void testing(int lev, String input)
    {
	printw(lev, "TESTING " + input + "...");
    }

    private static void complete(int lev)
    {
	printw(lev, "TESTING COMPLETE!");
    }

    private static int randInt(Random gen, int min, int max)
    {
	return (int)(gen.nextInt( max - min )) + min;
    }

    //================================================================64

}