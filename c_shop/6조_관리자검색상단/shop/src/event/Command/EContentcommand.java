package event.Command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import event.DAO.EDao;
import event.DTO.EDto;

public class EContentcommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		
		EDao dao = new EDao();
		
		EDto dto = dao.econtent(fnum);
		
		request.setAttribute("econtent", dto);
		
		System.out.println("fnum 이벤트 보기: "+ fnum);
	}

}
