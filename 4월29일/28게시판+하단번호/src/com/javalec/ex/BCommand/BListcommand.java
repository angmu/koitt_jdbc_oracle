package com.javalec.ex.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BListcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int page=1;//최초기본 1페이지 세팅
		int limit=10;//1페이지=게시글 10개
		
		//page가 넘어온게 있을경우..ex)4..
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		// TODO Auto-generated method stub
		BDao dao=new BDao();
		//페이지별 리스트 개수를 가져오기
		ArrayList<BDto> dtos=dao.list(page,limit);
		//전체 게시글 count(*)
		int listcount=dao.getlistCount();
		//최대 페이지 수
		int maxpage=(int)((double)listcount/limit+0.95);
		//처음페이지
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		
		//마지막페이지
		int endpage=maxpage; // 총 페이지 개수가 1~10까지는 maxpage가 endpage가 됨.
		//11페이지 이후 endpage
		if(endpage>startpage+10-1) endpage=startpage+10-1;
		
		request.setAttribute("list", dtos);
		//하단 페이지 번호를 위한 5개의 변수
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		System.out.println(listcount+" "+page+" "+maxpage+" "+startpage+" "+endpage+" ");
	}

}
