package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtwithDynamicParameters {

	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		// calling stored procedure with input parameters
		String query="{call insert_student1(?,?,?,?)}";  
		
		try {
			
			// 1. load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish Connection
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);

			// 3.Prepare CallableStatement
			CallableStatement callableStmt= con.prepareCall(query);
			
			callableStmt.setInt(1, 4);
			callableStmt.setString(2, "kumar");
			callableStmt.setInt(3, 26);
			callableStmt.setString(4, "vizag");
			
			int rows=callableStmt.executeUpdate();
			
			System.out.println(rows +" Record inserted successfully using CallableStatement by passing paramters at rumtime");
				
		}catch(Exception e) {
			e.getStackTrace();
		}

	}

}
