package shop.Front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Command.BContentcommand;
import shop.Command.BDeletecommand;
import shop.Command.BListCommand;
import shop.Command.BModifyViewcommand;
import shop.Command.BModifycommand;
import shop.Command.BReplyViewcommand;
import shop.Command.BReplycommand;
import shop.Command.BWritecommand;
import shop.Command.Command;

@WebServlet("*.do")
public class Front extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Front() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String pageView=null;
		Command comm = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/list.do")) {
			comm = new BListCommand();
			comm.execute(request, response);
			pageView="list.jsp";
		}
		
		else if(com.equals("/search.do")) {
			comm = new BListCommand();
			comm.execute(request, response);
			pageView="list.jsp";
		}
		
		else if(com.equals("/index.do")) {
			pageView="index.jsp";
		}
		
		else if(com.equals("/content_view.do")) {
			comm = new BContentcommand();
			comm.execute(request, response);
			pageView="content_view.jsp";
		}
		
		else if(com.equals("/write.do")) {
			comm = new BWritecommand();
			comm.execute(request, response);
			pageView="list.do";
		}
		
		else if(com.equals("/write_view.do")) {
			pageView="write_view.jsp";
		}
		
		else if(com.equals("/delete.do")) {
			comm = new BDeletecommand();
			comm.execute(request, response);
			pageView="list.do";
		}
		
		else if(com.equals("/reply_view.do")) {
			comm = new BReplyViewcommand();
			comm.execute(request, response);
			pageView="reply_view.jsp";
		}
		
		else if(com.equals("/reply.do")) {
			comm = new BReplycommand();
			comm.execute(request, response);
			pageView="list.do";
		}
		
		else if(com.equals("/modify_view.do")) {
			comm = new BModifyViewcommand();
			comm.execute(request, response);
			pageView="modify_view.jsp";
		}
		
		else if(com.equals("/modify.do")) {
			comm = new BModifycommand();
			comm.execute(request, response);
			pageView="list.do";
		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request,response);
	}
}
