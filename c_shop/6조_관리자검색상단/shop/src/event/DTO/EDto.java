package event.DTO;

import java.sql.Timestamp;

public class EDto {

	public EDto(){
		
	}
	
	int fnum;
	String ftitle;
	String fcontent;
	String fuser;
	String ffile1,ffile2;
	Timestamp fdate1,fdate2;
	
	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFuser() {
		return fuser;
	}

	public void setFuser(String fuser) {
		this.fuser = fuser;
	}

	public String getFfile1() {
		return ffile1;
	}

	public void setFfile1(String ffile1) {
		this.ffile1 = ffile1;
	}

	public String getFfile2() {
		return ffile2;
	}

	public void setFfile2(String ffile2) {
		this.ffile2 = ffile2;
	}

	public Timestamp getFdate1() {
		return fdate1;
	}

	public void setFdate1(Timestamp fdate1) {
		this.fdate1 = fdate1;
	}

	public Timestamp getFdate2() {
		return fdate2;
	}

	public void setFdate2(Timestamp fdate2) {
		this.fdate2 = fdate2;
	}

	public EDto(int fnum,String ftitle,String fcontent,String fuser,String ffile1,String ffile2,Timestamp fdate1,Timestamp fdate2) {
		this.fnum=fnum;
		this.ftitle=ftitle;
		this.fcontent = fcontent;
		this.fuser = fuser;
		this.ffile1 = ffile1;
		this.ffile2 = ffile2;
		this.fdate1 = fdate1;
		this.fdate2 = fdate2;
	}
	}
