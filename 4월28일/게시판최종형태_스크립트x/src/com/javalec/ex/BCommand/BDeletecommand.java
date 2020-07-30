package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BDeletecommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//폼에서 받아옴.
		int bId=Integer.parseInt(request.getParameter("bId"));
		BDao dao=new BDao();
		int check=dao.delete(bId);
		//bId-seq, bDate>sysdate, bgroup seq bstep,bident>0
//		request.setAttribute("list", check);
	}

}
