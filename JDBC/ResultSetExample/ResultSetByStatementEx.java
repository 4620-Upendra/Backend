package ResultSetExample;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;



public class ResultSetByStatementEx {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		String query="select * from student where age>21";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		Statement st=con.createStatement();

		ResultSet rs=st.executeQuery(query);
		
		DatabaseMetaData dbMeta=con.getMetaData();
		
		System.out.println(dbMeta.getDatabaseProductName());
		System.out.println(dbMeta.getDriverName());
		System.out.println(dbMeta.getURL());
		System.out.println(dbMeta.getDriverVersion());
		
		ResultSetMetaData gmd=rs.getMetaData();      // rs.getMetaData() :give data in resultset 
//		System.out.println("number columns in table:"+gmd.getColumnCount());     //getColumnCount():gives count of columns in result
		
		for(int i=1;i<=gmd.getColumnCount();i++) {
			System.out.println(gmd.getColumnName(i));   //gives names of column 
		}
		
		
//		System.out.println("id"+"\t"+"name"+"\t"+"age"+"\t"+"city");
//		System.out.println("--------------------------------------");
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
//		}
		
		con.close();
		rs.close();	
	}

}
