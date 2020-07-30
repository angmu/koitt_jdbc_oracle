package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.MemberDao;
import com.javalec.ex.BDto.BMemberDto;

public class BLoginCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println(id);
		String pw=request.getParameter("pw");
		int check=0;
		MemberDao mdao=new MemberDao();
		check=mdao.login_check(id,pw);
		if(check==1) {
			BMemberDto dto=mdao.getMember(id);
			request.setAttribute("authuser", id);
			request.setAttribute("nickname", dto.getName());
			System.out.println(id+" "+dto.getName());
		}
	}

}
