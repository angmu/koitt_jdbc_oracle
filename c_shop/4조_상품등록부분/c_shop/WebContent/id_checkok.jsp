<%@page import="com.javalec.ex.MDao.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id_ch");
MDao dao = new MDao();
int check=dao.idcheck(id);
response.sendRedirect("join_idcheck.jsp?id="+id+"&check="+check);
%>
	
