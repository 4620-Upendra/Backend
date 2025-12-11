package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementWithNoParameters {

	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		String query="{call insert_student()}";  // calling stored procedure with no parameters
		
		try {
			
			// 1. load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Establish Connection
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			
			// 3.Prepare CallableStatement
			
			CallableStatement callableStmt =con.prepareCall(query);
			
			// 4. Execute procedure
			int rows=callableStmt.executeUpdate(); // return number of row affected
			
			System.out.println(rows +" Record inserted successfully using CallableStatement");
			
			//5 closing connections
			con.close();
			callableStmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
