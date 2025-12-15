package ScrollableandUpdatableResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableExample {

	public static void main(String[] args) throws SQLException {
		  Connection con = DriverManager.getConnection(
				  "jdbc:mysql://localhost:3306/jdbcex", "root", "8122003@Up");

		        Statement st = con.createStatement(
		            ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_READ_ONLY
		        );

		        ResultSet rs = st.executeQuery("SELECT * FROM employee");

		        rs.first();
		        System.out.println("First Row: " + rs.getString("name"));

		        rs.last();
		        System.out.println("Last Row: " + rs.getString("name"));

		        rs.absolute(2);
		        System.out.println("2nd Row: " + rs.getString("name"));

		        rs.relative(-1);
		        System.out.println("Previous Row: " + rs.getString("name"));

		        con.close();
	}

}
