package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		String aValue=request.getParameter("a");
		String bValue=request.getParameter("b");
		String operator=request.getParameter("op");
		
		try {
			int a=Integer.parseInt(aValue);
			int b=Integer.parseInt(bValue);
			
			switch(operator) {
			case "+":writer.println("<h1 style=\"color:aqua\">"+a+" "+operator+" "+b+" "+" = "+(a+b)+"<h1>");
				     break;
			case "-":writer.println("<h1 style=\"color:aqua\">"+a+" "+operator+" "+b+" "+" = "+(a-b)+"<h1>");
		             break;
			case "*":writer.println("<h1 style=\"color:aqua\">"+a+" "+operator+" "+b+" "+" = "+(a*b)+"<h1>");
		             break;
			case "%":writer.println("<h1 style=\"color:aqua\">"+a+" "+operator+" "+b+" "+" = "+(a%b)+"<h1>");
		             break;
			case "/":writer.println("<h1 style=\"color:aqua\">"+a+" "+operator+" "+b+" "+" = "+(a/b)+"<h1>");
                     break;
			default:
				writer.println("<h1 style=\"color:aqua\">Invalid operator<h1>");
			}
			
			
		}catch(Exception e) {
			writer.println(e.getMessage());
		}
		
		writer.println("<a href=\"Calculator.html\"> goto back</a>");
	}

}
