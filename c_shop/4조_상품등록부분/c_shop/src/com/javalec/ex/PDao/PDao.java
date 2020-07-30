package com.javalec.ex.PDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.EDto.EDto;
import com.javalec.ex.PDto.PDto;

public class PDao {

	//db연결 필요 변수
	Context context=null;
	DataSource ds=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	
	ArrayList<PDto> list=new ArrayList<PDto>();
	PDto dto=new PDto();
	
	//데이터를 받는데 필요변수
	int pId,pPrice,pDelivery,pAmount,pTime;
	String pCategory,pName,pTitleimg,pContentimg1,pContentimg2,pContent;
	Timestamp pDate;
	
	
	//생성자
	public PDao() {
		//커넥션풀 생성(생성하자마자)
		try {
			context=new InitialContext();
			ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//전체 select-list
	public ArrayList<PDto> plist(int page,int limit) {
		//번호를 붙여서 가져옴(최대 갯수만큼)
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;
		
		sql="select * from (select rownum rnum,pId,pPrice,pDelivery,pAmount,pTime,pCategory,pName,pTitleimg,pContentimg1,pContentimg2,pContent,pregdate from"+ 
			"(select * from mvc_product order by pId asc)) where rnum>=? and rnum<=?";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				pId=rs.getInt("pId");
				pPrice=rs.getInt("pPrice");
				pDelivery=rs.getInt("pDelivery");
				pAmount=rs.getInt("pAmount");
				pTime=rs.getInt("pTime");
				pCategory=rs.getString("pCategory");
				pName=rs.getString("pName");
				pTitleimg=rs.getString("pTitleimg");
				pContentimg1=rs.getString("pContentimg1");
				pContentimg2=rs.getString("pContentimg2");
				pContent=rs.getString("pContent");
				pDate=rs.getTimestamp("pregdate");
				
				dto=new PDto(pId, pCategory, pName, pPrice, pDelivery, pTitleimg, pContentimg1, pContentimg2, pAmount, pTime, pDate, pContent);
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
		
	}//전체 select
	
	
	//전체 select(메인페이지 표시용)
		public ArrayList<PDto> main_menu_view() {
			
			sql="select * from mvc_product order by pId desc";
			
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					pId=rs.getInt("pId");
					pPrice=rs.getInt("pPrice");
					pDelivery=rs.getInt("pDelivery");
					pAmount=rs.getInt("pAmount");
					pTime=rs.getInt("pTime");
					pCategory=rs.getString("pCategory");
					pName=rs.getString("pName");
					pTitleimg=rs.getString("pTitleimg");
					pContentimg1=rs.getString("pContentimg1");
					pContentimg2=rs.getString("pContentimg2");
					pContent=rs.getString("pContent");
					pDate=rs.getTimestamp("pregdate");
					
					dto=new PDto(pId, pCategory, pName, pPrice, pDelivery, pTitleimg, pContentimg1, pContentimg2, pAmount, pTime, pDate, pContent);
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
			
		}//전체 select(메인페이지 표시용)
	
	//한개 select
	public PDto pcontent_view(int pId) {
		
		sql="select * from mvc_product where pId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pId=rs.getInt("pId");
				pCategory=rs.getString("pCategory");
				pName=rs.getString("pName");
				pPrice=rs.getInt("pPrice");
				pDelivery=rs.getInt("pDelivery");
				pTitleimg=rs.getString("pTitleimg");
				pContentimg1=rs.getString("pContentimg1");
				pContentimg2=rs.getString("pContentimg2");
				pAmount=rs.getInt("pAmount");
				pTime=rs.getInt("pTime");
				pDate=rs.getTimestamp("pRegdate");
				pContent=rs.getString("pContent");
				
				dto=new PDto(pId, pCategory, pName, pPrice, pDelivery, pTitleimg, pContentimg1, pContentimg2, pAmount, pTime, pDate, pContent);
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
		
	}//한개 select
	
	
	//상품 추가(insert)
	public int pwrite(String pCategory, String pName, int pPrice, int pDelivery, String pTitleimg,
			String pContentimg1, String pContentimg2, int pAmount, int pTime,String pContent) {
		//insert into mvc_product values(mvc_product_seq.nextval,'cate','name',1000,2000,'timg','cimg1','cimg2',3,15,sysdate,'좋은상품');
		sql="insert into mvc_product values(mvc_product_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate,?)";
		int check=0;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pCategory);
			pstmt.setString(2, pName);
			pstmt.setInt(3, pPrice);
			pstmt.setInt(4, pDelivery);
			pstmt.setString(5, pContentimg1);
			pstmt.setString(6, pTitleimg);
			pstmt.setString(7, pContentimg2);
			pstmt.setInt(8, pAmount);
			pstmt.setInt(9, pTime);
			pstmt.setString(10, pContent);
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
	}//상품 입력(insert)
	
	//배너가져오기(메인페이지)
	
	public String bannerget() {
		String banner="";
		sql="select max(banner) KEEP(DENSE_RANK FIRST ORDER BY regdate DESC) banner from mvc_banner";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				banner=rs.getString("banner");
			}
		}catch(Exception e){
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
		
		return banner;
		
	}//배너가져오기(메인페이지)
	
	
	//배너등록하기(insert)
	
	public int banner_write(String banner) {
		
		int check=0;
		sql="insert into mvc_banner values (?,sysdate)";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, banner);
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
		
	}//배너등록하기(insert)
	
	
	//수정하기(modify)
	
	public int pmodify(String pContent,String pName,String pCategory,int pId,int pPrice,int pDelivery,int pAmount,int pTime,
			String pTitleimg,String pContentimg1,String pContentimg2) {
		
		int check=0;
		sql="update mvc_product set pContent=?,pName=?,pCategory=?,pTitleimg=?,pContentimg1=?,pContentimg2=?,pPrice=?,pDelivery=?,pAmount=?,pTime=? where pId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pContent);
			pstmt.setString(2, pName);
			pstmt.setString(3, pCategory);
			pstmt.setString(4, pTitleimg);
			pstmt.setString(5, pContentimg1);
			pstmt.setString(6, pContentimg2);
			pstmt.setInt(7, pPrice);
			pstmt.setInt(8, pDelivery);
			pstmt.setInt(9, pAmount);
			pstmt.setInt(10, pTime);
			pstmt.setInt(11, pId);
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
		
	}//modify
	
	
	
	//삭제(delete)
	public int pdelete(int pId) {
		//filedelete(pId);
		int check=0;
		sql="delete from mvc_product where pId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,pId);
			check=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) rs.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		System.out.println(check);
		return check;
		
	}//delete
	
	
	//파일삭제 메소드(나중에 할것)
//	public void filedelete(int pId) {
//		String[] file=new String[3];
//		sql="select pTitleimg,pContentimg1,pContentimg2 from mvc_product where pId=?";
//		try {
//			con=ds.getConnection();
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, pId);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				file[0]=rs.getString("pTitleimg");
//				file[1]=rs.getString("pContentimg1");
//				file[2]=rs.getString("pContentimg2");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		for(int i=0;i<file.length;i++) {
//			if(file[i]!=null || file[i]!="") {
//				file[i]+="C:\Users\fhgjg\workspace\jsp_0509\WebContent\pupload"
//			}
//		}
//		
//		
//	}//filedelete
	
	//전체 카운트 얻어오기
	public int getelistCount() {
		
		int count=0;
		
		sql="select count(*) as count from mvc_product";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count");
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
		
		return count;
	}//전체 카운트 얻어오기
	

	
	
	
	
}
