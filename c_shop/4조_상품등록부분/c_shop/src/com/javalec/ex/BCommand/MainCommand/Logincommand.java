package com.javalec.ex.BCommand.MainCommand;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.MDao.MDao;

public class Logincommand implements MainCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session =request.getSession();
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		MDao dao=new MDao();
		int check=dao.login(id, pw, session);
		request.setAttribute("check", check);
		
	}
}
