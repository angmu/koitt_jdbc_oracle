package com.javalec.ex.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;


public class BInsertcommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//객체선언 후 메소드 호출
		BDao dao=new BDao();
		int check=dao.insert();
		request.setAttribute("check", check);
	}
}
