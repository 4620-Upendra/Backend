package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet implementation class EvenOrOdd
 */
@WebServlet("/EvenOrOdd")
public class EvenOrOdd extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public EvenOrOdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String aValue=request.getParameter("a");
		
		int num=Integer.parseInt(aValue);
		if(num%2==0) {
			System.out.println(num+": even number");
		}else {
			System.out.println(num+": odd nuumber");
		}
		int count=0;
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				count++; 
			}
		}
		if(count==0) {
			System.out.println(num+": is prime number");
		}else {
			System.out.println(num+": not prime number");
		}
	}

}
