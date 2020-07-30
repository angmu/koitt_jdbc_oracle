package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BModifycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//update, 모두 업댓.. (보다보니 수정이 아니라 답글다는거같음..ㅇ,ㅇ,, )
		int bId=Integer.parseInt(request.getParameter("BId"));
		String bTitle=request.getParameter("BTitle");
		String bContent=request.getParameter("BContent");
		BDao dao=new BDao();
		int check=dao.modify(bId,bTitle,bContent);
	}

}
