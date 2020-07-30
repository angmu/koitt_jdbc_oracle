package event.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import event.DAO.EDao;
import event.DTO.EDto;

public class EListcommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int page = 1; //최초 1페이지 세팅
		int limit = 6; // 1page = 게시글 10개
		String searchflag = request.getParameter("searchflag"); //검색체크
		String opt = request.getParameter("opt");
		String search = request.getParameter("search");
		System.out.println("opt : "+ opt);
		System.out.println("search : "+search);
		
		if(opt == null || search== null) {
			opt = "";
			search = "";
		}
		//넘어온 page가 있을때 -예 )4페이지
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		EDao dao = new EDao();
		ArrayList<EDto> dto = dao.list(page, limit, opt, search);
		//전체 게시글
		int listcount = dao.getlistcount(opt,search);
		//최대 페이지 수 
		int maxpage = (int)((double)listcount/limit+0.95);
		//처음 페이지
		int startpage = ((int)((double)page/6+0.9)-1)*10+1;
		//마지막 페이지
		int endpage = maxpage;//1~6까지는 maxpage가 endpage 가 됨
		if(endpage>startpage+10-1)endpage = startpage+10-1;
		
		request.setAttribute("list", dto);
		
		request.setAttribute("listcount", listcount);
		
		request.setAttribute("page", page);
		
		request.setAttribute("maxpage", maxpage);
		
		request.setAttribute("startpage", startpage);
		
		request.setAttribute("endpage", endpage);
		
		if(search!="") {
			searchflag = "1";
			request.setAttribute("searchflag", searchflag);
			request.setAttribute("opt", opt);
			request.setAttribute("search", search);
		}
		
		
	}

}
