package event.EFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.Command.ECommand;
import event.Command.EContentcommand;
import event.Command.EDeletecommand;
import event.Command.EListcommand;
import event.Command.EModifycommand;
import event.Command.EModifyViewcommand;
import event.Command.EWritecommand;
import shop.Command.BModifyViewcommand;

@WebServlet("*.event")
public class EFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EFront() {
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
		String pageView = null;
		ECommand ecom = null;
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		String com = uri.substring(conpath.length());
		
		if(com.equals("/event.event")) {
			ecom = new EListcommand();
			ecom.execute(request, response);
			pageView = "event.jsp";
			
		}else if(com.equals("/eventwrite.event")) {
			ecom = new EWritecommand();
			ecom.execute(request, response);
			pageView="event.event";
			
		}else if(com.equals("/ewrite_view.event")) {
			pageView="ewrite_view.jsp";
		
		
		}else if(com.equals("/econtent.event")) {
			ecom = new EContentcommand();
			ecom.execute(request, response);
			pageView="econtent.jsp";
		
		}else if(com.equals("/emodify_view.event")) {
			ecom = new EModifyViewcommand();
			ecom.execute(request, response);
			pageView="emodify_view.jsp";
		}else if(com.equals("/emodify.event")) {
			ecom = new EModifycommand();
			ecom.execute(request, response);
			pageView="event.event";
		}else if(com.equals("/edelete.event")) {
			ecom = new EDeletecommand();
			ecom.execute(request, response);
			pageView="event.event";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
	}
}
