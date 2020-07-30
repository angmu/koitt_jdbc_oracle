package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BReplycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//update, 모두 업댓.. (보다보니 수정이 아니라 답글다는거같음..ㅇ,ㅇ,, )
		int bId=Integer.parseInt(request.getParameter("BId"));
		String bName=request.getParameter("BName");
		String bTitle=request.getParameter("BTitle");
		String bContent=request.getParameter("BContent");
		int bStep=Integer.parseInt(request.getParameter("BStep"));
		int bGroup=Integer.parseInt(request.getParameter("BGroup"));
		int bIndent=Integer.parseInt(request.getParameter("BIndent"));
		BDao dao=new BDao();
		int check=dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);
	}

}
