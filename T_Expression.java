// -*-Java-*-
import java.util.Random;
import java.util.Arrays;

public class T_Expression
{
    //if using Emacs, use C-s //[WORDINCAPS] to jump to that section
    //if not, get Emacs <3

    public static void main(String[] args)
    {
	testAll(0);
    }

    private static final long SEED = 20;

    private static void testAll(int lev)
    {
	Random gen = new Random();
	testing(lev++, "");
	test_init(lev, gen);
	complete(--lev);
    }

    private static final int 
	NUM_TERMS = 8,
	MIN_COEFF = 1,
	MAX_COEFF = 10,
	MIN_POWER = 1,
	MAX_POWER = 10;

    private static void test_init(int lev, Random gen)
    {
	testing(lev++, "init");
	printw(lev, "--------------------------------");
	System.out.println(randExpression(gen));
	printw(lev, "================================");
	complete(--lev);
    }

    private static Expression randExpression(Random gen)
    {
	Expression output = new Expression();
	for (int index = 0; index < NUM_TERMS; index++)
	    {
		output.add(randTerm(gen));
	    }
	return output;
    }

    private static Term randTerm(Random gen)
    {
	return new Term(randInt(gen, MIN_COEFF, MAX_COEFF),
			randVar(gen),
			randVar(gen));
    }

    private static Var randVar(Random gen)
    {
	return new Var(randChar(gen), randInt(gen, MIN_POWER, MAX_POWER));
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

    private static char randChar(Random gen)
    {
	return (char)(randInt(gen, (int)'a', (int)'z' + 1));
    }

    private static int randInt(Random gen, int min, int max)
    {
	return (gen.nextInt( max - min )) + min;
    }

    //================================================================64

}