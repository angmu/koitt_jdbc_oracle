package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.DTO.Dto;

public class Dao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Context context = null;
	DataSource ds = null;
	ArrayList<Dto> dtos = new ArrayList<Dto>();
	Dto dto = new Dto();
	
	int bid,bhit,bgroup,bstep,bindent;
	String bname,btitle,bcontent;
	Timestamp bdate;
	String sql = null;
	
	//생성자 connection
	public Dao() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			con = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//전체 select
	public ArrayList<Dto> list(int page,int limit, String opt, String search){
		int startrow= (page-1)*10+1;
		int endrow=startrow+limit-1;
		
		switch(opt) {
		case "":
			sql = "select*from"+"(select rownum rnum, bid, bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from "
					+"(select * from beta order by bgroup desc,bstep asc))"+
					"where rnum>=? and rnum <=?"; 
			break;
		case "all":
			sql = "select*from"+
					"(select rownum rnum, bid, bname, btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from"+
						"(seledt*from beta where btitle like ? or bcontent like ? order by bgroup desc, bstep asc))"+
					"where rnum>=? and rnum <=?";
			break;
		case "tit":
			sql = "select*from"+
					"(select rownum rnum, bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from"+
					"(select*from beta where btitle like ? order by bgroup desc, bstep asc))"+
					"where rnum>=? and rnum<=?";
			break;
		case "con":
			sql = "select*from"+
					"(select rownum rnum, bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent from"+
					"(select *from beta where bcontent like ? order by bgroup desc, bstep asc))"+
					"where rnum>=? and rnum<=?";
			break;
		}
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			if(opt.equals("all")) {
				pstmt.setString(1, "%"+search+"%");
				pstmt.setString(2, "%"+search+"%");
				pstmt.setInt(3, startrow);
				pstmt.setInt(4, endrow);
			}else if(opt.equals("tit")||opt.equals("con")) {
				pstmt.setString(1, "%"+search+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
			}
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				dtos.add(new Dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	//////////content-view//////////
	public Dto content_View(int bid) {
		upHit(bid);
		sql = "select*from beta where bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				dto = new Dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
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
	//조회수 1증가//
	public int upHit(int bid) {
		int check = 0 ; 
			sql = "update beta set bhit = bhit+1 where bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	////////////////////전체 게시글 카운트///////////////////////////////
	public int getlistCount(String opt,String search) {
		int count = 0 ; 
		
		switch(opt) {
		case "" :
			sql = "select count(*) as count from beta";
			break;
		case "all":
			sql = "select count(*) as count from beta where bcontent like ? or btitle like ?";
			break;
		case "tit":
			sql = "select count(*) as count from beta where btitle like ?";
			break;
		case "con":
			sql = "select count(*) as count from beta where bcontent like ?";
			break;
		}
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			if(opt.equals("all")) {
				pstmt.setString(1, "%"+search+"%");
				pstmt.setString(2, "%"+search+"%");
			}else if(opt.equals("tit") || opt.equals("con")) {
				pstmt.setString(1, "%"+search+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	//////////////insert/////////////////
	public int insert(String bname,String btitle,String bcontent) {
		int check = 0 ;
		
		sql = "insert into beta values(alpha.nextval,?,?,?,sysdate,0,alpha.currval,0,0)";
		
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	////////////delete//////////////////
	public int delete(int bid) {
		int check = 0 ; 
		sql = "delete beta where bid=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			check = pstmt.executeUpdate();
		}catch (Exception e) {
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
	/////////modify -update///////
	public int modify(int bid,String btitle, String bcontent) {
		int check = 0 ;
		sql = "update beta set btitle=?,bcontent=? where bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,btitle);
			pstmt.setString(2, bcontent);
			pstmt.setInt(3, bid);
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
	public Dto modify_view(int bid) {
		sql = "select*from beta where bid=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				dto = new Dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
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
	//////reply////////
	public int reply(int bid, String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent) {
		int check = 0 ; 
		replyshape(bgroup,bstep);
		sql = "insert into beta values(alpha.nextval,?,?,?,sysdate,0,?,?,?)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con != null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	public Dto reply_view(int bid) {
		sql = "select*from beta where bid=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				dto = new Dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
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
	public void replyshape(int bgroup,int bstep) {
		sql = "update beta set bstep=bstep+1 where bgroup=? and bstep>?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
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
	}

}//클라쓰
