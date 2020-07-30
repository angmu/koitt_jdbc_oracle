package shop.Command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;
import shop.DTO.Dto;

public class BContentcommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int bid = Integer.parseInt(request.getParameter("bid"));
		Dao dao = new Dao();
		Dto dto = dao.content_View(bid);
		request.setAttribute("content_view", dto);
		
	}

}
