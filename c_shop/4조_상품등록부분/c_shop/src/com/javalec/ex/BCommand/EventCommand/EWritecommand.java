package com.javalec.ex.BCommand.EventCommand;

import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EWritecommand implements EventCommand {
	int eId,eFlag;
	String eTitle,eTitleimg,eContentimg,eDate;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EDao dao = new EDao();
		String eTitle="";
		String eDate_start_="";
		String eDate_end_="";
		
		int check=0;
		//저장경로 지정
		
		String path = request.getSession().getServletContext().getRealPath("/upload");
		//파일사이즈 지정-업로드 파일용량 제한
		int size = 1024 * 1024 * 10; //총 10 메가 용량 제한  
		//파일이름 설정
		String eTitleimg="";
		String eContentimg="";
		//파일 예전 이름
		String b_orifile="";
		
		try{
			// request,파일 저장경로,용량,인코딩타입,
			//중복 파일명에 대한 정책(DefaultFileRenamePolicy-> 중복일 경우 (1),(2)..이런식으로 저장)
			
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			eTitle = multi.getParameter("eTitle");
			eDate_start_ = multi.getParameter("eDate_start");
			Date eDate_start = java.sql.Date.valueOf(eDate_start_);
			eDate_end_ = multi.getParameter("eDate_end");
			Date eDate_end = java.sql.Date.valueOf(eDate_end_);
			//파일이름 가져오기
			Enumeration files = multi.getFileNames();
			String name1 = (String) files.nextElement();
			eTitleimg = multi.getFilesystemName(name1);
			String name2 = (String) files.nextElement(); // 파일 한개더 있을때
			eContentimg = multi.getFilesystemName(name2);
			
			//b_orifile = multi.getOriginalFileName(name1); // 원본 이름을 가져올때(파일경로)
			
			check = dao.ewrite(eTitle,eDate_start,eDate_end,eTitleimg,eContentimg); //게시글입력 메소드 호출
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("check", check);
		
	}//execute

}//class
