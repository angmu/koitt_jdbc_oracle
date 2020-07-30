package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ok
 */
@WebServlet("/Ok")
public class Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ok() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		writer.println("<html><head></head>");
		writer.println("<body>");
		writer.println("hello java");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
