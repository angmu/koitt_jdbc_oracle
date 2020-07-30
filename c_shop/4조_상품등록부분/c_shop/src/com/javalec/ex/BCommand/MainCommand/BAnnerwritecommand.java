package com.javalec.ex.BCommand.MainCommand;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.javalec.ex.PDao.PDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BAnnerwritecommand implements MainCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		PDao dao = new PDao();
		
		int check=0;
		//저장경로 지정
		
		String path = request.getSession().getServletContext().getRealPath("/pupload");
		//파일사이즈 지정-업로드 파일용량 제한
		int size = 1024 * 1024 * 10; //총 10 메가 용량 제한  
		//파일이름 설정
		String banner="";
		
		try{
			// request,파일 저장경로,용량,인코딩타입,
			//중복 파일명에 대한 정책(DefaultFileRenamePolicy-> 중복일 경우 (1),(2)..이런식으로 저장)
			
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			//파일이름 가져오기
			Enumeration files = multi.getFileNames();
			String name1 = (String) files.nextElement();
			banner = multi.getFilesystemName(name1);
			
			//b_orifile = multi.getOriginalFileName(name1); // 원본 이름을 가져올때(파일경로)
			
			check = dao.banner_write(banner); //게시글입력 메소드 호출
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("banner_check", check);
		
		
	}

}
