package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login_Ok")
public class Login_Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con=null;
	Statement stmt = null;
	ResultSet rs=null;
	
	String id,pw;
	String sql;
	
    
    public Login_Ok() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet ����");
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost ����");
        actionDo(request, response);
	
	}
	
	protected void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		sql = "select id,pw from lms_member where id='"+id+"' and pw='"+pw+"'";
		
		try {
			
			//db���� �κ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			System.out.println("������ rs :"+rs.toString());
			// �����Ͱ� �����ϴ��� ���� Ȯ��
			if(rs.next()) {
			 //id,pw �����Ͱ� �ִ� ���
			 while(rs.next()) {
				id = rs.getString("id");
				System.out.println("������ : "+id);
				pw = rs.getString("pw");
			 }	
			 
			 //���� �߰�
			 HttpSession session = request.getSession();
			 session.setAttribute("user_id", id);
			 session.setAttribute("user_pw", pw);
			 session.setAttribute("authUser", id);
			 
			 response.sendRedirect("main.jsp");
				
			}else {
			  //id,pw������ ���� ���
			   String str;
			   str="<script type=\"text/javascript\">\r\n" + 
				 		"      alert(\"���̵�,�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.\");\r\n" + 
				 		"      location.href='login.jsp';\r\n" + 
				 		"   </script>";
				 response.setCharacterEncoding("utf-8");
				 response.setContentType("text/html; charset=utf-8");
			     PrintWriter writer = response.getWriter();
		         writer.println("<html><head></head><body>");
		         writer.println(str);
		         writer.println("</html>");
		         writer.close();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			String str;
			 str="<script type=\"text/javascript\">\r\n" + 
			 		"      alert(\"���̵�,�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.\");\r\n" + 
			 		"      location.href='login.jsp';\r\n" + 
			 		"   </script>";
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html; charset=utf-8");
			 PrintWriter writer = response.getWriter();
	         writer.println("<html><head></head><body>");
	         writer.println(str);
	         writer.println("</html>");
	         writer.close();
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
				String str;
				 str="<script type=\"text/javascript\">\r\n" + 
				 		"      alert(\"���̵�,�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.\");\r\n" + 
				 		"      location.href='login.jsp';\r\n" + 
				 		"   </script>";
				 response.setCharacterEncoding("utf-8");
				 response.setContentType("text/html; charset=utf-8");
				 PrintWriter writer = response.getWriter();
		         writer.println("<html><head></head><body>");
		         writer.println(str);
		         writer.println("</html>");
		         writer.close();
				
			}
		}
	}
}
