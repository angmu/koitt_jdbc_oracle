package com.javalec.ex.BCommand.EventCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.javalec.ex.EDto.EDto;

public class EContentViewcommand2 implements EventCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum=Integer.parseInt(request.getParameter("rnum"));
		int eId=Integer.parseInt(request.getParameter("eId")) ;
		int page=Integer.parseInt(request.getParameter("page"));
		
		EDao dao = new EDao();
		EDto dto = dao.eContentView2(eId);
		request.setAttribute("rnum", rnum);
		request.setAttribute("econtent_view", dto);
		request.setAttribute("page", page);
		
	}

}
