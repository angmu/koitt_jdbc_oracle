package event.Command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import event.DAO.EDao;
import event.DTO.EDto;

public class EWritecommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fuser,ftitle,fcontent,ffile1,ffile2;
		
		String path = request.getRealPath("upload");
		int size = 1024*1024*10;
		 	
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8",new DefaultFileRenamePolicy());
			fuser = multi.getParameter("fuser");
			ftitle = multi.getParameter("ftitle");
			fcontent = multi.getParameter("fcontent");
			
			Enumeration files = multi.getFileNames();
			
			String name1 = (String)files.nextElement();
			String name2 = (String)files.nextElement();
			ffile1 = multi.getFilesystemName(name2);
			ffile2 = multi.getFilesystemName(name1);
			
			EDao dao = new EDao();
			int check = dao.eventwrite(fuser, ftitle, fcontent, ffile1 ,ffile2);
			
			System.out.println("fuser : "+fuser);
			System.out.println("ftitle : "+ftitle);
			System.out.println("fcontent : "+fcontent);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
