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
   // 저장경로 지정
   String path = request.getRealPath("upload");
   // 파일 사이즈 - 업로드 파일 용량 제한
   int size = 1024 * 1024 * 10;  //1024byte=1kb*1024kbyte=1mb*10 10m 용량 제한
   // 파일 이름 최종 설정
   String file="";
   // 파일 예전 이름 
   String orifile="";
   String file2="";
   String orifile2="";
   
   String b_num2 = request.getParameter("b_num");
   String b_title2 = request.getParameter("b_title2");
   
   out.println("paramemter1 : "+b_num2+"<br>");
   out.println("paramemter2 : "+b_title2+"<br>");
   
   try{
	   // request,파일저장경로,용량,인코딩타입,중복파일명에 대한 정책
	   MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
	   
	   b_num = multi.getParameter("b_num"); 
	   b_title = multi.getParameter("b_title");
	   b_content = multi.getParameter("b_content");
	   b_user = multi.getParameter("b_user");
	   // 파일 이름 가져오기
	   Enumeration files = multi.getFileNames();
	   String name1 = (String) files.nextElement();
	   file = multi.getFilesystemName(name1);
	   orifile = multi.getOriginalFileName(name1);
	   
	   String name2 = (String) files.nextElement();
	   file2 = multi.getFilesystemName(name2);
	   orifile2 = multi.getOriginalFileName(name2);
	   
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
    <th>예전이름</th>
    <th>다운로드</th>
    <th>파일이름2</th>
    <th>예전이름2</th>
    <th>다운로드2</th>
  </tr>
  <tr>
    <td><%= b_num %></td>
    <td><%= b_title%></td>
    <td><%= b_content%></td>
    <td><%= b_user%></td>
    <td><%= file %></td>
    <td><%= orifile %></td>
    <td><a href="upload/<%= file%>">다운로드</a></td>
    <td><%= file2 %></td>
    <td><%= orifile2 %></td>
    <td><a href="upload/<%= file2%>">다운로드2</a></td>
  </tr>


</table>





</body>
</html>