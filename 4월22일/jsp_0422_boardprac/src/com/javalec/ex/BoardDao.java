package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private BoardDao() {}
	
	private static BoardDao instance=new BoardDao();
	
	//싱글톤 패턴
	public static BoardDao getInstance() {
		return instance;
	}
	
	//객체 선언
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	BoardDao bdao=null;
	BoardDto bdto=null;
	String sql="";
	int check=0;
	
	
	//insert 메소드
	public int insertBoard(BoardDto bdto) {
		check=0;
		sql="insert into b_board values(br_seq.nextval-1,?,?,?,?)";
		
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bdto.getB_title());
			pstmt.setString(2,bdto.getB_content());
			pstmt.setString(3,bdto.getB_user());
			pstmt.setString(4,bdto.getB_file());
			check=pstmt.executeUpdate();
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
	
	//커넥션 객체 생성
	private Connection getConnection() {
		Context context=null;
		DataSource ds=null;
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//전체 select메소드
	public ArrayList<BoardDto> getBoards(){
		ArrayList<BoardDto> list=new ArrayList<BoardDto>();
		sql="select * from b_board order by b_num desc";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bdto=new BoardDto();
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
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//1개만 select메소드
	public BoardDto getBoard(int b_num){
		sql="select * from b_board where b_num=?";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs=pstmt.executeQuery();
			//while대신 if로 받는다.
			if(rs.next()) {
				bdto=new BoardDto();
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
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bdto;
	}
	//modify method
	public int modifyBoard(BoardDto bdto) {
		check=0;
		sql="update b_board set b_title=?,b_content=?,b_file=? where b_num=?";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bdto.getB_title());
			pstmt.setString(2,bdto.getB_content());
//			pstmt.setString(3,bdto.getB_user());
			pstmt.setString(3,bdto.getB_file());
			pstmt.setInt(4,bdto.getB_num());
			check=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
}
