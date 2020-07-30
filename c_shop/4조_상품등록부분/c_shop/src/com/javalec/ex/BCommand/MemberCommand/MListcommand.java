package com.javalec.ex.BCommand.MemberCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.MDao.MDao;
import com.javalec.ex.MDto.MDto;

public class MListcommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MDao dao=new MDao();
		ArrayList<MDto> list =  dao.getMembers();
		
		request.setAttribute("list", list);
		
	}

}
