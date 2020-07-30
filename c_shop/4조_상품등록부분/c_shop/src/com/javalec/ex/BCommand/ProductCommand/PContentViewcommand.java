package com.javalec.ex.BCommand.ProductCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.PDao.PDao;
import com.javalec.ex.PDto.PDto;

public class PContentViewcommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int pId=Integer.parseInt(request.getParameter("pId"));
		int page=Integer.parseInt(request.getParameter("page"));
		PDao dao=new PDao();
		PDto dto = dao.pcontent_view(pId);
		
		request.setAttribute("pcon", dto);
		request.setAttribute("page", page);
		
		
		
		
	}

}
