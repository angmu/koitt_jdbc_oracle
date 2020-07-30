package com.javalec.ex.BDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BDto;

public class BDao {
	
	Context context=null;
	DataSource ds=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<BDto> list=null;
	BDto dto=null;
	String bName,bTitle,bContent,sql;
	int bId,bHit,bGroup,bStep,bIndent,check;
	Timestamp bDate;
	
	//생성자, 커넥션 풀
	public BDao() {
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//select전체 번호에 맞는 글이 조회되도록 조작.
	public ArrayList<BDto> list(int page,int limit,String opt,String search) {
		list=new ArrayList<BDto>();
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;

		//오류 해결 1
		//select * from mvc_board where btitle like ?
		//pstmt.setString(1,"%"+search+"%");
		//오류 해결2
		//select * from mvc_board where btitle like '%' || ? || '%';
		
		switch(opt) {
		case "":
			sql="select *from " + 
				"(select rownum rnum,bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from "+ 
				"(select *from mvc_board order by bgroup desc, bid asc)) " + 
				"where rnum>=? and rnum<=?";
				break;
		case "all":
			sql="select *from (select rownum rnum,bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from \r\n" + 
					"(select *from mvc_board where btitle like '%' || ? || '%' or bcontent like '%' || ? || '%' order by bgroup desc, bid asc)) where rnum>=? and rnum<=?";
			break;
		case "tit":
			sql="select *from (select rownum rnum,bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from \r\n" + 
					"(select *from mvc_board where btitle like '%' || ? || '%' order by bgroup desc, bid asc)) where rnum>=? and rnum<=?";
			break;
		case "con":
			sql="select *from (select rownum rnum,bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from \r\n" + 
					"(select *from mvc_board where bcontent like '%' || ? || '%' order by bgroup desc, bid asc)) where rnum>=? and rnum<=?";
			break;
		}			
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			switch(opt) {
			case "":
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				break;
			case "all":
				pstmt.setString(1,search);
				pstmt.setString(2,search);
				pstmt.setInt(3, startrow);
				pstmt.setInt(4, endrow);
				break;
			case "tit":
				pstmt.setString(1,search);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				break;
			case "con":
				pstmt.setString(1,search);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				break;
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bDate=rs.getTimestamp("bDate");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}//select전체
	
	//count(*)
	public int getlistCount(String opt,String search) {
		int count=0;
		//검색해서 들어온건지 아니면 그냥 바로 들어왓는지 확인해서 쿼리문이 바뀌어야함.
		switch(opt) {
		//별칭 주의!!
		case "":
			sql="select count(*) as cnt from mvc_board";
			break;
		case "all":
			sql="select count(*) as cnt from mvc_board where btitle like '%' || ? || '%' or bcontent like '%' || ? || '%' ";
			break;
		case "tit":
			sql="select count(*) as cnt from mvc_board where btitle like '%' || ? || '%' ";
			break;
		case "con":
			sql="select count(*) as cnt from mvc_board where bcontent like '%' || ? || '%' ";
			break;
		}
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			//pstmt.setString(1,opt);
			switch(opt) {
			case "":
				break;
			case "all":
				pstmt.setString(1,search);
				pstmt.setString(2,search);
				break;
			case "tit":
				pstmt.setString(1,search);
				break;
			case "con":
				pstmt.setString(1,search);
				break;
			}
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//별칭으로 받아온다.
				count=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return count;
	}//count(*)
	
	
	
	
	//---------------
	//입력.
	public int insert(String bName,String bTitle,String bContent) {
		check=0;
		sql="select * from mvc_board where bid=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			check=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	//contentView
	public BDto getContent(int bId) {
		sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bDate=rs.getTimestamp("bDate");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
		
	}
	
}
