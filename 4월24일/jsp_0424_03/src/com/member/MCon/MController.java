package com.member.MCon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost호출");
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String con=uri.substring(conPath.length());
		String viewpage=null;
		if(con.equals("/select.do")) {
			
			viewpage="select.jsp";
		}else if(con.equals("/insert.do")) {
			

			viewpage="insert.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}
}
