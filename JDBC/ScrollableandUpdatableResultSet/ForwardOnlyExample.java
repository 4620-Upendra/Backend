package ScrollableandUpdatableResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForwardOnlyExample {

	public static void main(String[] args) throws SQLException {
		 Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/jdbcex", "root", "8122003@Up");

//		        Statement st = con.createStatement(); // default type
		        Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);  // default type
		        ResultSet rs = st.executeQuery("SELECT * FROM employee");

		        while (rs.next()) {
		            System.out.println(
		                rs.getInt("id") + " " +
		                rs.getString("name") + " " +
		                rs.getDouble("salary")
		            );
		        }

		        con.close();

	}

}
