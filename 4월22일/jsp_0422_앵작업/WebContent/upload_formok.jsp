<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String b_num="";
	String b_title="";
	String b_content="";
	String b_user="";
 	//파일 저장경로 지정 (폴더명/ㅍ폴더명) "upload/board_file" 이런식으루
	String path=request.getRealPath("upload");
	//파일 사이즈 -업로드 파일 용량제한
	int size=1024*1024*10;//10mb 용량제한.
	//파일 이름 최종설정 (기존파일과 같은이름일 경우 바꿔야해서..)
	String file="";
	//파일 예전이름
	String orifile="";
	//2번째 파일용
	String file2="";
	String orifile2="";
	
	try{
		//request ,파일저장경로,용량,인코딩타입,중복파일명에 대한 정책
		MultipartRequest multi=new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		//아래처럼 받아도된다
		//String b_num=request.getParameter("b_num");
		b_num=multi.getParameter("b_num");
		b_title=multi.getParameter("b_title");
		b_content=multi.getParameter("b_content");
		b_user=multi.getParameter("b_user");
		//name >>enumeration타입으루 리턴값을 가진다.
		Enumeration files=multi.getFileNames();
		//session에서 호출하는것과 같은 이치.. session.setAttribute("authUser","admin");일때 admin을 호출할때
		//session.getAttribute("authUser");를 하는것과같다.
		String name1=(String)files.nextElement();
		file=multi.getFilesystemName(name1);
		orifile=multi.getOriginalFileName(name1);
// 		String name2=(String)files.nextElement();
// 		file2=multi.getFilesystemName(name2);
// 		orifile2=multi.getOriginalFileName(name2);
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
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>파일이름</th>
			<th>파일예전이름</th>
			<th>다운로드</th>
<!-- 			<th>파일2 이름</th> -->
<!-- 			<th>파일2 예전이름</th> -->
<!-- 			<th>파일2 다운로드</th> -->
		</tr>
		<tr>
			<td><%=b_num %></td>
			<td><%=b_title %></td>
			<td><%=b_content %></td>
			<td><%=b_user %></td>
			<td><%=file %></td>
			<td><%=orifile %></td>
			<!-- 실제 파일위치는 C:\Program Files\Apache Software Foundation\Tomcat 9.0\wtpwebapps\jsp_0422\upload 여기에 있다. -->
			<td><a href="upload/<%=file%>">파일보기</a></td>
<%-- 			<td><%=file2 %></td> --%>
<%-- 			<td><%=orifile2 %></td> --%>
			<!-- 실제 파일위치는 C:\Program Files\Apache Software Foundation\Tomcat 9.0\wtpwebapps\jsp_0422\upload 여기에 있다. -->
<%-- 			<td><a href="upload/<%=file2%>">파일보기</a></td> --%>
		</tr>
	</table>
</body>
</html>