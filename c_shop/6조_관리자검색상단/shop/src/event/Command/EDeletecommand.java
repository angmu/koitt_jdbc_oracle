package event.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.DAO.EDao;

public class EDeletecommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int fnum = Integer.parseInt(request.getParameter("fnum"));
		EDao dao = new EDao();
		int check = dao.delete(fnum);
	}

}
