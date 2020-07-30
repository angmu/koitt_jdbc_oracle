package com.javalec.ex;

import java.io.IOException;
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

@WebServlet("/Login_ok")
public class Login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet으로 들어옴");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 들어옴");
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String id,pw,name,phone1,phone2,phone3,gender;
		
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		
		String sql="select * from member2 where id='"+id+"' and pw='"+pw+"'";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null) {
				//id와 pw가 있을때
				while(rs.next()) {
					id=rs.getString("id");
					pw=rs.getString("pw");
					name=rs.getString("name");
					phone1=rs.getString("phone1");
					phone2=rs.getString("phone2");
					phone3=rs.getString("phone3");
					gender=rs.getString("gender");
					
					//세션을 바로 가져올수 없음.
					HttpSession session=request.getSession();
					session.setAttribute("user_id", id);
					session.setAttribute("user_pw", pw);
					session.setAttribute("user_name", name);
					session.setAttribute("authUser", id);
					
					response.sendRedirect("index.jsp");
				}
			}else {
				//id와 pw가 없을때
				response.sendRedirect("index.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			}
		
		
		
//		response.setContentType("text/html;charset=UTF-8");
	}
}
