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
       int check;
       String id,pw,name,email,address,phone,birth,gender,news,sms,sql;
       
    public Modify_Ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			id=request.getParameter("id");
			pw=request.getParameter("pw");
			name=request.getParameter("name");
			email=request.getParameter("email");
			address=request.getParameter("address");
			phone=request.getParameter("phone");
			gender=request.getParameter("gender");
			//우케만드누 
			birth=request.getParameter("birth");
			news=request.getParameter("news");
			sms=request.getParameter("sms");
			
			sql="update lms_member set pw=?,name=?,email=?,address=?,phone=?,birth=?,gender=?,news=?,sms=? where id=?"; 
			System.out.println(sql);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			pstmt=con.prepareStatement(sql);
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
			check=pstmt.executeUpdate();
			System.out.println(check);
			if(check==1) {
				response.sendRedirect("main.jsp");
			}else {
				PrintWriter writer=response.getWriter();
				String str;
				   str="<script type=\"text/javascript\">\r\n" + 
				     "      alert(\"저장이되지 않았습니다. 다시시도해주세요.\");\r\n" + 
				     "      history.back(-1);\r\n" + 
				     "   </script>";
				
				writer.println("<html><head><meta charset='utf-8'></head><body>");
				writer.println(str);
				writer.println("</body>");
				writer.println("</html>");
				writer.close();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			PrintWriter writer=response.getWriter();
			String str;
			   str="<script type=\"text/javascript\">\r\n" + 
			     "      alert(\"저장이되지 않았습니다. 다시시도해주세요.\");\r\n" + 
			     "      history.back(-1);\r\n" + 
			     "   </script>";
			
			writer.println("<html><head><meta charset='utf-8'></head><body>");
			writer.println(str);
			writer.println("</body>");
			writer.println("</html>");
			writer.close();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				PrintWriter writer=response.getWriter();
				String str;
				   str="<script type=\"text/javascript\">\r\n" + 
				     "      alert(\"저장이되지 않았습니다. 다시시도해주세요.\");\r\n" + 
				     "      history.back(-1);\r\n" + 
				     "   </script>";
				
				writer.println("<html><head><meta charset='utf-8'></head><body>");
				writer.println(str);
				writer.println("</body>");
				writer.println("</html>");
				writer.close();
			}
			
		}
	
	}
}
