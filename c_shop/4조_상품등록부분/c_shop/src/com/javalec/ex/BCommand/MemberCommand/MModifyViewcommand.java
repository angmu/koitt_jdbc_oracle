package com.javalec.ex.BCommand.MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.MDao.MDao;
import com.javalec.ex.MDto.MDto;

public class MModifyViewcommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		MDao dao=new MDao();
		MDto dto = dao.getMember(id);
		
		request.setAttribute("dto", dto);
		
	}

}
