package Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataInTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String URL="jdbc:mysql://localhost:3306/";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		// query to run on database
		String query="insert into student values(1,'upendra',22,'Hyderabad')";
		
		// step1: Load the JDBC driver(Latest JDBC versions load automatically)
		Class.forName("com.mysql.cj.jdbc.Driver");      // gives exception handling by using throw keyword
		
		// step2: Establish connection using DriverManager.getConnection()
		Connection con=DriverManager.getConnection(URL+"jdbcex", USER, PASSWORD);
		
		// step3: Create a Statement
		Statement st=con.createStatement();
		
		// step4: Execute SQL queries
		int rows=st.executeUpdate(query);
		
		if(rows>0) {
			 System.out.println("Data Inserted Successfully");
		}else {
			System.out.println("Data Insertion Failed");
		}
		// step5: Process the ResultSet (if any)
		
		// step 6:Close the connection
		con.close();
		st.close();
	}

}
