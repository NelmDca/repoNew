package Practice;

import java.sql.*;

public class DatabasePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  
			
		} catch (ClassNotFoundException ex) {
			System.out.println("Problem in loading the driver");
			ex.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName ;
			conn = DriverManager.getConnection(dbURL);  // to establish the connection
			String n = "Liann";
			double sa = 66000;
			
			stat = conn.createStatement();
			
			//String query = "INSERT INTO EMP (EName,Salary) " + "values ('ABC',65000)";
			String query = "INSERT INTO EMP (EName,Salary) " + "values ('"+n+"',"+sa+")";
			
			//stat.executeUpdate(query);
			
			query = "UPDATE EMP SET Salary = 12000" + " where EName= 'ABC'";
			stat.executeUpdate(query);
			
			query = "DELETE FROM EMP where Ename = 'Liann'";
			stat.executeUpdate(query);
			
			rs = stat.executeQuery("SELECT * FROM Emp");
			
			int id;
			String name;
			double sal;
			
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				
				System.out.println(" ID " + id + " Name " + name + " Salary " + sal);
			}
			
			
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					rs.close();
					stat.close();
					rs.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

}
