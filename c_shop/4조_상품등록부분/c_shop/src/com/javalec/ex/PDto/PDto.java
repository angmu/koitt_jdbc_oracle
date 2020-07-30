package com.javalec.ex.PDto;

import java.sql.Timestamp;

public class PDto {

	
	public PDto() {
		
	}
	
	
	
	public PDto(int pId, String pCategory, String pName, int pPrice, int pDelivery, String pTitleimg,
			String pContentimg1, String pContentimg2, int pAmount, int pTime, Timestamp pDate,String pContent) {
		
		this.pId = pId; //상품번호
		this.pCategory = pCategory; //상품 카테고리
		this.pName = pName; //상품이름
		this.pPrice = pPrice; //상품가격
		this.pDelivery = pDelivery; //배송비
		this.pTitleimg = pTitleimg; //썸네일 이미지
		this.pContentimg1 = pContentimg1; //내용이미지1
		this.pContentimg2 = pContentimg2; //내용이미지2
		this.pAmount = pAmount; //몇인분
		this.pTime = pTime; //조리시간
		this.pDate = pDate; //상품등록일
		this.pContent=pContent; //상품설명
	}

	int pId;
	String pCategory;
	String pName;
	int pPrice;
	int pDelivery;
	String pTitleimg;
	String pContentimg1;
	String pContentimg2;
	int pAmount;
	int pTime;
	Timestamp pDate;
	String pContent;
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	
	public int getpDelivery() {
		return pDelivery;
	}
	public void setpDelivery(int pDelivery) {
		this.pDelivery = pDelivery;
	}
	
	
	public String getpTitleimg() {
		return pTitleimg;
	}
	public void setpTitleimg(String pTitleimg) {
		this.pTitleimg = pTitleimg;
	}
	
	
	public String getpContentimg1() {
		return pContentimg1;
	}
	public void setpContentimg1(String pContentimg1) {
		this.pContentimg1 = pContentimg1;
	}
	
	
	public String getpContentimg2() {
		return pContentimg2;
	}
	public void setpContentimg2(String pContentimg2) {
		this.pContentimg2 = pContentimg2;
	}
	
	
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	
	
	public int getpTime() {
		return pTime;
	}
	public void setpTime(int pTime) {
		this.pTime = pTime;
	}
	
	
	public Timestamp getpDate() {
		return pDate;
	}
	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}
	
	
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	
	
	
	
}//class
