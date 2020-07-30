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

	//객체선언
	DataSource ds=null;
	Context context=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	ArrayList<BDto> dtos=new ArrayList<BDto>();
	BDto dto=new BDto();
	
	//db컬럼
	int BId,BGroup,BHit,BStep,BIndent,check;
	String BName,BTitle,BContent,sql;
	Timestamp BDate;
	
	//생성자,커넥션풀
	public BDao() {
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자,커넥션풀
	
	//select 전체
	public ArrayList<BDto> list() {
		
		sql="select * from mvc_board order by bId desc";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BId=rs.getInt("BId");
				BName=rs.getString("BName");
				BTitle=rs.getString("BTitle");
				BContent=rs.getString("BContent");
				BDate=rs.getTimestamp("BDate");
				BHit=rs.getInt("BHit");
				BGroup=rs.getInt("BGroup");
				BStep=rs.getInt("BStep");
				BIndent=rs.getInt("BIndent");
				dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
				dtos.add(dto);
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
		return dtos;
	}//select 전체
	
	
	//select 1개
	public BDto contentView(int bId) {
		
		//조회수 1 증가
		// update mvc_board set bhit=bhit+1 where bId=2;
		upHit(bId);
		
		sql="select * from mvc_board where bId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				BId=rs.getInt("BId");
				BName=rs.getString("BName");
				BTitle=rs.getString("BTitle");
				BContent=rs.getString("BContent");
				BDate=rs.getTimestamp("BDate");
				BHit=rs.getInt("BHit");
				BGroup=rs.getInt("BGroup");
				BStep=rs.getInt("BStep");
				BIndent=rs.getInt("BIndent");
				dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};
		return dto;
	}
	
	//조회수1 증가
	public int upHit(int bId) {
		sql="update mvc_board set bHit=bHit+1 where bId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			check=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};
		return check;
	}//조회수1 증가
	
	
	
	
	//insert
	public int insert() {
		
		sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
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
	
}
