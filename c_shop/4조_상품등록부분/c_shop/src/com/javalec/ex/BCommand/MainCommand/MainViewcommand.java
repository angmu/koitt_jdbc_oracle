package com.javalec.ex.BCommand.MainCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.PDao.PDao;
import com.javalec.ex.PDto.PDto;

public class MainViewcommand implements MainCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		PDao dao=new PDao();
		ArrayList<PDto> list = dao.main_menu_view();
		String main_banner = dao.bannerget();
		
		request.setAttribute("main_menu", list);
		request.setAttribute("main_banner", main_banner);
		
	}

}
