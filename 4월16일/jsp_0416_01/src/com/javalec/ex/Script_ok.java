package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Script_ok
 */
@WebServlet("/S_ok")
public class Script_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Script_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet들어옴");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost들어옴");
		actionDo(request,response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=response.getWriter();
		String str;
		   str="<script type=\"text/javascript\">\r\n" + 
		     "      alert(\"아이디,패스워드가 잘못되었습니다. 다시 입력해주세요.\");\r\n" + 
		     "      location.href='script_link.html';\r\n" + 
		     "   </script>";
		
		writer.println("<html><head><meta charset='utf-8'></head><body>");
//		writer.println("<script>");
//		writer.println("alert(\'데이터가 잘못입력되었습니다. 다시 입력해주세요.\');");
//		writer.println("history.back(-1);");
//		writer.println("location.href='script_link.html';\r\n");
//		writer.println("</script>");
		writer.println(str);
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
	}
}
