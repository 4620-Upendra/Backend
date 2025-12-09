package ResultSetExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetByPreparedStatementEx {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		Scanner sc=new Scanner(System.in);
		
		String query="select * from student where age>?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		PreparedStatement ps=con.prepareStatement(query);
		
		System.out.print("enter the age:");
		ps.setInt(1, sc.nextInt());
		
		ResultSet rs=ps.executeQuery();
		
		
		System.out.println("id"+"\t"+"name"+"\t"+"age"+"\t"+"city");
		System.out.println("--------------------------------------");
		while(rs.next()) {
//			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
//			or    rs.getDatatype(columnidex or column name)
			System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("age")+"\t"+rs.getString("city"));
			
		}
		
		con.close();
		ps.close();
		rs.close();	
		sc.close();
	}

}
