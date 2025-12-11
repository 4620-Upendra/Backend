package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtWithStaticParameters {

	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		// calling stored procedure with input parameters
		String query="{call insert_student1(4 ,'Rahul', 22, 'Hyderabad')}";  
		
		try {
			
			// 1. load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish Connection
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);

			// 3.Prepare CallableStatement
			CallableStatement callableStmt=con.prepareCall(query);
			
			// 4 Execute procedure
			int rows=callableStmt.executeUpdate();
			
            System.out.println(rows +" Record inserted successfully using CallableStatement ");
			
			//5 closing connections
			con.close();
			callableStmt.close();	
		 }catch(Exception e) {
			 System.out.println(e);
			 e.getStackTrace();
		 }
	}

}
