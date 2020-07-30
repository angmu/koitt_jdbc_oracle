package com.javalec.ex.EDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.EDto.EDto;

public class EDao {
			//db연결 필요 변수
			Context context=null;
			DataSource ds=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql=null;
			
			ArrayList<EDto> list=new ArrayList<EDto>();
			EDto dto=new EDto();
			
			//데이터를 받는데 필요변수
			int eId,rnum;
			String eTitle,eTitleimg,eContentimg,eFlag;
			Date eDate_start,eDate_end;
			
			
			//생성자
			public EDao() {
				//커넥션풀 생성(생성하자마자)
				try {
					context=new InitialContext();
					ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
			//전체 select-list
			public ArrayList<EDto> elist(int page,int limit) {
				//번호를 붙여서 가져옴(최대 갯수만큼)
				int startrow=(page-1)*10+1;
				int endrow=startrow+limit-1;
				sql="select * from (select rownum rnum,eId,eTitle,eTitleimg,eContentimg,eDate_start,eDate_end,round(eDate_start-sysdate) as eFlag1,round(eDate_end-sysdate) as eFlag2 from"+ 
					"(select * from mvc_event order by eId asc)) where rnum>=? and rnum<=?";
				
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startrow);
					pstmt.setInt(2, endrow);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						rnum=rs.getInt("rnum");
						eId=rs.getInt("eId");
						eTitle=rs.getString("eTitle");
						eTitleimg=rs.getString("eTitleimg");
						eContentimg=rs.getString("eContentimg");
						eDate_start=rs.getDate("eDate_start");
						eDate_end=rs.getDate("eDate_end");
						int eflag1=rs.getInt("eflag1");//이벤트 기간확인을 위한 변수
						int eflag2=rs.getInt("eflag2");
						eFlag=calFlag(eflag1,eflag2);
						//eFlag=calFlag(eDate_start,eDate_end);
						dto=new EDto(eId, eFlag, rnum, eTitle, eTitleimg, eContentimg, eDate_start, eDate_end);
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
			
			//세개 select(글읽기)
			public ArrayList<EDto> eContentView(int eId, int rnum) {
				//첫글과 맨마지막인지를 판단하여 분기
				int listcount=getelistCount();
				if(rnum==1) {
					sql="select * from (select rownum rnum,eid,etitle,etitleimg,econtentimg,eDate_start,eDate_end from" + 
						"(select * from mvc_event order by eid asc))" + 
						"where eid between ? and (select min(eid) from mvc_event where eid>?) order by rnum desc";
				}
				else if(rnum==listcount) {
					sql="select * from (select rownum rnum,eid,etitle,etitleimg,econtentimg,eDate_start,eDate_end from" + 
						"(select * from mvc_event order by eid asc))" + 
						"where eid between (select max(eid) from mvc_event where eid<?) and ? order by rnum asc";
				}
				else {
					sql="select * from (select rownum rnum,eid,etitle,etitleimg,econtentimg,eDate_start,eDate_end from" + 
						"(select * from mvc_event order by eid asc))" + 
						"where eid between (select max(eid) from mvc_event where eid<?) and (select min(eid) from mvc_event where eid>?)";
				}
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, eId);
					pstmt.setInt(2, eId);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						eId=rs.getInt("eId");
						eTitle=rs.getString("eTitle");
						eTitleimg=rs.getString("eTitleimg");
						eContentimg=rs.getString("eContentimg");
						eDate_start=rs.getDate("eDate_start");
						eDate_end=rs.getDate("eDate_end");
						dto=new EDto(eId, "0", 0, eTitle, eTitleimg, eContentimg, eDate_start, eDate_end);
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
				
			}//세개 select
			
			//한개 select(수정용)
			public EDto eContentView2(int eId) {
				
				sql="select * from mvc_event where eId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, eId);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						eId=rs.getInt("eId");
						eTitle=rs.getString("eTitle");
						eTitleimg=rs.getString("eTitleimg");
						eContentimg=rs.getString("eContentimg");
						eDate_start=rs.getDate("eDate_start");
						eDate_end=rs.getDate("eDate_end");
						dto=new EDto(eId, "0", 0, eTitle, eTitleimg, eContentimg, eDate_start, eDate_end);
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
			
			//이벤트 추가(insert)
			public int ewrite(String eTitle,Date eDate_start,Date eDate_end, String eTitleimg,String eContentimg) {
				sql="insert into mvc_event values(mvc_event_seq.nextval,?,?,?,sysdate,?,?)";
				int check=0;
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, eTitle);
					pstmt.setString(2, eTitleimg);
					pstmt.setString(3, eContentimg);
					pstmt.setDate(4, eDate_start);
					pstmt.setDate(5, eDate_end);
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
			}//이벤트 입력(insert)
			
			//삭제(delete)
			public int edelete(int eId) {
				
				int check=0;
				sql="delete from mvc_event where eId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, eId);
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
				
				return check;
				
			}//delete
			
			//수정하기(modify)
			
			public int emodify(String eTitle,Date eDate_start,Date eDate_end,String eTitleimg,String eContentimg,int eId) {
				
				int check=0;
				sql="update mvc_event set eTitle=?,eTitleimg=?,eContentimg=?,eDate_start=?,eDate_end=? where eId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, eTitle);
					pstmt.setString(2, eTitleimg);
					pstmt.setString(3, eContentimg);
					pstmt.setDate(4, eDate_start);
					pstmt.setDate(5, eDate_end);
					pstmt.setInt(6, eId);
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
			
			
			//전체 카운트 얻어오기
			public int getelistCount() {
				
				int count=0;
				
				sql="select count(*) as count from mvc_event";
				
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
			
			//날짜계산하기
			public String calFlag(int eflag1,int eflag2) {
				
				String flag="";
				
				if(eflag1<0 && eflag2>0) {
					flag="진행중";
				}
				else if(eflag2<0) {
					flag="종료";
				}
				else {
					flag="진행예정";
				}
				
				
				return flag;
				
			}
			
			
			
}
