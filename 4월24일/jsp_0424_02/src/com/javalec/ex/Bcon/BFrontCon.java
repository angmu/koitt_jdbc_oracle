package com.javalec.ex.Bcon;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.DAO.MemberDao;
import com.javalec.ex.DTO.MemberDto;

//모든 확장자가 .do로 끝나는건 다 여기로 들어온다는 뜻
@WebServlet("*.do")
public class BFrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFrontCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet들어옴");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost들어옴");
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 이동에 사용하는 변수
		String viewPage=null;
		
		System.out.println("actionDo들어옴");
		request.setCharacterEncoding("utf-8");
		//url> http://localhost:8181/jsp_0424_02/insert
		//uri> /jsp_0424_02/insert
		String uri=request.getRequestURI();
		System.out.println(uri);
		//contextPath> /jsp_0424_02
		String conPath=request.getContextPath();
		System.out.println(conPath);
		//file명 = /insert (어느 페이지에서 넘어오는지 확인하는 용도)
		String com=uri.substring(conPath.length());
		System.out.println(com);
		if(com.equals("/insert.do")) {
			System.out.println("insert페이지를 요청");
			//insert.jsp로 forwarding
			//dao메소드 호출해서 값을 받아서request.setAttribute
			//임시
			request.setAttribute("insert_com", com);
			viewPage="insert.jsp";
		}else if(com.equals("/update.do")) {
			System.out.println("update페이지를 요청");
			//update.jsp로 forwarding
			request.setAttribute("update_com", com);
			viewPage="update.jsp";
		}
		
		//이거만 업글해따!!!!!!!!!!!!!!!!!!!!!!
		else if(com.equals("/select.do")) {
			System.out.println("select페이지를 요청");
			//select.jsp로 forwarding
			ArrayList<MemberDto> list=new ArrayList<MemberDto>();
			MemberDao mdao=MemberDao.getInstance();
			//이후 1과 2만 남기고 다른페이지로 또 보낸다..
			list=mdao.getMembers(); //1
			request.setAttribute("dtos", list);
			request.setAttribute("select_com", com);
			viewPage="select.jsp";//2
		}
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		else if(com.equals("/delete.do")) {
			System.out.println("delete페이지를 요청");
			//delete.jsp로 forwarding
			request.setAttribute("delete_com", com);
			viewPage="delete.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
