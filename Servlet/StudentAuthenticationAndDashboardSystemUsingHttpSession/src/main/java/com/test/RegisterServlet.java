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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");

        HttpSession session = request.getSession();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");

            //Check if email already exists
            PreparedStatement checkPs =
                    con.prepareStatement("SELECT email FROM dashboardUsers WHERE email=?");
            checkPs.setString(1, email);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                // Email already registered
                session.setAttribute("registerError", "Email already registered");
                response.sendRedirect("register.html");
                return;
            }

            // 2 Insert student data
            PreparedStatement insertPs =
                    con.prepareStatement(
                            "INSERT INTO dashboardUsers(name, email, password, phoneNo, course) VALUES(?,?,?,?,?)");

            insertPs.setString(1, name);
            insertPs.setString(2, email);
            insertPs.setString(3, password); // (Hash later)
            insertPs.setString(4, phone);
            insertPs.setString(5, course);

            int rows = insertPs.executeUpdate();

            if (rows > 0) {
                session.setAttribute("registerMsg", "Registration successful. Please login.");
                response.sendRedirect("index.html"); // login page
            } else {
                session.setAttribute("registerMsg", "Registration failed. Try again.");
                response.sendRedirect("register.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("registerError", "Server error. Try later.");
            response.sendRedirect("register.html");
        }
    }

}
