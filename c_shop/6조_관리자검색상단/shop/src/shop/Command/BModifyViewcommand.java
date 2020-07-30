package shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;
import shop.DTO.Dto;

public class BModifyViewcommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bid = Integer.parseInt(request.getParameter("bid"));
		Dao dao = new Dao();
		Dto dto = dao.modify_view(bid);
		request.setAttribute("modify_view", dto);
		
	}

}
