package event.Command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import event.DAO.EDao;

public class EModifycommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum;
		String ftitle,fcontent,fuser,ffile1,ffile2;
		
		String path = request.getRealPath("upload");
		int size = 1024*1024*10;
		
		try {
			MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
			fnum = Integer.parseInt(multi.getParameter("fnum"));
			fuser = multi.getParameter("fuser");
			ftitle = multi.getParameter("ftitle");
			fcontent = multi.getParameter("fcontent");
			
			Enumeration files = multi.getFileNames();
			String name1 = (String)files.nextElement();
			String name2 = (String)files.nextElement();
			ffile2 = multi.getFilesystemName(name1);
			ffile1 = multi.getFilesystemName(name2);
			
			EDao dao = new EDao();
			int check = dao.emodify(fnum, ftitle, fcontent, ffile1, ffile2);
		System.out.println("fnum 그냥모디파이"+fnum);
		System.out.println("ffile1 :"+ ffile1);
		System.out.println("ffile2 :"+ffile2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
