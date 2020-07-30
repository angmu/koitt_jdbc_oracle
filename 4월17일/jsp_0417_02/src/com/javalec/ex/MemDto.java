package com.javalec.ex;

import java.sql.Timestamp;

public class MemDto {
	public MemDto() {}
	public MemDto(int m_num,String m_id,String pw,String m_name,String email,String address,String phone,Timestamp birth,String gender,String news,String sms,Timestamp m_date){
		this.m_num=m_num;
		this.m_id=m_id;
		this.pw=pw;
		this.m_name=m_name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.birth=birth;
		this.gender=gender;
		this.news=news;
		this.sms=sms;
		this.m_date=m_date;
		
	}
	private int m_num;
	private String m_id;
	private String pw;
	private String m_name;
	private String email;
	private String address;
	private String phone;
	private Timestamp birth;
	private String gender;
	private String news;
	private String sms;
	private Timestamp m_date;
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getBirth() {
		return birth;
	}
	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public Timestamp getM_date() {
		return m_date;
	}
	public void setM_date(Timestamp m_date) {
		this.m_date = m_date;
	}
	
	
	
}
