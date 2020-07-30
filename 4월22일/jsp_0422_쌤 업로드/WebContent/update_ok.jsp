<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="com.javalec.ex.BoardDto"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_num=0;
    String b_title="";
	String b_content="";
	String b_user="";
	String old_file="";
	String path=request.getRealPath("upload");
	int size=1024*1024*10;
	String b_file="";
	
	try{
		 // file 
		 MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		 Enumeration files = multi.getFileNames();
		 String name1 = (String) files.nextElement();
		 b_file = multi.getFilesystemName(name1);
		 
		 if(b_file==null){
			 b_file = old_file;
		 }
		 
		 b_num = Integer.parseInt(multi.getParameter("b_num"));
		 b_title = multi.getParameter("b_title");
		 b_content = multi.getParameter("b_content");
		 b_user = multi.getParameter("b_user");
		 
		 // db
		 BoardDto bdto= new BoardDto(b_num,b_title,b_content,b_user,b_file);
		 BoardDao bdao = BoardDao.getInstance();
		 // bdto데이터 추가메소드 호출
		 int check = bdao.updateBoard(bdto);
		 
		 if(check==1){//성공 %>
			<script>
			  alert("데이터가 성공적으로 수정 되었습니다.");
			  window.location.href='list.jsp';
			</script>
		<% }else{//실패%>
			<script>
			  alert("데이터 수정이 되지 않았습니다. 다시 수정해주세요.");
			  history.back();
			</script>
		 <%}
		  
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