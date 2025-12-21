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

/**
 * Servlet implementation class ViewAllEmployeesServlet
 */
@WebServlet("/ViewAllEmployeesServlet")
public class ViewAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployeesServlet() {
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
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("""
	        <!DOCTYPE html>
	        <html>
	        <head>
	            <title>View All Employees</title>
	            <style>
	                body {
	                    margin: 0;
	                    font-family: Arial, sans-serif;
	                    background: linear-gradient(to right, #141e30, #243b55);
	                    color: white;
	                    min-height: 100vh;
	                    padding: 20px;
	                }
	                h1 {
	                    text-align: center;
	                    margin-bottom: 30px;
	                }
	                table {
	                    width: 100%;
	                    border-collapse: collapse;
	                    background-color: rgba(255, 255, 255, 0.1);
	                }
	                th, td {
	                    padding: 12px;
	                    text-align: center;
	                    border-bottom: 1px solid rgba(255, 255, 255, 0.3);
	                }
	                th {
	                    background-color: rgba(0, 0, 0, 0.4);
	                }
	                tr:hover {
	                    background-color: rgba(255, 255, 255, 0.15);
	                }
	                .btn {
	                    display: inline-block;
	                    margin-top: 20px;
	                    padding: 10px 20px;
	                    background-color: #00c6ff;
	                    color: black;
	                    text-decoration: none;
	                    border-radius: 5px;
	                    font-weight: bold;
	                }
	                .btn:hover {
	                    background-color: #009edc;
	                }
	                .footer {
	                    text-align: center;
	                    margin-top: 30px;
	                    opacity: 0.8;
	                }
	            </style>
	        </head>
	        <body>

	        <h1>All Employee Details</h1>

	        <table>
	            <tr>
	                <th>Employee ID</th>
	                <th>Name</th>
	                <th>Age</th>
	                <th>Gender</th>
	                <th>Job</th>
	                <th>Company</th>
	                <th>Location</th>
	                <th>Salary</th>
	            </tr>
	        """);

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/jdbcex",
	                    "root",
	                    "8122003@Up");

	            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee");
	            ResultSet rs = ps.executeQuery();

	            // 🔁 LOOP THROUGH EACH EMPLOYEE
	            while (rs.next()) {

	                int id = rs.getInt("empid");
	                String name = rs.getString("name");
	                int age = rs.getInt("age");
	                String gender = rs.getString("gender");
	                String job = rs.getString("job");
	                String companyName = rs.getString("companyname");
	                String loc = rs.getString("loc");
	                int salary = rs.getInt("sal");

	                out.println("<tr>");
	                out.println("<td>" + id + "</td>");
	                out.println("<td>" + name + "</td>");
	                out.println("<td>" + age + "</td>");
	                out.println("<td>" + gender + "</td>");
	                out.println("<td>" + job + "</td>");
	                out.println("<td>" + companyName + "</td>");
	                out.println("<td>" + loc + "</td>");
	                out.println("<td>" + salary + "</td>");
	                out.println("</tr>");
	            }

	            con.close();

	        } catch (Exception e) {
	            out.println("<tr><td colspan='8'>Error: " + e.getMessage() + "</td></tr>");
	        }

	        out.println("""
	        </table>

	        <center>
	            <a href="index.html" class="btn">Back to Home</a>
	        </center>

	        <div class="footer">
	            © 2025 Employee Management System | Developed by Upendra
	        </div>

	        </body>
	        </html>
	        """);
	}

}
