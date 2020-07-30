package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.javalec.ex.BCommand.BoardCommand.*;
import com.javalec.ex.BCommand.EventCommand.*;
import com.javalec.ex.BCommand.MainCommand.*;
import com.javalec.ex.BCommand.MemberCommand.*;
import com.javalec.ex.BCommand.ProductCommand.*;


@WebServlet("*.do")
public class BFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFront() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		String pageView=null;
		MainCommand mcom=null;
		BoardCommand bcom=null;
		EventCommand ecom=null;
		MemberCommand memcom=null;
		ProductCommand pcom=null;
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		

		
		//메인페이지 로딩
		if(com.equals("/gomain.do")) {
			mcom=new MainViewcommand();
			mcom.execute(request, response);
			pageView = "index.jsp";
		}
		
		
		
		//공지사항 관련(회원)
		
		
		else if(com.equals("/list.do")) {
			bcom=new BListcommand();
			bcom.execute(request, response);
			pageView = "blist.jsp";
		}
		else if(com.equals("/content_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="bcontent_view.jsp";
		}
		
		else if(com.equals("/search.do")) {
			bcom=new BSearchcommand();
			bcom.execute(request, response);
			pageView="blist.jsp";
		}
		
		
		//이벤트 페이지 관련(회원)
		
		
		else if(com.equals("/elist.do")) {
			ecom=new EListcommand();
			ecom.execute(request, response);
			pageView="event_list.jsp";
		}
		else if(com.equals("/econtent_view.do")) {
			ecom=new EContentViewcommand();
			ecom.execute(request, response);
			pageView="econtent_view.jsp";
		}
		
		//리뷰관련(회원)
		
		else if(com.equals("/rlist.do")) {
			mcom=new RListcommand();
			mcom.execute(request, response);
			pageView="rlist.jsp";
		}
		
		//상품관련(회원)
		
		else if(com.equals("/plist.do")) {
			pcom=new PListcommand();
			pcom.execute(request, response);
			pageView="plist.jsp";
		}
		else if(com.equals("/pcontent_view.do")) {
			pcom=new PContentViewcommand();
			pcom.execute(request, response);
			pageView="pcontent_view.jsp";
		}
		
		
		//회원관련(로그인,회원가입)
		
		
		else if(com.equals("/login.do")) {
			mcom=new Logincommand();
			mcom.execute(request, response);
			pageView="gomain.do";
		}
		else if(com.equals("/idcheck.do")) {
			memcom=new MIdcheckcommand();
			memcom.execute(request, response);
			pageView="join_idcheck.jsp";
		}
		else if(com.equals("/join.do")) {
			memcom=new MJoincommand();
			memcom.execute(request, response);
			pageView="login.jsp";
		}
		else if(com.equals("/mmodify_view.do")) {
			memcom=new MModifyViewcommand();
			memcom.execute(request, response);
			pageView="mmodify_view.jsp";
		}
		else if(com.equals("/mmodify.do")) {
			memcom=new MModifycommand();
			memcom.execute(request, response);
			pageView="gomain.do";
		}
		
		//admin로그인
		
		
		else if(com.equals("/admin_login.do")) {
			mcom=new ALogincommand();
			mcom.execute(request, response);
			pageView="admin_main.jsp";
		}
		
		//admin이벤트관리
		
		
		else if(com.equals("/admin_elist.do")) {
			ecom=new EListcommand();
			ecom.execute(request, response);
			pageView="admin_event_list.jsp";
		}
		else if(com.equals("/admin_econtent_view.do")) {
			ecom=new EContentViewcommand();
			ecom.execute(request, response);
			pageView="admin_econtent_view.jsp";
		}
		else if(com.equals("/ewrite.do")) {
			ecom=new EWritecommand();
			ecom.execute(request, response);
			pageView="admin_elist.do";
		}
		else if(com.equals("/edelete.do")) {
			ecom=new EDeletecommand();
			ecom.execute(request, response);
			pageView="admin_elist.do";
		}
		else if(com.equals("/emodify_view.do")) {
			ecom=new EContentViewcommand2();
			ecom.execute(request, response);
			pageView="admin_emodify_view.jsp";
		}
		else if(com.equals("/emodify.do")) {
			ecom=new EModifycommand();
			ecom.execute(request, response);
			pageView="admin_econtent_view.jsp";
		}
		
		//admin 배너관리
		else if(com.equals("/banner_write.do")) {
			mcom=new BAnnerwritecommand();
			mcom.execute(request, response);
			pageView="admin_main.jsp";
		}
		
		
		//admin 공지사항 관리
		
		
		else if(com.equals("/admin_list.do")) {
			bcom=new BListcommand();
			bcom.execute(request, response);
			pageView = "admin_blist.jsp";
		}
		else if(com.equals("/admin_content_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="admin_bcontent_view.jsp";

		}
		else if(com.equals("/admin_search.do")) {
			bcom=new BSearchcommand();
			bcom.execute(request, response);
			pageView="admin_blist.jsp";
		}
		else if(com.equals("/write.do")) {
			bcom=new BWritecommand();
			bcom.execute(request, response);
			pageView="admin_list.do";
		}
		else if(com.equals("/delete.do")) {
			bcom=new BDeletecommand();
			bcom.execute(request, response);
			pageView="admin_list.do";
		}
		else if(com.equals("/modify_view.do")) {
			bcom=new BContentViewcommand2();
			bcom.execute(request, response);
			pageView="admin_bmodify_view.jsp";
		}
		else if(com.equals("/modify.do")) {
			bcom=new BModifycommand();
			bcom.execute(request, response);
			pageView="admin_bcontent_view.jsp";
		}
		else if(com.equals("/reply_view.do")) {
			bcom=new BContentViewcommand2();
			bcom.execute(request, response);
			pageView="admin_breply_view.jsp";
		}
		else if(com.equals("/reply.do")) {
			bcom=new BReplycommand();
			bcom.execute(request, response);
			pageView="admin_list.do";
		}
		
		//admin 상품관리
		
		else if(com.equals("/admin_plist.do")) {
			pcom=new PListcommand();
			pcom.execute(request, response);
			pageView="admin_plist.jsp";
		}
		
		else if(com.equals("/pwrite.do")) {
			pcom=new PWritecommand();
			pcom.execute(request, response);
			pageView="admin_plist.do";
		}
		
		else if(com.equals("/pmodify_view.do")) {
			pcom=new PContentViewcommand();
			pcom.execute(request, response);
			pageView="admin_pmodify_view.jsp";
		}
		
		else if(com.equals("/pmodify.do")) {
			pcom=new PModifycommand();
			pcom.execute(request, response);
			pageView="admin_plist.do";
		}
		
		else if(com.equals("/pdelete.do")) {
			pcom=new PDeletecommand();
			pcom.execute(request, response);
			pageView="admin_plist.do";
		}
		
		//admin 회원관리
		
		else if(com.equals("/admin_mlist.do")) {
			memcom=new MListcommand();
			memcom.execute(request, response);
			pageView="admin_mlist.jsp";
		}
		
		
		
		
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
		
	}

}
