package com.javalec.ex.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BWritecommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//폼에서 받아옴.
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		BDao dao=new BDao();
		int check=dao.write(bName,bTitle,bContent);
		//bId-seq, bDate>sysdate, bgroup seq bstep,bident>0
//		request.setAttribute("list", check);
	}

}
