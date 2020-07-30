package event.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import event.DTO.EDto;

public class EDao {

	///
	Connection con = null;
	PreparedStatement pstmt = null;
	DataSource ds = null;
	Context context = null;
	ResultSet rs = null;
	EDto dto = new EDto();
	ArrayList<EDto> list = new ArrayList<EDto>();
	int fnum=0;
	String ftitle,fcontent,fuser,ffile1,ffile2;
	Timestamp fdate1,fdate2;
	String sql =null;
	////
	///
	public EDao() {
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getlistcount(String opt,String search) {
		int count = 0 ; 
			sql = "select count(*) as count from ffile";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	///
	public ArrayList<EDto> list(int page,int limit,String opt,String search){
	sql = "select*from ffile";
	int startrow=(page-1)*6+1;
	int endrow = startrow+limit-1;
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			fnum = rs.getInt("fnum");
			ftitle = rs.getString("ftitle");
			fcontent = rs.getString("fcontent");
			fuser = rs.getString("fuser");
			ffile1 = rs.getString("ffile1");
			ffile2 = rs.getString("ffile2");
			fdate1 = rs.getTimestamp("fdate1");
			fdate2 = rs.getTimestamp("fdate2");
			list.add(new EDto(fnum,ftitle,fcontent,fuser,ffile1,ffile2,fdate1,fdate2));
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(con!=null)con.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return list;
	}
	
	public int eventwrite(String fuser,String ftitle,String fcontent,String ffile1,String ffile2) {
		int check = 0;
		sql = "insert into ffile(fnum,ftitle,fcontent,fuser,ffile1,ffile2) values(alpha.nextval,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,ftitle);
			pstmt.setString(2,fcontent);
			pstmt.setString(3,fuser);
			pstmt.setString(4,ffile1);
			pstmt.setString(5,ffile2);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	public int emodify(int fnum,String ftitle,String fcontent,String ffile1,String ffile2) {
		int check = 0 ; 
		sql = "update ffile set ftitle=?,fcontent=?,ffile1=?,ffile2=? where fnum=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffile1);
			pstmt.setString(4, ffile2);
			pstmt.setInt(5, fnum);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	public EDto emodify_view(int fnum) {
		sql = "select*from ffile where fnum=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fnum = rs.getInt("fnum");
				ftitle = rs.getString("ftitle");
				fcontent = rs.getString("fcontent");
				fuser = rs.getString("fuser");
				ffile1 = rs.getString("ffile1");
				ffile2 = rs.getString("ffile2");
				fdate1 = rs.getTimestamp("fdate1");
				fdate2 = rs.getTimestamp("fdate2");
				dto = new EDto(fnum,ftitle,fcontent,fuser,ffile1,ffile2,fdate1,fdate2);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		
		return dto;
	}
	public EDto econtent(int fnum) {
		sql = "select*from ffile where fnum=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				fnum = rs.getInt("fnum");
				ftitle = rs.getString("ftitle");
				fcontent = rs.getString("fcontent");
				fuser = rs.getString("fuser");
				ffile1 = rs.getString("ffile1");
				ffile2 = rs.getString("ffile2");
				fdate1 = rs.getTimestamp("fdate1");
				fdate2 = rs.getTimestamp("fdate2");
				dto = new EDto(fnum, ftitle, fcontent, fuser, ffile1, ffile2, fdate1, fdate2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	public int delete(int fnum) {
		int check = 0 ;
		sql = "delete ffile where fnum=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			check = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
				
			}
		}
		return check;
		
	}
}
