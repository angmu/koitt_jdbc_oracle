package com.javalec.ex.RDto;

import java.sql.Timestamp;

public class RDto {
	
	public RDto() {
		
	}
	

	public RDto(int rNum, int rId, String id, String name, String rTitle, String rContent, String rContentimg,
			Timestamp rDate, int rHit, int rGroup, int rStep, int rIndent) {
		super();
		this.rNum = rNum;
		this.rId = rId;
		this.id = id;
		this.name = name;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rContentimg = rContentimg;
		this.rDate = rDate;
		this.rHit = rHit;
		this.rGroup = rGroup;
		this.rStep = rStep;
		this.rIndent = rIndent;
	}

	int rNum;
	int rId;
	String id;
	String name;
	String rTitle;
	String rContent;
	String rContentimg;
	Timestamp rDate;
	int rHit;
	int rGroup;
	int rStep;
	int rIndent;
	
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrContentimg() {
		return rContentimg;
	}
	public void setrContentimg(String rContentimg) {
		this.rContentimg = rContentimg;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public int getrHit() {
		return rHit;
	}
	public void setrHit(int rHit) {
		this.rHit = rHit;
	}
	public int getrGroup() {
		return rGroup;
	}
	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}
	public int getrStep() {
		return rStep;
	}
	public void setrStep(int rStep) {
		this.rStep = rStep;
	}
	public int getrIndent() {
		return rIndent;
	}
	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}
	
	
}
