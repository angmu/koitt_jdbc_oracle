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
	
	//객체선언
	
	int check=0;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String id_ch,pw_ch,sql;
	
	//id, pw
	public int userCheck(String id,String pw) {
		sql="select id,pw from b_member where id=?";
		try {
			con=getConnection();
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
	
	//모든 b_member 조회
	public ArrayList<MemberDto> getMembers(){
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		MemberDto mdto=null;
		
		sql="select * from b_member order by b_date desc";
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
	
	//오라클 연결
	private Connection getConnection() {
		Connection con=null;
		DataSource ds=null;
		Context context=null;
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return con;
	}
	
	//name 가져오기
	public MemberDto getMember(String id) {
		MemberDto mdto=null;
		sql="select * from b_member where id=?";
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
	
	//아이디 중복 체크
	public int confirmId(String id) {
		check=0;
		
		sql="select id from b_member where id=?";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//아이디 존재
				check=1;
			}else {
				//중복아이디없음
				check=0;
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
			}
		}
		return check;
	}
	
	//회원가입 입력 메소드
	public int insertMember(MemberDto mdto) {
		check=0;
		
		sql="insert into b_member (id,pw,name,email,address) values(?,?,?,?,?)";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setString(5, mdto.getAddress());
			check=pstmt.executeUpdate(); //저장성공 1, 저장안됨 0
		} catch (Exception e) {
			// TODO: handle exception
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
	
	//update 메소드
	public int updateMember(MemberDto mdto) {
		check=0;
		//원래 가입날짜 외 최종수정날을 바꿔야함..
		sql="update b_member set pw=?,name=?,email=?,address=?,b_date=sysdate where id=?";
		
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mdto.getPw());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getEmail());
			pstmt.setString(4, mdto.getAddress());
			pstmt.setString(5, mdto.getId());
			check=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
	
	//멤버 삭제
	public int deleteMember(String id) {
		check=0;
		sql="delete from b_member where id=?";
		
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			check=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
