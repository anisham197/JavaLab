import java.util.*;
import java.io.*;
import ShirtPackage.Shirt;

final class PullOver extends Shirt
{
  	public Boolean hasHood, hasStripes;

  	PullOver(int size, float price, Boolean hood, Boolean stripes)
  	{
    		super(size, price);
    		hasHood = hood;
    		hasStripes = stripes;
  	}

  	public String getColour()
  	{
  		  return super.colour;
  	}

  	public void setColour(String c)
  	{
  		  super.colour = c;
  	}

  	public void getDetails()
  	{
  		  System.out.println("\nSize: " + super.size + "\nPrice: " + super.price + "\nHood: " + hasHood + "\nStripes: " + hasStripes + "\nColour: " + getColour());
  	}
}

class FormalShirt extends Shirt
{
  	public Boolean hasFullSleeve, hasStripes;

  	FormalShirt(int size, float price, Boolean sleeve, Boolean stripes)
  	{
    		super(size, price);
    		hasFullSleeve = sleeve;
    		hasStripes = stripes;
  	}

  	public String getColour()
  	{
  		    return super.colour;
  	}

  	public void setColour(String c)
  	{
  		  super.colour = c;
  	}

  	public void getDetails()
  	{
  		  System.out.println("\nSize: " + super.size + "\nPrice: " + super.price + "\nSleeves: " + hasFullSleeve + "\nStripes: " + hasStripes + "\nColour: " + getColour());
  	}
}

class PartyWear extends FormalShirt
{
	String brand;

	PartyWear(int size, float price, Boolean sleeve, Boolean stripes, String b)
	{
		super(size, price, sleeve, stripes);
		brand = b;
	}

	public void getDetails()
	{
		System.out.println("\nBrand: " + brand + "\nSize: " + super.size + "\nPrice: " + super.price + "\nSleeves: " + hasFullSleeve + "\nStripes: " + hasStripes + "\nColour: " + getColour());
	}
}

public class MainShirt
{
  	public static void main(String[] args)
  	{
    		Shirt s1 = new PullOver(32, 350, true, false);
    		s1.setColour("Red");
    		Shirt s2 = new FormalShirt(30, 350, true, false);
    		s2.setColour("Blue");
    		Shirt s3 = new PartyWear(36, 450, true, false, "PUMA");
    		s3.setColour("Green");
    		s1.getDetails();
    		s2.getDetails();
    		s3.getDetails();
	}
}
