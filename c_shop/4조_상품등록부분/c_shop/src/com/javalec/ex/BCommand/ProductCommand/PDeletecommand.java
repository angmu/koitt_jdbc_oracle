package com.javalec.ex.BCommand.ProductCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.PDao.PDao;

public class PDeletecommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int pId=Integer.parseInt(request.getParameter("pId"));
		PDao dao=new PDao();
		int check = dao.pdelete(pId);
		System.out.println("커맨드체크값"+check);
		
		
		request.setAttribute("check", check);
		
		
	}

}
