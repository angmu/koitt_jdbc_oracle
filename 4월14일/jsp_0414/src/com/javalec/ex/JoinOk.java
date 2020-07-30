package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinOk() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet로 들어옴");
		actionDo(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 들어옴");
		actionDo(request,response);
	}
	//공통처리
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id,pw,name,phone1,phone2,phone3,gender="";
		Connection conn=null;
		Statement stmt = null;
		//데이터를 넣기만 하고 안꺼내오기때문에 result set
		request.setCharacterEncoding("utf-8");
		
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		name=request.getParameter("name");
		phone1=request.getParameter("phone1");
		phone2=request.getParameter("phone2");
		phone3=request.getParameter("phone3");
		gender=request.getParameter("gender");
		
//		insert into member2 values(
//		'aaa','123','홍길동','010','1111','1111','남자');
		
		String sql="insert into member2 values('"+id+"','"+pw+"','"+name+"','"+phone1+"','"+phone2+"','"+phone3+"','"+gender+"')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=conn.createStatement();
			//저장ok >1리턴, 아니면 0을 리턴
			int result = stmt.executeUpdate(sql); //insert,update,delete >>executeUpdate  ||그외 >>excuteQuary
			if(result!=0) {
				response.sendRedirect("joinResult.jsp");
			}else {
				PrintWriter writer=response.getWriter();
				writer.println("<html><head><meta charset=\"UTF-8\"></head>");
				writer.println("<body>");
				writer.println("<script>");
				writer.println("alert('저장되지않았습니다 다시입력해주세오');");
				writer.println("location.href='join.html';</script>");
				writer.println("</body>");
				writer.println("</html>");
				writer.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter writer=response.getWriter();
			writer.println("<html><head><meta charset=\"UTF-8\"></head>");
			writer.println("<body>");
			writer.println("<script>");
			writer.println("alert('저장되지않았습니다 다시입력해주세오');");
			writer.println("location.href='join.html';</script>");
			writer.println("</body>");
			writer.println("</html>");
			writer.close();
			response.sendRedirect("join.html");
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
