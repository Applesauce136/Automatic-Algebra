public class Var
{
    private char name;
    private int power;

    public Var(char name, int power)
    {
	if (!Character.isLowerCase(name))
	    throw new IllegalArgumentException("must be lowercase");
	this.name = name;
	this.power = power;
    }

    public char getName() { return name; }
    public int getPower() { return power; }

}