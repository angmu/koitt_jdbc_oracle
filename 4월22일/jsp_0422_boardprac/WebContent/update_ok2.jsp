<%@page import="com.javalec.ex.BoardDto"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getRealPath("upload");
	BoardDao bdao=BoardDao.getInstance();
	BoardDto bdto=null;
	int size=1024*1024*10;	
	String old_file,b_title,b_user,b_content,b_file,name="";
	int b_num,check=0;
	
	try{
		MultipartRequest multi=new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		b_num=Integer.parseInt(multi.getParameter("b_num"));
		old_file=multi.getParameter("old_file");
		b_title=multi.getParameter("b_title");
		b_user=multi.getParameter("b_user");
		b_content=multi.getParameter("b_content");
		Enumeration files=multi.getFileNames();
		name=(String)files.nextElement();
		b_file=multi.getFilesystemName(name);
		if(b_file==null){
			//이미파일이름이므로 old파일로 넣어야함.
			b_file=old_file;
// 			b_file=multi.getFilesystemName(old_file);
		}else{
			b_file=multi.getFilesystemName(name);
		}
		
		bdto=new BoardDto(b_num,b_title,b_content,b_user,b_file);
		
		//db넣기
		check=bdao.modifyBoard(bdto);
		
		if(check==1){
			%>
			<script>
				alert('데이터수정성공');
				window.location.href='list.jsp';
			</script>
			<%
		}else{
			 %>			
			<script>
				alert('데이터수정실패');
				history.back();
			</script>
			<%
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