package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	//singleton
	private MemberDao(){}

//	객체선언 MemberDao mdao=new Member(); 프로그램 구동 동시에 생성됨static
	static MemberDao instance=new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	//id, pw
	public int userCheck(String id,String pw) {
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataSource ds=null;
		String id_ch,pw_ch="";
		String sql="select id,pw from b_member where id=?";
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			//if(re!=null) >>rs null값을 반환한다...해서 이케 쓰믄안된다칸다..
			if(rs.next()){	
				System.out.println(rs);
				//데이터가 있을경우
//				while(rs.next()){
				id_ch=rs.getString("id");
				pw_ch=rs.getString("pw");
				if(pw_ch.equals(pw)) {
					check=1;//비번일치
				}else{
					check=0;//비번틀림
				}
				
//				}
			}
			//데이터가 없을경우
			else{
				check= -1;//id미존재
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			check=-1;
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
		return check;
	}//id,pw check
	
	
	public ArrayList<MemberDto> getMembers(){
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto mdto=null;
		
		String sql="select * from b_member";
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mdto=new MemberDto();
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAddress(rs.getString("address"));
				mdto.setD_date(rs.getTimestamp("b_date"));
				list.add(mdto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
		
		return list;
	}
	
	
	
	
	//name 가져오기
	public MemberDto getMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto mdto=null;
		
		String sql="select * from b_member where id=?";
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mdto=new MemberDto();
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAddress(rs.getString("address"));
				mdto.setD_date(rs.getTimestamp("b_date"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
	}//name 가져오기
}
