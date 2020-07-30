package com.javalec.ex.BCommand.MainCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.MDao.MDao;

public class ALogincommand implements MainCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session =request.getSession();
		int auth=Integer.parseInt(request.getParameter("auth"));
		String admin_id=request.getParameter("admin_id");
		String admin_pw=request.getParameter("admin_pw");
		
		MDao dao=new MDao();
		int check=dao.login(admin_id, admin_pw, auth, session);
		System.out.println(check);
		request.setAttribute("lcheck", check);
		
	}

}
