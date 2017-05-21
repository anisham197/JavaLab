import java.util.*;

public class Account
{
	public int accno;
  public long phone;
	public String name;
	public float balance;

  public Account( String n, int a, long ph, float b){
    name = n;
    accno = a;
    phone = ph;
    balance = b;
  }

	void deposit() {
    Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to deposit: ");
		float dep = sc.nextFloat();
		if( dep <= 0)
			System.out.println("Cannot deposit! Balance: " + balance);
		else
		{
			balance += dep;
			System.out.println("Updated balance: "+ balance);
		}
	}

	void withdraw() {
    Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to withdraw: ");
		float with = sc.nextFloat();
		if(with <= balance && with > 0)
		{
			balance -= with;
			System.out.println("Updated balance: " + balance);
		}
		else
			System.out.println("Cannot withdraw! Balance: " + balance);
	}

	void showDetails() {
		System.out.println("\nName: " + name + "\nAccountNo: " + accno + "\nPhoneNo: " + phone + "\nBalance: " + balance);
	}


	public static void main (String[] args)
	{
		System.out.println("Enter number of employees: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

    ArrayList<Account> list = new ArrayList<>();
    for ( int i = 0; i < num; i++)
    {
      System.out.println("Enter name: ");
      sc.nextLine();
  		String name = sc.nextLine();
  		System.out.println("Enter account number: ");
  		int accno = sc.nextInt();
  		System.out.println("Enter phone number: ");
  		long phone = sc.nextLong();
  		System.out.println("Enter balance: ");
  		float balance = sc.nextFloat();
  		if(balance < 0)
  		{
  			System.out.println("Value cannot be less than zero! Defaulting to zero.\n");
  			balance = 0;
  		}

      list.add( new Account(name, accno, phone, balance));
    }

		System.out.println("\nBalance less than 10000: ");
    for (Account ac : list){
      if(ac.balance < 10000)
        ac.showDetails();
    }

		while(true) {
      System.out.println("\nEnter employee number\n");
      int n = sc.nextInt();
      if ( n > 0 && n <= list.size()) {
        System.out.println("\nEnter choice: \n1) Withdraw \n2) Deposit: \n3) Show Details \n4) Exit: ");
  			int ch = sc.nextInt();
  			switch(ch) {
  				case 1 :	 list.get(n-1).withdraw();
					           break;
  				case 2 :   list.get(n-1).deposit();
  	  						   break;
  				case 3 : 	 list.get(n-1).showDetails();
  				 		       break;
  				case 4 : return;
  				default : System.out.println("Incorrect Choice!");
  					  	    break;
  			}
      }
      else
          System.out.println("Incorrect Employee Number\n");
		}
	}
}
