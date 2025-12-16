package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
    // why we ArrayList private(Protect data (encapsulation)) and static(Share data across all requests)
    private static ArrayList<Student> students= new ArrayList<>();
    
    
    
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		// read form data
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String ageStr=request.getParameter("age");
		String course=request.getParameter("course");
		
		   // Start HTML
	    writer.println("<!DOCTYPE html>");
	    writer.println("<html>");
	    writer.println("<head>");
	    writer.println("<meta charset='UTF-8'>");
	    writer.println("<title>Student Registration Result</title>");
	    
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
	    writer.println("a:hover { text-decoration: underline; }");
	    writer.println("</style>");

	    writer.println("</head>");
	    writer.println("<body>");
		
		if(name == null || name.trim().isEmpty() ||
		   email == null || email.trim().isEmpty() ||
		   ageStr == null || ageStr.trim().isEmpty() ||
		   course==null|| course.trim().isEmpty()) {
			writer.println("<h3 style=\"color:red\"> All fields are required</h3>");
			writer.println("<a href='StudentRegistration.html'>Go back</a>");
			return;
		}
		int age=Integer.parseInt(ageStr);
		
		if(age<18) {
			writer.println("<h3 style=\"color:red\"> Age must be 18 or above</h3>");
			writer.println("<a href='StudentRegistration.html'>Go back</a>");
			return;
		}
		
		Student student=new Student(name,email,age,course);
		students.add(student);
		
		writer.println("<h2>Student Reistered Successfully!</h2>");
		
//		writer.println("<table border='1'>");
		writer.println("<table>");
		writer.println("<tr><th>Name</th><th>Email</th><th>Age</th><th>Course</th></tr>");
		
		for(Student s:students) {
			writer.println("<tr>");
			writer.println("<td>"+ s.getName() +"</td>");
			writer.println("<td>"+ s.getEmail() +"</td>");
			writer.println("<td>"+ s.getAge() +"</td>");
			writer.println("<td>"+ s.getCourse() +"</td>");
			writer.println("</tr>");
		}
		
		writer.println("</table>");
		writer.println("<br><a href='StudentRegistration.html'>Add New Student</a>");
	
		writer.println("</body>");
		writer.println("</html>");
	
	}

}
