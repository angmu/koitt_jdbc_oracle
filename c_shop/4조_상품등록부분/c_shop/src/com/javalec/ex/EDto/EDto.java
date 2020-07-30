package com.javalec.ex.EDto;

import java.sql.Date;

public class EDto {
 
	public EDto() {
		
	}

	public EDto(int eId, String eFlag, int rnum, String eTitle, String eTitleimg, String eContentimg, Date eDate_start,
			Date eDate_end) {
		super();
		this.eId = eId;
		this.eFlag = eFlag;
		this.rnum = rnum;
		this.eTitle = eTitle;
		this.eTitleimg = eTitleimg;
		this.eContentimg = eContentimg;
		this.eDate_start = eDate_start;
		this.eDate_end = eDate_end;
	}


	int eId,rnum;
	String eTitle,eTitleimg,eContentimg,eFlag;
	Date eDate_start,eDate_end;
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteFlag() {
		return eFlag;
	}
	public void seteFlag(String eFlag) {
		this.eFlag = eFlag;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteTitleimg() {
		return eTitleimg;
	}
	public void seteTitleimg(String eTitleimg) {
		this.eTitleimg = eTitleimg;
	}
	public String geteContentimg() {
		return eContentimg;
	}
	public void seteContentimg(String eContentimg) {
		this.eContentimg = eContentimg;
	}
	public Date geteDate_start() {
		return eDate_start;
	}
	public void seteDate_start(Date eDate_start) {
		this.eDate_start = eDate_start;
	}
	public Date geteDate_end() {
		return eDate_end;
	}
	public void seteDate_end(Date eDate_end) {
		this.eDate_end = eDate_end;
	}
	
	
	
	
	
	
	
	
}
