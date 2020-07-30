package com.javalec.ex.BCommand.BoardCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BContentViewcommand2 implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId=Integer.parseInt(request.getParameter("bId")) ;
		int rnum=Integer.parseInt(request.getParameter("rnum")) ;
		System.out.println(bId);
		int page=Integer.parseInt(request.getParameter("page"));
		int searchflag=Integer.parseInt(request.getParameter("searchflag"));
		String category=request.getParameter("category");
		String searchcon=request.getParameter("searchcon");
		
		BDao dao = new BDao();
		BDto dto = dao.content_view2(bId);
		request.setAttribute("content_view", dto);
		request.setAttribute("rnum", rnum);
		request.setAttribute("page", page);
		request.setAttribute("searchflag", searchflag);
		request.setAttribute("category", category);
		request.setAttribute("searchcon", searchcon);
	}

}
