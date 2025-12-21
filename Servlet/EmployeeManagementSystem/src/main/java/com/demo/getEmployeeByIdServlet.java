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
import java.sql.ResultSet;
//import java.sql.SQLException;

/**
 * Servlet implementation class getEmployeeByIdServlet
 */
@WebServlet("/getEmployeeByIdServlet")
public class getEmployeeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEmployeeByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empid=Integer.parseInt(request.getParameter("empId"));
		String query="select * from employee where empid=?";
		

        boolean found = false;
        int id = 0,salary = 0,age=0;
        String name = null, gender = null, job = null ,companyName=null,loc=null;
        
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Get Employee By ID</title>");
        out.println("<style>");
        out.println("body{margin:0;font-family:Arial,sans-serif;"
                + "background:linear-gradient(to right,#141e30,#243b55);"
                + "color:white;height:100vh;display:flex;"
                + "justify-content:center;align-items:center;}");
        out.println(".box{background-color:rgba(0,0,0,0.65);padding:35px;"
                + "width:480px;border-radius:12px;"
                + "box-shadow:0 0 15px rgba(0,0,0,0.8);}");
        out.println("h2{text-align:center;margin-bottom:25px;}");
        out.println(".success h2{color:#00c6ff;}");
        out.println(".fail h2{color:#ff6b6b;}");
        out.println("p{font-size:15px;margin:8px 0;}");
        out.println("a{display:block;margin-top:20px;padding:12px;"
                + "text-align:center;font-size:16px;font-weight:bold;"
                + "border-radius:6px;text-decoration:none;"
                + "background-color:#00c6ff;color:black;}");
        out.println("a:hover{background-color:#00a2d1;color:white;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, empid);
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				found=true;
			    id = rs.getInt("empid");         
			    name = rs.getString("name");      
			    age = rs.getInt("age");
			    gender = rs.getString("gender");
			    job = rs.getString("job");
			    companyName = rs.getString("companyname");
			    loc = rs.getString("loc");
			    salary = rs.getInt("sal");
			}
			if (found) {
			    out.println("<div class='box success'>");
			    out.println("<h2>✅ Employee Found</h2>");

			    out.println("<table style='width:100%; border-collapse:collapse;'>");

			    out.println("<tr><td><b>Employee ID</b></td><td>" + id + "</td></tr>");
			    out.println("<tr><td><b>Name</b></td><td>" + name + "</td></tr>");
			    out.println("<tr><td><b>Age</b></td><td>" + age + "</td></tr>");
			    out.println("<tr><td><b>Gender</b></td><td>" + gender + "</td></tr>");
			    out.println("<tr><td><b>Job Role</b></td><td>" + job + "</td></tr>");
			    out.println("<tr><td><b>Company Name</b></td><td>" + companyName + "</td></tr>");
			    out.println("<tr><td><b>Location</b></td><td>" + loc + "</td></tr>");
			    out.println("<tr><td><b>Salary</b></td><td>₹" + salary + "</td></tr>");

			    out.println("</table>");

			    out.println("<a href='selectEmployeeById.html' style='display:block;margin-top:20px;'>"
			            + "Search Another Employee</a>");
			    out.println("</div>");
			} else {
			    out.println("<div class='box fail'>");
			    out.println("<h2>❌ Employee Not Found</h2>");
			    out.println("<p>No employee exists with ID: <b>" + empid + "</b></p>");
			    out.println("<a href='selectEmployeeById.html'>Go Back</a>");
			    out.println("</div>");
			}
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());			
		} 
		
		
	}

}
