package com.javalec.ex.BCommand.ProductCommand;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.javalec.ex.PDao.PDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PWritecommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		PDao dao = new PDao();
		String pContent="";
		String pCategory="";
		String pName="";
		int pPrice=0;
		int pDelivery=0;
		int pAmount=0;
		int pTime=0;
		
		int check=0;
		//저장경로 지정
		
		String path = request.getSession().getServletContext().getRealPath("/pupload");
		//파일사이즈 지정-업로드 파일용량 제한
		int size = 1024 * 1024 * 10; //총 10 메가 용량 제한
		
		//파일이름 설정
		String pTitleimg="";
		String pContentimg1="";
		String pContentimg2="";
		
		try{
			// request,파일 저장경로,용량,인코딩타입,
			//중복 파일명에 대한 정책(DefaultFileRenamePolicy-> 중복일 경우 (1),(2)..이런식으로 저장)
			
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			pName = multi.getParameter("pName");
			pCategory = multi.getParameter("pCategory");
			pContent = multi.getParameter("pContent");
			pPrice = Integer.parseInt(multi.getParameter("pPrice").trim());
			pDelivery = Integer.parseInt(multi.getParameter("pDelivery").trim());
			pAmount = Integer.parseInt(multi.getParameter("pAmount").trim());
			pTime = Integer.parseInt(multi.getParameter("pTime").trim());
			
			//파일이름 가져오기
			Enumeration files = multi.getFileNames();
			String name1 = (String) files.nextElement();
			pTitleimg = multi.getFilesystemName(name1);
			String name2 = (String) files.nextElement(); // 파일 한개더 있을때
			pContentimg1 = multi.getFilesystemName(name2);
			String name3 = (String) files.nextElement(); // 파일 한개더 있을때
			pContentimg2 = multi.getFilesystemName(name3);
			
			//b_orifile = multi.getOriginalFileName(name1); // 원본 이름을 가져올때(파일경로)
			
			check = dao.pwrite(pCategory, pName, pPrice, pDelivery, pTitleimg, pContentimg1, pContentimg2, pAmount, pTime, pContent); //상품입력 메소드 호출
			
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("check", check);
		
	}

}
