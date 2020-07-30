package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;


public class MemberDao {
	private MemberDao() {}
	//싱글톤
	static MemberDao instance=new MemberDao();
	//객체생성
	public static MemberDao getInstance() {
		return instance;
	}
	
	//공통객체
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int check,size;
	String sql;
	
	
	//DB연결
	Connection getConnection() {
		DataSource ds=null;
		Context context=null;
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//보드 불러오기
	public ArrayList<MemberDto> getBoard(){
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		MemberDto mdto=null;
		sql="select * from b_board order by b_num desc";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mdto=new MemberDto();
				mdto.setB_num(rs.getInt("b_num"));
				mdto.setB_title(rs.getString("b_title"));
				mdto.setB_content(rs.getString("b_content"));
				mdto.setB_user(rs.getString("b_user"));
				mdto.setB_file(rs.getString("b_file"));
				list.add(mdto);
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
	
	//파일넣기
	public int insertBoard(String b_title,String b_content,String b_user,String b_file){
		check=0;
		sql="insert into b_board (b_num,b_title,b_content,b_user,b_file) values(br_seq.nextval-1,?,?,?,?)";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, b_title);
			pstmt.setString(2, b_content);
			pstmt.setString(3, b_user);
			pstmt.setString(4, b_file);
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
}
