package com.javalec.ex.BCommand.BoardCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BContentViewcommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int size=0;// 첫글또는 마지막글-2,보통글-3
		int bId=Integer.parseInt(request.getParameter("bId")) ;
		int rnum=Integer.parseInt(request.getParameter("rnum")) ;
		int page=Integer.parseInt(request.getParameter("page"));
		int searchflag=Integer.parseInt(request.getParameter("searchflag"));
		String category="";
		String searchcon="";
		ArrayList<BDto> list=new ArrayList<BDto>();
		BDao dao = new BDao();
		//검색으로 들어온건지 구분해서 분기
		if(searchflag==1) {
			list = dao.content_view(bId,rnum);
			size =list.size();
		}
		else if(searchflag==2) {
			category=request.getParameter("category");
			searchcon=request.getParameter("searchcon");
			System.out.println(category);
			System.out.println(searchcon);
			list = dao.content_view(bId, rnum, category, searchcon);
			size = list.size();
		}
		System.out.println(size);
		//검색관련
		request.setAttribute("searchflag", searchflag);
		request.setAttribute("category", category);
		request.setAttribute("searchcon", searchcon);
		//공통
		request.setAttribute("content_view", list);
		request.setAttribute("size", size);
		request.setAttribute("rnum", rnum);
		request.setAttribute("page", page);
	}

}
