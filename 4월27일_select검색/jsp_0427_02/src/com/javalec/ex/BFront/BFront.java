package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.BCommand;
import com.javalec.ex.BCommand.BContentcommand;
import com.javalec.ex.BCommand.BInsertcommand;
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
		
		//
		String pageView=null;
		BCommand bcom=null;
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		if(com.equals("/list.do")) {
			//list메소드 호출 (조상의 참조변수로 자손객체를 받는것 > 다형성
			bcom=new BListcommand();
			bcom.execute(request, response);
			pageView="list.jsp";
		}else if(com.equals("/content_view.do")) {
			//list메소드 호출 (조상의 참조변수로 자손객체를 받는것 > 다형성
			bcom=new BContentcommand();
			bcom.execute(request, response);
			pageView="content_view.jsp";
		}else if(com.equals("/write.do")) {
			//list메소드 호출 (조상의 참조변수로 자손객체를 받는것 > 다형성
			bcom=new BWritecommand();
			bcom.execute(request, response);
			pageView="list.jsp";
		}else if(com.equals("/write_view.do")) {
			//list메소드 호출 (조상의 참조변수로 자손객체를 받는것 > 다형성
			bcom=new BWritecommand();
			bcom.execute(request, response);
			pageView="write_view.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
		
	}
}
