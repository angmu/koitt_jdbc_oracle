package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.BCommand;
import com.javalec.ex.BCommand.BListcommand;

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
		String viewPage=null;
		BCommand comm=null;
		
		//
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		//호출 페이지 분기
		if(com.equals("/list.do")) {
			BListcommand bcomm=new BListcommand();
			bcomm.execute(request, response);
			viewPage="list.jsp";
		}else if(com.equals("/write.do")) {
//			BListcommand bcomm=new BWritecommand();
//			bcomm.execute(request, response);
			viewPage="write.jsp";
		}else if(com.equals("/content_view.do")) {
//			BListcommand bcomm=new BContentcommand();
//			bcomm.execute(request, response);
			viewPage="content_view.jsp";
		}else if(com.equals("/reply_view.do")) {
//			BListcommand bcomm=new BReplyViewcommand();
//			bcomm.execute(request, response);
			viewPage="reply_view.jsp";
		}
		//호출한 페이지  request객체와 함께 이동
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
