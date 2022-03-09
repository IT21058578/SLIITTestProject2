package sliit.proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class loginDbUtil {
	
	public static List<Student> validate (String username, String password) {
		ArrayList<Student> StdntList = new ArrayList<>();
		
		String dbUrl = "jdbc:mysql://localhost:3306";
		String dbUser = "root";
		String dbPass = "admin";
		String dbName = "testdb";
		
		//These are initialized here and set to null so finally block can execute.
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
			stmt = conn.createStatement();
			String sql = "select * from "+dbName+".student where username='"+username+"' and password='"+password+"';";
			res = stmt.executeQuery(sql);
			
			if (res.next()) {
				int id = res.getInt(1);
				String usr = res.getString(2);
				String ps = res.getString(3);
				String name = res.getString(4);
				String email = res.getString(5);
				
				Student Stdnt1 = new Student(id, usr, ps, name, email);
				StdntList.add(Stdnt1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* Done so these will close without problem.
			 * Try-catch is necessary as it gives an warning otherwise.
			 * */
			try { res.close(); } catch (Exception e) { /* Ignored */ }
		    try { stmt.close(); } catch (Exception e) { /* Ignored */ }
		    try { conn.close(); } catch (Exception e) { /* Ignored */ }
		}
		return StdntList;
	}
}
