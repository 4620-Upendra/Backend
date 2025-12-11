package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.util.Arrays;

public class BatchProcessingUsingPreparedStatement {

	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		String query="insert into student value(?,?,?,?);";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			
			PreparedStatement ps=con.prepareStatement(query);
			
			// 1st record
			ps.setInt(1, 201);
			ps.setString(2, "Kiran");
			ps.setInt(3, 23);
			ps.setString(4, "chinnai");
			ps.addBatch();
			
			// 2nd record
            ps.setInt(1, 202);
            ps.setString(2, "Manoj");
            ps.setInt(3, 24);
            ps.setString(4, "bengaluru");
			ps.addBatch();
			
			 // 3rd record
            ps.setInt(1, 203);
            ps.setString(2, "Sita");
            ps.setInt(3, 20);
            ps.setString(4, "coimbatore");
            ps.addBatch();
			
            int[] result = ps.executeBatch();
//            System.out.println(Arrays.toString(result));
            System.out.println("PreparedStatement Batch executed successfully!");
            
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
