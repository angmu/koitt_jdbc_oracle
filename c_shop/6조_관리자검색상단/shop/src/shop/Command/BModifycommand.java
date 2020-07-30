package shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;

public class BModifycommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

			int bid = Integer.parseInt(request.getParameter("bid"));
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			
			Dao dao = new Dao();
			int check = dao.modify(bid, btitle, bcontent);
	}

}
