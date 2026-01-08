package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class RegisterMessageServlet
 */
@WebServlet("/RegisterMessageServlet")
public class RegisterMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String msg="";
		
		if(session!=null && session.getAttribute("registerMsg")!=null) {
			msg=(String)session.getAttribute("registerMsg");
			session.removeAttribute("registerMsg");
			response.setContentType("text/plain");
			response.getWriter().write(msg);
			return;
		}
		if(session!=null && session.getAttribute("registerError")!=null) {
			msg=(String)session.getAttribute("registerError");
			session.removeAttribute("registerError");
		}
		response.setContentType("text/plain");
		response.getWriter().write(msg);
	}

}
