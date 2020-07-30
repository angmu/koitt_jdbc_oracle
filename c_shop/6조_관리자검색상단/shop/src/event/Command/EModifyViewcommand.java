package event.Command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import event.DAO.EDao;
import event.DTO.EDto;

public class EModifyViewcommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			
				
				EDao dao = new EDao();
				EDto dto = dao.emodify_view(fnum);
				request.setAttribute("emodify_view", dto);
				
				System.out.println("fnum모디파이뷰 :"+fnum);

	}

}
