package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

// reading data in student table by CallableStatement and ResultSet

public class CallableStatementWithResultSet {

	public static void main(String[] args) {
		String query="{call get_all_students()}";
		
		try {
			 // Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			
			 // Prepare CallableStatement
			CallableStatement callableStmt=con.prepareCall(query);
			
			// Execute and receive ResultSet
			ResultSet rs=callableStmt.executeQuery();
			
			// Iterate ResultSet
			System.out.println("id"+"\t"+"name"+"\t"+"age"+"\t"+"city");
			System.out.println("--------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("age")+"\t"+rs.getString("city"));
			}
           
			// close connections		
			con.close();
			callableStmt.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
