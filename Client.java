class Client {	

public static void main (String args[] ) {
		RegisterStudent rs = new RegisterStudent();
		rs.getInput();
		rs.enterData();

		ResultDetails rd = new ResultDetails();
		rd.enterGrade();
		rd.display();
	}
}
