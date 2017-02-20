 import java.util.*;

public class Account {

	int accno;
	String name;
	long phno;
	float balance;

	void getInput() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter Account Number");
		accno = sc.nextInt();
		System.out.println("Enter Name");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("Enter Phone Number");
		phno = sc.nextLong();
		System.out.println("Enter Balance");
		balance = sc.nextFloat();
	}

	void display() {
		System.out.println("Account Details");
		System.out.println("Account Number " + accno);
		System.out.println("Name " + name);
		System.out.println("Phone Number " + phno);
		System.out.println("Balance " + balance);
	}

	void deposit(){
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter Amount to Deposit");
		float dep = sc.nextFloat();
		balance = balance + dep;
		System.out.println("Balance is " + balance);
	}

	void withdraw(){
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter Amount to Withdraw");
		float with = sc.nextFloat();
		if (balance - with < 0 )
			System.out.println("Amount to Withdraw greater than Balance");
		else
			balance = balance - with;
		System.out.println("Balance is " + balance);
	}

	public static void main ( String args[] ){
		Account ac = new Account();
		ac.getInput();
		ac.display();
		ac.withdraw();
		ac.deposit();
	}
}
