package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");	
		String password=request.getParameter("password");
//		System.out.println(email+" "+password);
		String query="select name, password from dashboardUsers where email=?";
		
		HttpSession session= request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			
			  // User not exists
			if(!rs.next()) {
				session.setAttribute("loginMsg", "User not found. Please register first.");
				response.sendRedirect("index.html");
//				System.out.println(email);
				return;
				
			}
			
			String dbPassword=rs.getString("password");
			
			 //  Check password
			if(!dbPassword.equals(password)) {
				session.setAttribute("loginMsg", "Invalid Password");
				response.sendRedirect("index.html");
//				System.out.println(password);
				return;
			}
			
			 // Login success
			session.removeAttribute("loginMsg");
			session.setAttribute("email", email);
			session.setAttribute("username", rs.getString("name"));
//			System.out.println(rs.getString("name"));
			response.sendRedirect("StudentDashboard.html");
//			System.out.println(email+" "+password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
