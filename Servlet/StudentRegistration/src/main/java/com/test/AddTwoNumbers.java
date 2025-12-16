package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddTwoNumbers
 */
@WebServlet("/AddTwoNumbers")
public class AddTwoNumbers extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public AddTwoNumbers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");   // giving which type of response we are sending
		
		PrintWriter writer= response.getWriter();  //getWriter() method: returns PrintWriter interface used to print
		
		String aValue=request.getParameter("a");
		String bValue=request.getParameter("b");
		
		int a=Integer.parseInt(aValue);
		int b=Integer.parseInt(bValue);
		int c=a+b;
		if(c%2==0) {
			writer.println("<h1 style=\"color:green\">"+c+"</h1>");
		}else {
			writer.println("<h1 style=\"color:red  \">"+c+"</h1>");
		}
		writer.println("<a href=\"AddTwoNumbers.html\"> goto back</a>");
		
		
		
	}

}
