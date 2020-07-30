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
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql;
	int check;
	DataSource ds=null;
	Context context=null;
	BDto dto=null;
	ArrayList<BDto> list=null;
	String bId,bName,bTitle,bType,bContent,bFile1,bFile2;
	Timestamp bDate,uDate,start_date,end_date;
	int bHit,bGroup,bIndent,bStep,bNum;
	//커넥션 풀
	public BDao() {
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//글 등록
	public int write(String bId,String bName,String bTitle,String bType,String bContent,String bFile1,String bFile2,String start_date,String end_date) {
		check=0;
		sql="insert into mvc_adminTab values(?,?,?,?,?,?,?,sysdate,sysdate,?,?,0,0,0,0,admintab_seq.nextval)";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bId);
			pstmt.setString(2, bName);
			pstmt.setString(3, bTitle);
			pstmt.setString(4, bType);
			pstmt.setString(5, bContent);
			pstmt.setString(6, bFile1);
			pstmt.setString(7, bFile2);
			pstmt.setString(8, start_date);
			pstmt.setString(9, end_date);
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
	
	//이벤트 리스트 출력
	public ArrayList<BDto> printEvent(){
		list=new ArrayList<BDto>();
		
		sql="select * from mvc_adminTab where btype='event' order by bdate desc";
		

		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto.setbId(rs.getString("bId"));
				dto.setbName(rs.getString("bName"));
				dto.setbTitle(rs.getString("bId"));
				dto.setbType(rs.getString("bType"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setuDate(rs.getTimestamp("uDate"));
				dto.setStart_date(rs.getTimestamp("Start_date"));
				dto.setEnd_date(rs.getTimestamp("End_date"));
				dto.setbGroup(rs.getInt("bGroup"));
				dto.setbStep(rs.getInt("bStep"));
				dto.setbIndent(rs.getInt("bIndent"));
				dto.setbNum(rs.getInt("bNum"));
				dto=new BDto(bId, bName, bTitle, bType, bContent, bFile1, bFile2, bDate, uDate, start_date, end_date, bHit, bGroup, bStep, bIndent, bNum);
				list.add(dto);
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
	
	
	
}
