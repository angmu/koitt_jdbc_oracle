package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemDao {
	public MemDao(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	ArrayList<MemDto> mdao=new ArrayList<MemDto>();
	DataSource ds=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int m_num;
	Timestamp birth,m_date;
	String m_id,pw,m_name,email,address,phone,gender,news,sms;
	String sql;
	
	
	//전체출력
	public ArrayList<MemDto> select(){
		
		try {
			sql="select * from member3";
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//데이터 담기
			while(rs.next()) {
			m_num=rs.getInt("m_num");
			m_id=rs.getString("m_id");
			pw=rs.getString("pw");
			m_name=rs.getString("m_name");
			email=rs.getString("email");
			address=rs.getString("address");
			phone=rs.getString("phone");
			birth=rs.getTimestamp("birth");
			gender=rs.getString("gender");
			news=rs.getString("news");
			sms=rs.getString("sms");
			m_date=rs.getTimestamp("m_date");
			
			MemDto mdto=new MemDto(m_num,m_id,pw,m_name,email,address,phone,birth,gender,news,sms,m_date);
			mdao.add(mdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		return mdao;
	}
	
	
	//입력메소드
	public int insert(String m_id,String pw,String m_name,String email,String address,String phone,String birth,String gender,String news,String sms){
		int check=0;
		try {
			sql="insert into member3(m_num,m_id,pw,m_name,email,address,phone,birth,gender,news,sms) values(\r\n" + 
					"B_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)";
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, pw);
			pstmt.setString(3, m_name);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, phone);
			pstmt.setString(7, birth);
			pstmt.setString(8, gender);
			pstmt.setString(9, news);
			pstmt.setString(10, sms);
			check=pstmt.executeUpdate();
			if(check==1) {
				
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		return check;
	}
	
}
