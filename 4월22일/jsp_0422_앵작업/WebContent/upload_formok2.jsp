<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String b_title="";
	String b_content="";
	String b_user="";
 	//파일 저장경로 지정 (폴더명/ㅍ폴더명) "upload/board_file" 이런식으루
	String path=request.getRealPath("upload");
	//파일 사이즈 -업로드 파일 용량제한
	int size=1024*1024*10;//10mb 용량제한.
	//파일 이름 최종설정 (기존파일과 같은이름일 경우 바꿔야해서..)
	String b_file="";
	MemberDao mdao=MemberDao.getInstance();
	
	try{
		//request ,파일저장경로,용량,인코딩타입,중복파일명에 대한 정책
		MultipartRequest multi=new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		//아래처럼 받아도된다
		//String b_num=request.getParameter("b_num");
		b_title=multi.getParameter("b_title");
		b_content=multi.getParameter("b_content");
		b_user=multi.getParameter("b_user");
		Enumeration files=multi.getFileNames();
		String name=(String)files.nextElement();
		b_file=multi.getFilesystemName(name);
		int check=mdao.insertBoard(b_title, b_content, b_user, b_file);
		switch(check){
		case 1:
			response.sendRedirect("main.jsp");
			break;
		default:
%>
			<script>
				alert('파일업로드 실패. 다시 시도해주세요');
				history.back();
			</script>	
<%			
			break;
		}
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>