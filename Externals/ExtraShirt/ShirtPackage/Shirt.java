package ShirtPackage;

public abstract class Shirt
{
	public int size;
	public float price;
	public String colour;

	protected Shirt(int s, float p)
	{
		size = s;
		price = p;
	}

	public abstract String getColour();
	public abstract void setColour(String c);
	public abstract void getDetails();
}
