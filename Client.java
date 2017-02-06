import java.util.*;

abstract class Vehicle {
	int yom;

	abstract public void getData();

	abstract public void putData();
}

class TwoWheeler extends Vehicle {

	public TwoWheeler(){
		yom = 1996;
	}
	
	public void getData(){
		System.out.println("Two Wheeler");
		System.out.println("Enter year of Manufacture");
		Scanner sc = new Scanner(System.in);
		yom = sc.nextInt();
	}

	public void putData(){
		System.out.println("Year of Manufacture is " + yom );
	}

}

final class FourWheeler extends Vehicle {
	
	public void getData(){
		System.out.println("Four Wheeler");
		System.out.println("Enter year of Manufacture");
		Scanner sc = new Scanner(System.in);
		yom = sc.nextInt();
	}

	public void putData(){
		System.out.println("Year of Manufacture is " + yom );
	}

}

class MyTwoWheeler extends TwoWheeler {
	
	int yom;

	public void getData(){
		System.out.println("Two Wheeler");
		System.out.println("Enter year of Manufacture");
		Scanner sc = new Scanner(System.in);
		yom = sc.nextInt();
	}

	public void putData() {
		System.out.println("Default Year of Manufacture is " + super.yom );
		System.out.println("Year of Manufacture is " + yom );
	}
}

public class Client {

	public static void main ( String args[] ) {
		
		TwoWheeler tw = new TwoWheeler();
		tw.getData();
		tw.putData();
		FourWheeler fw = new FourWheeler();
		fw.getData();
		fw.putData();
		System.out.println("My Two Wheeler");
		MyTwoWheeler mtw = new MyTwoWheeler();
		mtw.getData();
		mtw.putData();
		
	}
}


