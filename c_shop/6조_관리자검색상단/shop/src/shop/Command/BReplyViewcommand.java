package shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;
import shop.DTO.Dto;

public class BReplyViewcommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bid = Integer.parseInt(request.getParameter("bid"));
		Dao dao = new Dao();
		Dto dto = dao.reply_view(bid);
		request.setAttribute("reply_view", dto);

	}

}
