package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.BCommand;
import com.javalec.ex.BCommand.BEventlistCommand;
import com.javalec.ex.BCommand.BLoginCommand;

/**
 * Servlet implementation class BFront
 */
@WebServlet("*.do")
public class BFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFront() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		String comPath=request.getContextPath();
		String com=uri.substring(comPath.length());
		BCommand bcom=null;
		String viewPage=null;
		if(com.equals("/login.do")) {
			bcom=new BLoginCommand();
			bcom.execute(request, response);
			viewPage="index.jsp";
		}else if(com.equals("/event_list.do")) {
			bcom=new BEventlistCommand();
			bcom.execute(request, response);
			viewPage="event_list.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
