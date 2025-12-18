package com.demo;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class SelectStudent
 */
@WebServlet("/SelectStudent")
public class SelectStudent extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public SelectStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter writer=response.getWriter();
		
		
		writer.println("<!DOCTYPE html>");
	    writer.println("<html>");
	    writer.println("<head>");
	    writer.println("<meta charset='UTF-8'>");
	    writer.println("<title>Selected Students Details</title>");
	    
	    // Embedded CSS
	    writer.println("<style>");
	    writer.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }");
	    writer.println("h2 { color: #2E8B57; text-align: center; }");
	    writer.println("h3 { color: red; text-align: center; }");
	    writer.println("table { border-collapse: collapse; width: 70%; margin: 20px auto; background-color: #fff; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
	    writer.println("th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }");
	    writer.println("th { background-color: #4CAF50; color: white; }");
	    writer.println("tr:nth-child(even) { background-color: #f9f9f9; }");
	    writer.println("a { display: block; text-align: center; margin-top: 20px; text-decoration: none; color: #0066cc; font-weight: bold; }");
	    writer.println("a:hover { text-decoration: none; }");
	    writer.println(".back-btn {");
	    writer.println("display: inline-block;");
	    writer.println("background-color: #2E8B57;");
	    writer.println("color: white;");
	    writer.println("padding: 10px 20px;");
	    writer.println("border-radius: 5px;");
	    writer.println("text-decoration: none;");
	    writer.println("font-weight: bold;");
	    writer.println("font-family: Arial;");
	    writer.println("margin: 30px auto;");
	    writer.println("transition: all 0.3s ease;");
	    writer.println("}");

	    writer.println(".back-btn:hover {");
	    writer.println("background-color: #256b45;");
	    writer.println("box-shadow: 0 4px 10px rgba(0,0,0,0.2);");
	    writer.println("transform: translateY(-2px);");
	    writer.println("}");

	    writer.println("</style>");

	    writer.println("</head>");
	    writer.println("<body>");
	    
	   writer.println("<h2>Details of "+ request.getParameter("name") +" Student </h2>");
		
//		writer.println("<table border='1'>");
		writer.println("<table>");
		writer.println("<tr><th>Name</th><th>Email</th><th>Age</th><th>Course</th></tr>");
		
        String query="select * from student_details where name=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			
			PreparedStatement pstmt= con.prepareStatement(query);
			
			pstmt.setString(1, request.getParameter("name"));
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				writer.println("<tr>");
				writer.println("<td>"+ rs.getString("name") +"</td>");
				writer.println("<td>"+ rs.getString("email") +"</td>");
				writer.println("<td>"+ rs.getInt("age") +"</td>");
				writer.println("<td>"+ rs.getString("course") +"</td>");
				writer.println("</tr>");
			}
			writer.println("</table>");
//			writer.println("<br><a href='SelectStudent.html'>Back to select student Page</a>");
			writer.println(
				    "<div style='text-align:center;'>" +
				    "<a href='SelectStudent.html' class='back-btn'>Back to select student Page</a>" +
				    "</div>"
				);

			writer.println("</body>");
			writer.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
