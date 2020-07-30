package com.javalec.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
	//생성자
	public MemberDao(){
		// 1.jdbc로딩 > 2. Connection 연결 > 3. preparedstatement연결 > 4. executeQuery 혹은 executeupdate
		try {
		//1.jdbc로딩 ---> 미리 연결 (로딩시 시간소요가 되기 때문에 생성자에서 미리 해준다)
			//*서버에서 작업해놔서 필없어짐 Class.forName("oracle.jdbc.driver.OracleDriver");
			Context context =new InitialContext();
			//	위치               |>이후 이름			
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	ArrayList<MemberDto> dtos=new ArrayList<MemberDto>();
	//++톰캣 선언후 필해진 객체 선언
	DataSource dataSource=null;
	// db접속에 필요한 객체선언
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String id,pw,name,phone1,phone2,phone3,gender;
	String sql;
	
	//전체 리스트 출력
	public ArrayList<MemberDto> member_Select(){
		
		
		
		try {
			//db연결
//			"select * from member2 where id=?"
			sql="select * from member2";
			//++톰캣 선언후 커넥션
			con=dataSource.getConnection();
//*			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//데이터 담기
			while(rs.next()) {
				id=rs.getString("id");
				pw=rs.getString("pw");
				name=rs.getString("name");
				phone1=rs.getString("phone1");
				phone2=rs.getString("phone2");
				phone3=rs.getString("phone3");
				gender=rs.getString("gender");
//				int num=rs.getInt("num");
//				Timestamp date=rs.getTimestamp("date");
				
				MemberDto mdto=new MemberDto(id,pw,name,phone1,phone2,phone3,gender);
				dtos.add(mdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		//리턴값으로 돌려줌
		return dtos;
	}
	
	
	
}
