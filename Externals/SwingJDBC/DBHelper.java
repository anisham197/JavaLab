import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DBHelper {
	
	String DRIVER = "com.mysql.jdbc.Driver";
	String HOST = "jdbc:mysql://localhost:3306/java";
	String USER = "root";
	String PASS = "root";
	Connection con;
	
	DBHelper()
	{
		try 
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(HOST,USER,PASS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void insertRep(String name, String state, int commission, int rate)
	{
		String query = "INSERT INTO representative(repname,state,comission,rate) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, state);
			stmt.setFloat(3, commission);
			stmt.setFloat(4, rate);
			
			stmt.executeUpdate();
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	void insertCustomer(String name, String state, int creditLimit, int repNo)
	{
		String query = "INSERT INTO customer ( custname,state,credlimit,repno) values(?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, state);
			stmt.setInt(3, creditLimit);
			stmt.setInt(4, repNo);
			
			stmt.executeUpdate();
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	void getReps(DefaultTableModel model) {		   //
		String query ="SELECT  representative.repno, repname FROM  representative, customer WHERE customer.repno = representative.repno  AND customer.credlimit > 6000 GROUP BY  representative.repno"; 
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
			   String repno = rs.getString(1);
			   String repname = rs.getString(2);
			   model.addRow(new Object []{repno,repname});
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		   
	 }
}

