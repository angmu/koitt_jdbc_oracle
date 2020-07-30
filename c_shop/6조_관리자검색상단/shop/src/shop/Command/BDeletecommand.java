package shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;

public class BDeletecommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		Dao dao = new Dao();
		int check = dao.delete(bid);
	}

}
