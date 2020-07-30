package com.javalec.ex.BDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BMemberDto;

public class MemberDao {
	public MemberDao(){
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql;
	int check;
	DataSource ds=null;
	Context context=null;
	BMemberDto mdto=null;
	ArrayList<BMemberDto> list=null;
	//로그인
	//id, pw체크 (로그인체크)
	public int login_check(String id,String pw) {
		check=0;
		sql="select id,pw from c_member where id=?";
				
				try {
					con=ds.getConnection();
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
		public BMemberDto getMember(String id) {
			sql="select * from c_member where id=?";
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					mdto=new BMemberDto();
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
				e.printStackTrace();
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
		
	
}
