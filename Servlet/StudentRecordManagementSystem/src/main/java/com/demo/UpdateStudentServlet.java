package com.demo;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter writer=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		
		String query="update student_details set email=? where name=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex","root","8122003@Up");
			
			PreparedStatement pstmt= con.prepareStatement(query);
			
			pstmt.setString(1,email);
			pstmt.setString(2,name);
	
			
			
			int rows=pstmt.executeUpdate();
			System.out.print(rows+" updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<title>Update Success</title>");

        // Embedded CSS
        writer.println("<style>");
        writer.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }");
        writer.println(".container { max-width: 400px; margin: 100px auto; background: white; padding: 30px; "
                     + "border-radius: 10px; box-shadow: 0 0 15px rgba(0,0,0,0.2); text-align: center; }");
        writer.println("h2 { color: #2E8B57; margin-bottom: 20px; }");

        writer.println(".back-btn {");
        writer.println("background-color: #4CAF50;");
        writer.println("color: white;");
        writer.println("padding: 12px 20px;");
        writer.println("border: none;");
        writer.println("border-radius: 5px;");
        writer.println("cursor: pointer;");
        writer.println("font-size: 16px;");
        writer.println("font-weight: bold;");
        writer.println("transition: 0.3s;");
        writer.println("}");

        writer.println(".back-btn:hover { background-color: #45a049; }");
        writer.println("</style>");

        writer.println("</head>");
        writer.println("<body>");

        writer.println("<div class='container'>");
        writer.println("<h2>Student Updated Successfully</h2>");

        // Back to Update page (change to mainStudent.html if needed)
        writer.println("<form action='UpdateStudent.html'>");
        writer.println("<button type='submit' class='back-btn'>Back to Update Page</button>");
        writer.println("</form>");

        writer.println("</div>");

        writer.println("</body>");
        writer.println("</html>");
	}

}
