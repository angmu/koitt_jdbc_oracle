package com.javalec.ex.BCommand.MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.MDao.MDao;

public class MIdcheckcommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id_ch = request.getParameter("id_ch");
		MDao dao = new MDao();
		int check=dao.idcheck(id_ch);
		
		request.setAttribute("check", check);
		request.setAttribute("id_ch", id_ch);

	}

}
