package shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DAO.Dao;
import shop.DTO.Dto;

public class BWritecommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		Dao dao = new Dao();
		int check = dao.insert(bname, btitle, bcontent);

	}

}
