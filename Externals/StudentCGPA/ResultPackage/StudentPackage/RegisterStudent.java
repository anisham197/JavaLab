package ResultPackage.StudentPackage;

import java.util.*;

interface Student {

	public void getInput();
}

public class RegisterStudent implements Student {

	public String name, branch;
	public int sems;
	public ArrayList<Integer> credits;

	public void getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("Enter name and branch");
		name = sc.nextLine();
		branch = sc.nextLine();
	}

	public void enterData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of Semesters");
		sems = sc.nextInt();

		credits = new ArrayList<>();
		for ( int i = 0; i < sems; i++ )
		{
			System.out.println("Enter credits for sem " + (i + 1));
			
			try 
			{
				int sem_cred = sc.nextInt();
				if ( sem_cred > 30 )
					throw new CreditLimit("Credits exceed 30");
				else
					credits.add(sem_cred);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage() );
			}

		}
	}
}

class CreditLimit extends Exception {
	
	CreditLimit ( String s){
		super(s);
	}
}


