package com.member.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.Dto.MemberDto;

public class MemberDao {
	private MemberDao() {}
	
	private static MemberDao instance=new MemberDao();
	
	//싱글톤패턴
	public static MemberDao getInstance() {
		return instance;
	}
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	int check;
	String sql;
	
	//커넥션폴
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
	}
	
	//아래는 구조까지만 만듦.
	
	//select전체
	public ArrayList<MemberDto> getMembers() {
		ArrayList<MemberDto> list= new ArrayList<MemberDto>();
		
		
		return list;
	}//getMembers()
	
	//멤버추가
		public int insertMember() {
			check=0;
			
			return check;
		}
		//멤버삭제
		public int deleteMember(String id) {
			check=0;
			
			return check;
		}
		//멤버수정
		public int updateMember(String id) {
			check=0;
			
			return check;
		}
		
	
}//class
