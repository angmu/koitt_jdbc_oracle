package com.javalec.ex.MDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BDto;
import com.javalec.ex.MDto.MDto;

public class MDao {

	//db연결 필요 변수
			Context context=null;
			DataSource ds=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql=null;
			
			
			ArrayList<MDto> list=new ArrayList<MDto>();
			MDto dto=new MDto();
			
			//데이터를 받는데 필요변수
			String id,pw,name,gender,email_head,email_tail,address,phone_head,phone_mid,phone_tail,news,sms;
			Date birth;
			Timestamp j_date,u_date;
			
			
			//생성자
			public MDao() {
				//커넥션풀 생성(생성하자마자)
				try {
					context=new InitialContext();
					ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			//회원정보 전체받기(select)
			public ArrayList<MDto> getMembers(){
				
				sql="select * from MVC_MEMBER";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						id=rs.getString("id");
						pw=rs.getString("pw");
						name=rs.getString("name");
						gender=rs.getString("gender");
						email_head=rs.getString("email_head");
						email_tail=rs.getString("email_tail");
						address=rs.getString("address");
						phone_head=rs.getString("phone_head");
						phone_mid=rs.getString("phone_mid");
						phone_tail=rs.getString("phone_tail");
						news=rs.getString("news");
						sms=rs.getString("sms");
						birth=rs.getDate("birth");
						j_date=rs.getTimestamp("j_date");
						u_date=rs.getTimestamp("u_date");
						
						dto= new MDto(id, pw, name, gender, email_head, email_tail, address, phone_head, 
								phone_mid, phone_tail, news, sms, birth, j_date, u_date);
						
						list.add(dto);
					}
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
				return list;
				
			}//회원정보 전체받기(select)
			
			
			
			//회원한명 정보받기(select)
			public MDto getMember(String id) {
				
				sql="select * from MVC_MEMBER where id=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						id=rs.getString("id");
						pw=rs.getString("pw");
						name=rs.getString("name");
						gender=rs.getString("gender");
						email_head=rs.getString("email_head");
						email_tail=rs.getString("email_tail");
						address=rs.getString("address");
						phone_head=rs.getString("phone_head");
						phone_mid=rs.getString("phone_mid");
						phone_tail=rs.getString("phone_tail");
						news=rs.getString("news");
						sms=rs.getString("sms");
						birth=rs.getDate("birth");
						j_date=rs.getTimestamp("j_date");
						u_date=rs.getTimestamp("u_date");
						
						dto= new MDto(id, pw, name, gender, email_head, email_tail, address, phone_head, 
								phone_mid, phone_tail, news, sms, birth, j_date, u_date);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return dto;
				
			}//getMember
			
			
			
			//아이디 중복체크(select)
			
			public int idcheck(String id_ch) {
				
				int check=0;
				sql="select id from MVC_MEMBER where id=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id_ch);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						check=1;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//idcheck
			
			//회원가입(insert)
			public int join(String id,String pw,String name,String email_head, String email_tail,String address,String phone_head,String phone_mid,
			String phone_tail,Date birth,String gender,String news,String sms) {
				
				int check=0;
				//insert into lms_member2 values('rr234','3333','김고','werfw','ee.dd','서울','010','4433','5252','020304','남성','예','아니오',sysdate,'',0);
				sql="insert into MVC_MEMBER values(?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,'',0)";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,id);
					pstmt.setString(2,pw);
					pstmt.setString(3,name);
					pstmt.setString(4,email_head);
					pstmt.setString(5,email_tail);
					pstmt.setString(6,address);
					pstmt.setString(7,phone_head);
					pstmt.setString(8,phone_mid);
					pstmt.setString(9,phone_tail);
					pstmt.setDate(10,birth);
					pstmt.setString(11,gender);
					pstmt.setString(12,news);
					pstmt.setString(13,sms);
					
					check=pstmt.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}
			
			
			//회원정보 수정(update)
			public int mmodify(String id,String name,String  gender,String  email_head,String email_tail,String address,String phone_head, 
					String phone_mid,String phone_tail,String news,String sms, Date birth) {
				
				int check=0;
				sql="update MVC_MEMBER set name=?,email_head=?,email_tail=?,address=?,phone_head=?,phone_mid=?,phone_tail=?" + 
						",gender=?,news=?,sms=?,birth=?,u_date=sysdate where id=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, email_head);
					pstmt.setString(3, email_tail);
					pstmt.setString(4, address);
					pstmt.setString(5, phone_head);
					pstmt.setString(6, phone_mid);
					pstmt.setString(7, phone_tail);
					pstmt.setString(8, gender);
					pstmt.setString(9, news);
					pstmt.setString(10, sms);
					pstmt.setDate(11, birth);
					pstmt.setString(12, id);
					check=pstmt.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
				return check;
				
			}
			
			
			//회원로그인
			public int login(String id,String pw,HttpSession session) {
				
				int check=0;
				sql="select id,pw,name from MVC_MEMBER where id=? and pw=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						check=1;
						session.setAttribute("id",id);
						session.setAttribute("pw", rs.getString("pw"));
						session.setAttribute("name", rs.getString("name"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//login
			
			//관리자로그인(오버로딩)
			public int login(String id,String pw,int auth,HttpSession session) {
				
				int check=0;
				sql="select id,pw,name from MVC_MEMBER where id=? and pw=? and authority=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					pstmt.setInt(3, auth);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						check=1;
						session.setAttribute("admin_id",id);
						session.setAttribute("pw", rs.getString("pw"));
						session.setAttribute("name", rs.getString("name"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return check;
				
			}//login
			
			
	
	
	
}//class
