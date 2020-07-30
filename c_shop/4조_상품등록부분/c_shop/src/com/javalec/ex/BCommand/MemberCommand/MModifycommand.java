package com.javalec.ex.BCommand.MemberCommand;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.MDao.MDao;

public class MModifycommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email_head=request.getParameter("email_head");
		String email_tail=request.getParameter("email_tail");
		String address=request.getParameter("address");
		String phone_head=request.getParameter("phone_head");
		String phone_mid=request.getParameter("phone_mid");
		String phone_tail=request.getParameter("phone_tail");
		String news=request.getParameter("news");
		String sms=request.getParameter("sms");
		String birth_ = request.getParameter("birth");
		Date birth = java.sql.Date.valueOf(birth_);
		
		MDao dao=new MDao();
		int check=dao.mmodify(id, name, gender, email_head, email_tail, address, phone_head, phone_mid, phone_tail, news, sms, birth);
		
		
		request.setAttribute("m_check", check);
		
	}

}
