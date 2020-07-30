package com.javalec.ex.BCommand.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BDeletecommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId=Integer.parseInt(request.getParameter("bId"));
		BDao dao=new BDao();
		int check=dao.delete(bId);
		
		request.setAttribute("check", check);

	}

}
