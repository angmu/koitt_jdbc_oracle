package com.javalec.ex.BCommand.EventCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.javalec.ex.EDto.EDto;

public class EContentViewcommand implements EventCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int eId=Integer.parseInt(request.getParameter("eId")) ;
		int rnum=Integer.parseInt(request.getParameter("rnum")) ;
		int page=Integer.parseInt(request.getParameter("page"));
		ArrayList<EDto> list = new ArrayList<EDto>();
		
		EDao dao = new EDao();
		list = dao.eContentView(eId,rnum);
		int size=list.size();
		
		request.setAttribute("econtent_view", list);
		request.setAttribute("size", size);
		request.setAttribute("rnum", rnum);
		request.setAttribute("page", page);
		
	}

}
