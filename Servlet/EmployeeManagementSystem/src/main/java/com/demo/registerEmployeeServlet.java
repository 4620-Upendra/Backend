package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;

/**
 * Servlet implementation class registerEmployeeServlet
 */
@WebServlet("/registerEmployeeServlet")
public class registerEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public registerEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");	
		PrintWriter out=response.getWriter();
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String name=request.getParameter("empName");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		int sal=Integer.parseInt(request.getParameter("salary"));
		String job=request.getParameter("job");
		String companyName=request.getParameter("companyName");
		String loc=request.getParameter("location");
		
		
		String query="insert into employee values(?,?,?,?,?,?,?,?)"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			PreparedStatement ps= con.prepareStatement(query);
			
			ps.setInt(1, empId);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setInt(5, sal);
			ps.setString(6, job);
			ps.setString(7, companyName);
			ps.setString(8, loc);
			
			int rows=ps.executeUpdate();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Employee Registration Status</title>");

	        out.println("<style>");
	        out.println("body{"
	                + "margin:0;"
	                + "font-family:Arial, sans-serif;"
	                + "background:linear-gradient(to right, #141e30, #243b55);"
	                + "color:white;"
	                + "height:100vh;"
	                + "display:flex;"
	                + "justify-content:center;"
	                + "align-items:center;"
	                + "}");

	        out.println(".box{"
	                + "background-color:rgba(0,0,0,0.65);"
	                + "padding:35px;"
	                + "width:450px;"
	                + "border-radius:12px;"
	                + "box-shadow:0 0 15px rgba(0,0,0,0.8);"
	                + "text-align:center;"
	                + "}");

	        out.println("h2{"
	                + "margin-bottom:25px;"
	                + "letter-spacing:1px;"
	                + "}");

	        out.println(".success h2{color:#00c6ff;}");
	        out.println(".fail h2{color:#ff6b6b;}");

	        out.println("p{"
	                + "font-size:15px;"
	                + "margin:10px 0;"
	                + "}");

	        out.println("a{"
	                + "display:block;"
	                + "margin-top:20px;"
	                + "width:100%;"
	                + "padding:12px;"
	                + "font-size:16px;"
	                + "font-weight:bold;"
	                + "border-radius:6px;"
	                + "text-decoration:none;"
	                + "background-color:#00c6ff;"
	                + "color:black;"
	                + "transition:0.3s;"
	                + "}");

	        out.println("a:hover{"
	                + "background-color:#00a2d1;"
	                + "color:white;"
	                + "}");
	        out.println("</style>");

	        out.println("</head>");
	        out.println("<body>");


			if (rows > 0) {
			    out.println("<div class='box success'>");
			    out.println("<h2>🎉 Employee Registered Successfully</h2>");
			    out.println("<p><b>Employee Name:</b> " + name + "</p>");
			    out.println("<p><b>Employee ID:</b> " + empId + "</p>");
			    out.println("<a href='registerEmployee.html'>Register Another Employee</a>");
			    out.println("</div>");
			} else {
			    out.println("<div class='box fail'>");
			    out.println("<h2>❌ Registration Failed</h2>");
			    out.println("<p>Something went wrong. Please try again.</p>");
			    out.println("<a href='registerEmployee.html'>Go Back</a>");
			    out.println("</div>");
			}

			out.println("</body>");
			out.println("</html>");

		        con.close();
		        ps.close();
			
		} catch (Exception e) {
				e.printStackTrace();
		
		
	   }

     }
}
