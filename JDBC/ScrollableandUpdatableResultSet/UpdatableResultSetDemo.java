package ScrollableandUpdatableResultSet;

import java.sql.*;

public class UpdatableResultSetDemo {

	public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/jdbcex", "root", "8122003@Up");

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE
        );

        ResultSet rs = st.executeQuery(
            "SELECT id, name, salary FROM employee"
        );

        // UPDATE
        rs.absolute(1);
        rs.updateDouble("salary", 80000);
        rs.updateRow();

        // INSERT
        rs.moveToInsertRow();
        rs.updateInt("id", 130);
        rs.updateString("name", "Ramesh");
        rs.updateDouble("salary", 50000);
        rs.insertRow();
        rs.moveToCurrentRow();

        // DELETE
        rs.absolute(2);
        rs.deleteRow();

        con.close();

	}

}
