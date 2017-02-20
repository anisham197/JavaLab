package ResultPackage;

import StudentPackage.RegisterStudent;
import java.util.*;

class ResultDetails {

	public ArrayList<Float> grades;

	RegisterStudent rs = new RegisterStudent();

	public void enterGrade() {
		Scanner sc = new Scanner(System.in);
		
		grades = new ArrayList<>();
		for ( int i = 0; i < rs.sems; i++ )
		{
			System.out.println("Enter grades for sem " + i + 1 );
			
			try 
			{
				float sem_grade = sc.nextFloat();
				if ( sem_grade > 10 )
					throw new InvalidCGPA("SGPA exceeds 10");
			}
			catch (NumberFormatException nf)
			{
				System.out.println(nf.getMessage() );
			}
			catch ( InvalidCGPA ic )
			{
				System.out.println(ic.getMessage() );
			}

		}
	}

	public void display () {

		RegisterStudent rs = new RegisterStudent();

		System.out.println("Name: " + rs.name);
		System.out.println("Branch: " + rs.branch);

		System.out.println("Semester\tCredits\tSGPA ");

		float total = 0;
		for ( int i = 0; i < rs.sems; i++ )
		{
			System.out.println( (i+1) + "\t" + rs.credits.get(i) + "\t" + grades.get(i));
			total = total + ( grades.get(i) * rs.credits.get(i) );
		}

		System.out.println ("Final CGPA is :" + total/rs.sems );

	}

	public static void main (String args[] ) {
		RegisterStudent rs = new RegisterStudent();
		rs.getInput();
		rs.enterData();

		ResultDetails rd = new ResultDetails();
		rd.enterGrade();
		rd.display();
	}
	
}

class InvalidCGPA extends Exception {
	
	InvalidCGPA ( String s){
		super(s);
	}
}
