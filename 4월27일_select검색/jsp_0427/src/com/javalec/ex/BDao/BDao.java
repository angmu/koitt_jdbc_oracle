package com.javalec.ex.BDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BDto;

public class BDao {
	//생성자에 db연결을 미리 생성.
	public BDao() {
		
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp.env.jdbc.Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//생성자
	
//	private BDao instance=new BDao();
//	public BDao getInstance() {
//		return instance;
//	}//싱글톤 패턴
	
	//객체선언
	Context context=null;
	DataSource ds=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql;
	int check;
	ArrayList<BDto> list=new ArrayList<BDto>();
	BDto bdto=null;
	int bId, bHit, bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	
	//전체 select
	public ArrayList<BDto> list(){
		
		sql="select * from mvc_board order by bId sesc";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bDate=rs.getTimestamp("bDate");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				bdto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
	
	
	
//	//커넥션 풀
//	public Connection getConnection() {
//		Context context=null;
//		DataSource ds=null;
//		try {
//			context=new InitialContext();
//			ds=(DataSource)context.lookup("java:comp.env.jdbc.Oracle11g");
//			con=ds.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con;
//	}//커넷션 풀
	
	
}
