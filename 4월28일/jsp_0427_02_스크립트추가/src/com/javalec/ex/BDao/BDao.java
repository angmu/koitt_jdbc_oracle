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

	//객체선언
	DataSource ds=null;
	Context context=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	ArrayList<BDto> dtos=new ArrayList<BDto>();
	BDto dto=new BDto();
	
	//db컬럼
	int BId,BGroup,BHit,BStep,BIndent,check;
	String BName,BTitle,BContent,sql;
	Timestamp BDate;
	
	//생성자,커넥션풀
	public BDao() {
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자,커넥션풀
	
	//select 전체
	public ArrayList<BDto> list() {
		//글 순서는 30번이라도 25의 답글이면 25밑에 붙어야하기때문에 그룹으로 정렬
		sql="select * from mvc_board order by BGroup desc";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BId=rs.getInt("BId");
				BName=rs.getString("BName");
				BTitle=rs.getString("BTitle");
				BContent=rs.getString("BContent");
				BDate=rs.getTimestamp("BDate");
				BHit=rs.getInt("BHit");
				BGroup=rs.getInt("BGroup");
				BStep=rs.getInt("BStep");
				BIndent=rs.getInt("BIndent");
				dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
				dtos.add(dto);
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
		return dtos;
	}//select 전체
	
	
	//select 1개
	public BDto contentView(int bId) {
		
		//조회수 1 증가
		// update mvc_board set bhit=bhit+1 where bId=2;
		upHit(bId);
		
		sql="select * from mvc_board where bId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				BId=rs.getInt("BId");
				BName=rs.getString("BName");
				BTitle=rs.getString("BTitle");
				BContent=rs.getString("BContent");
				BDate=rs.getTimestamp("BDate");
				BHit=rs.getInt("BHit");
				BGroup=rs.getInt("BGroup");
				BStep=rs.getInt("BStep");
				BIndent=rs.getInt("BIndent");
				dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};
		return dto;
	}
	
	//조회수1 증가
	public int upHit(int bId) {
		sql="update mvc_board set bHit=bHit+1 where bId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			check=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};
		return check;
	}//조회수1 증가
	
	
	
	
	//insert (입력)
	public int write(String bName,String bTitle,String bContent) {
		
		sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
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
	}//insert (입력)
	
	
	//delete (삭제)
	public int delete(int bId) {
			check=0;
			sql="delete mvc_board where bId=?";
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bId);
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
		}//delete (삭제)
	
		//개시글 수정 view -select
			public BDto modify_view(int bId) {
				
				//게시글 view와 달리 조회수 1증가는 없다.
				sql="select * from mvc_board where bId=?";
				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					rs=pstmt.executeQuery();
					
					if(rs.next()) {
						BId=rs.getInt("BId");
						BName=rs.getString("BName");
						BTitle=rs.getString("BTitle");
						BContent=rs.getString("BContent");
						BDate=rs.getTimestamp("BDate");
						BHit=rs.getInt("BHit");
						BGroup=rs.getInt("BGroup");
						BStep=rs.getInt("BStep");
						BIndent=rs.getInt("BIndent");
						dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						if(con!=null)con.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				};
				return dto;
			}//개시글 수정 view -selec
			
			
			//게시물수정 modify
			public int modify(int BId,String BTitle,String BContent) {
				
				sql="update mvc_board set bTitle=?,bcontent=? where bid=?";
				

				try {
					con=ds.getConnection();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, BTitle);
					pstmt.setString(2, BContent);
					pstmt.setInt(3, BId);
					check=pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(pstmt!=null)pstmt.close();
						if(con!=null)con.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				return check;
			}//게시물수정 modify
			
			
			
	
			//게시글 답글 view페이지
		public BDto reply_view(int bId) {
			
			//게시글 view와 달리 조회수 1증가는 없다.
			sql="select * from mvc_board where bId=?";
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bId);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					BId=rs.getInt("BId");
					BName=rs.getString("BName");
					BTitle=rs.getString("BTitle");
					BContent=rs.getString("BContent");
					BDate=rs.getTimestamp("BDate");
					BHit=rs.getInt("BHit");
					BGroup=rs.getInt("BGroup");
					BStep=rs.getInt("BStep");
					BIndent=rs.getInt("BIndent");
					dto=new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			};
			return dto;
		}
		//게시글 답글 view페이지
	
		
		
		
		
		//답글달기 reply- insert
		public int reply(int BId,String BName,String BTitle,String BContent,int BGroup,int BStep,int BIndent){
			check=0;
			//답글달려있는 리스트 step 1씩 증가
			replyshape(BGroup,BStep);
			
			sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,?,?,?)";
			
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, BName);
				pstmt.setString(2, BTitle);
				pstmt.setString(3, BContent);
				pstmt.setInt(4, BGroup);
				//답글에 달아야한다리 '0'!
				pstmt.setInt(5, BStep+1);
				//들여쓰기
				pstmt.setInt(6, BIndent+1);
				check=pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			return check;
		}//답글달기 reply- insert
		
		//답글달려있는 리스트 step 1씩 증가
		public void replyshape(int BGroup,int BStep) {
			//bgroup이 같을경우에만..+1
			sql="update mvc_board set bStep=bStep+1 where bGroup=? and bStep>?";
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, BGroup);
				pstmt.setInt(2, BStep);
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
		}
		
		
}
