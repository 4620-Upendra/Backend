package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

// counting total students in student table by using callableStatment With OutPutParameter

public class callableStatmentWithOutPutParameter {

	public static void main(String[] args) {
		
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		// calling stored procedure with output parameters 
		String query="{call get_total_students(?)}";  
		
		try {
			
			// 1. load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish Connection
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);

			// 3.Prepare CallableStatement
			CallableStatement callableStmt= con.prepareCall(query);
			
			// Register OUT parameter
			callableStmt.registerOutParameter(1, Types.INTEGER);
			
			// Execute
			callableStmt.execute();
			
			//  Get OUT value
			int total=callableStmt.getInt(1);
			
			System.out.println("Total Students = " + total);
			
				
		}catch(Exception e) {
			e.getStackTrace();
		}

	}

}
