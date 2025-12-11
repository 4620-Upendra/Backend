package BatchProcessing;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
//import java.util.Arrays;

public class BatchProcessingusingStatement {

	public static void main(String[] args) {
		
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			
			Statement st=con.createStatement();
			
			st.addBatch("Insert into student values(4,'bishop',25,'bhimavaram')");
			st.addBatch("INSERT INTO student VALUES(102, 'Priya', 21,'delhi')");
            st.addBatch("UPDATE student SET age = 25 WHERE id = 1");
            
            //Execute batch
            int [] result=st.executeBatch();
            
//          System.out.println(Arrays.toString(result));
            System.out.println("Batch executed successfully");
            
            con.close();
            st.close();
            
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
