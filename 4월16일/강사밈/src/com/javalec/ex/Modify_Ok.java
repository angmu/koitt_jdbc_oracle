package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Modify_Ok")
public class Modify_Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	
	String id,pw,name,email,address,phone,birth,gender,news,sms;
	String sql;
	
    int check;  
    
    public Modify_Ok() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Modify_ok doGet 들어옴");
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Modify_ok doPost 들어옴");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			//request 한글처리
			request.setCharacterEncoding("utf-8");
			
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			email = request.getParameter("email");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			birth = request.getParameter("birth");
			gender = request.getParameter("gender");
			news = request.getParameter("news");
			sms = request.getParameter("sms");
			
			sql="update lms_member set pw=?, name=?,email=?,address=?,phone=?,birth=?,gender=?,news=?,sms=? where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			pstmt.setString(6, birth);
			pstmt.setString(7, gender);
			pstmt.setString(8, news);
			pstmt.setString(9, sms);
			pstmt.setString(10, id);
			check = pstmt.executeUpdate();
			
			if(check==1) {
				response.sendRedirect("main.jsp");
			}else {
				// 데이터가 저장이 안되었을때
				String str;
				str="<script type=\"text/javascript\">\r\n" + 
					 		"      alert(\"저장되지 않았습니다. 다시 시도해주세요.\");\r\n" + 
					 		"      history.back(-1);\r\n" + 
					 		"   </script>";
					 response.setCharacterEncoding("utf-8");
					 response.setContentType("text/html; charset=utf-8");
				     PrintWriter writer = response.getWriter();
			         writer.println("<html><head></head><body>");
			         writer.println(str);
			         writer.println("</html>");
			         writer.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
