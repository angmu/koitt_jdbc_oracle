package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private MemberDao() {}
	
	//싱글톤
	static MemberDao instance=new MemberDao();
	
	//공통객체
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int check;//결과값
	String sql;
	Timestamp b_date,u_date;
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	//오라클 db연결 메소드
	public Connection getConnection() {
		Context context=null;
		DataSource ds=null;
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}//db연결
	
	
	//id, pw체크 (로그인체크)
	public int login_check(String id,String pw) {
		check=0;
		sql="select id,pw from c_member where id=?";
		
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			//rs가 있으면..아이디가 있는것.. yes..
			if(rs.next()) {
				if(pw.equals(rs.getString("pw"))) {
					//비번일치
					check=1;
				}else {
					//비번불일치
					check=0;
				}
			}else {
				//아이디 미존재..
				check=-1;
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
		return check;
	}
	//회원 1명조회
	public MemberDto getMember(String id) {
		MemberDto mdto=null;
		sql="select * from c_member where id=?";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mdto=new MemberDto();
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAddress1(rs.getString("address1"));
				mdto.setAddress2(rs.getString("address2"));
				mdto.setAddress3(rs.getString("address3"));
				mdto.setB_date(rs.getTimestamp("b_date"));
				mdto.setU_date(rs.getTimestamp("u_date"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return mdto;
	}
	
	
	//회원 전체 조회
	public ArrayList<MemberDto> getMembers(){
		ArrayList<MemberDto> list= new ArrayList<MemberDto>();
		MemberDto mdto=null;
		sql="select *from c_member order by b_date desc";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mdto=new MemberDto();
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAddress1(rs.getString("address1"));
				mdto.setAddress2(rs.getString("address2"));
				mdto.setAddress3(rs.getString("address3"));
				mdto.setB_date(rs.getTimestamp("b_date"));
				mdto.setU_date(rs.getTimestamp("u_date"));
				list.add(mdto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		return list;
	}
}
