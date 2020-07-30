package com.javalec.ex.BCommand.BoardCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BModifycommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BDto> list =new ArrayList<BDto>();
		int rnum=Integer.parseInt(request.getParameter("rnum"));
		int bId=Integer.parseInt(request.getParameter("bId"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		//넘어온 페이지 정보
		int page=Integer.parseInt(request.getParameter("page"));
		int searchflag=Integer.parseInt(request.getParameter("searchflag"));
		String category=request.getParameter("category");
		String searchcon=request.getParameter("searchcon");
		
		BDao dao=new BDao();
		int check=dao.modify(bId,bName,bTitle,bContent);
		//수정된 레코드를 다시 가져옴
		if(searchflag==1) {
			list=dao.content_view(bId,rnum);
		}
		else {
			list=dao.content_view(bId, rnum, category, searchcon);
		}
		
		request.setAttribute("content_view", list);
		request.setAttribute("check", check);
		request.setAttribute("rnum", rnum);
		request.setAttribute("page", page);
		request.setAttribute("searchflag", searchflag);
		request.setAttribute("category", category);
		request.setAttribute("searchcon", searchcon);

	}

}
