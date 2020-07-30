package com.javalec.ex.BCommand.ProductCommand;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.EDao;
import com.javalec.ex.EDto.EDto;
import com.javalec.ex.PDao.PDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PModifycommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int pId=0;
		int pPrice=0;
		int pDelivery=0;
		int pAmount=0;
		int pTime=0;
		String pContent="";
		String pName="";
		String pCategory="";

		PDao dao=new PDao();
		
		String oldname1="";
		String oldname2="";
		String oldname3="";
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
			pContent = multi.getParameter("pContent");
			pName = multi.getParameter("pName");
			pCategory = multi.getParameter("pCategory");
			pId = Integer.parseInt(multi.getParameter("pId"));
			pPrice = Integer.parseInt(multi.getParameter("pPrice"));
			pDelivery = Integer.parseInt(multi.getParameter("pDelivery"));
			pAmount = Integer.parseInt(multi.getParameter("pAmount"));
			pTime = Integer.parseInt(multi.getParameter("pTime"));
			oldname1 = multi.getParameter("newfile1");
			oldname2 = multi.getParameter("newfile2");
			oldname3 = multi.getParameter("newfile3");
			System.out.println(oldname1);
			System.out.println(oldname2);
			System.out.println(oldname3);
			Enumeration files = multi.getFileNames();
			//파일이름 가져오기
			String name1 = (String) files.nextElement(); // 파일 한개더 있을때
			pContentimg1 = multi.getFilesystemName(name1);
			if(pContentimg1==null) {
				pContentimg1=oldname2;
			}
			String name2 = (String) files.nextElement();
			pTitleimg = multi.getFilesystemName(name2);
			if(pTitleimg==null) {
				pTitleimg=oldname1;
			}
			String name3 = (String) files.nextElement(); // 파일 한개더 있을때
			pContentimg2 = multi.getFilesystemName(name3);
			if(pContentimg2==null) {
				pContentimg2=oldname3;
			}
			System.out.println("----------");
			System.out.println(pTitleimg);
			System.out.println(pContentimg1);
			System.out.println(pContentimg2);
			check = dao.pmodify(pContent,pName,pCategory,pId,pPrice,pDelivery,pAmount,pTime,pTitleimg,pContentimg1,pContentimg2); //게시글수정 메소드 호출
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("check", check);
		
	}

}
