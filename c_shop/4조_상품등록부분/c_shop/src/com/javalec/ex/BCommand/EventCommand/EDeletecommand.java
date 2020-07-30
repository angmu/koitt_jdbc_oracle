package com.javalec.ex.BCommand.EventCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;

public class EDeletecommand implements EventCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int eId=Integer.parseInt(request.getParameter("eId"));
		EDao dao=new EDao();
		int check=dao.edelete(eId);
		
		request.setAttribute("check", check);

	}

}
