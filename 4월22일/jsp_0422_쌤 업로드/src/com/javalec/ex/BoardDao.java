package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	
	private BoardDao() {
		
	}
	//클래스 객체 - 1개 객체생성 
	private static BoardDao instance = new BoardDao();
	//싱글톤 패턴
	public static BoardDao getInstance() {
		return instance;
	}
	
	//객체 선언
	BoardDao bdao = null;
	BoardDto bdto=null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	int b_num=0;
	String b_title="";
	String b_content="";
	String b_user="";
	String b_file="";
	String sql="";
	
	
	//update 메소드
	public int updateBoard(BoardDto bdto) {
		int check = 0;
		
		sql="update board set b_title=?,b_content=?,b_file=? where b_num=?";
		
		try {
			con = getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getB_title());
			pstmt.setString(2, bdto.getB_content());
			pstmt.setString(3, bdto.getB_file());
			pstmt.setInt(4, bdto.getB_num());
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	
	//insert메소드
	public int insertBoard(BoardDto bdto) {
		int check=0;

		sql="insert into board values(b_board.nextval,?,?,?,?)";
		
		try {
			con = getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getB_title());
			pstmt.setString(2, bdto.getB_content());
			pstmt.setString(3, bdto.getB_user());
			pstmt.setString(4, bdto.getB_file());
			check = pstmt.executeUpdate();
			
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
	
	//1개 select 메소드
	public BoardDto getBoard(int b_num) {
		
		
		sql= "select * from board where b_num=?";
		
		try {
			con = getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setB_num(rs.getInt("b_num"));
				bdto.setB_title(rs.getString("b_title"));
				bdto.setB_content(rs.getString("b_content"));
				bdto.setB_user(rs.getString("b_user"));
				bdto.setB_file(rs.getString("b_file"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bdto;
	}
	
	
	
	// 전체 select 메소드
	public ArrayList<BoardDto> getBoards() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
		sql= "select * from board";
		
		try {
			con = getconnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bdto = new BoardDto();
				bdto.setB_num(rs.getInt("b_num"));
				bdto.setB_title(rs.getString("b_title"));
				bdto.setB_content(rs.getString("b_content"));
				bdto.setB_user(rs.getString("b_user"));
				bdto.setB_file(rs.getString("b_file"));
				list.add(bdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	//커넥션 객체 생성 메소드
	private Connection getconnection() {
		Context context=null;
		DataSource ds=null;
		Connection con=null;
		
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con = ds.getConnection();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	

}
