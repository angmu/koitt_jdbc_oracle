package com.javalec.ex.MDto;

import java.sql.Date;
import java.sql.Timestamp;

public class MDto {
	
	public MDto () {
		
	}

	public MDto(String id, String pw, String name, String gender, String email_head, String email_tail, String address,
			String phone_head, String phone_mid, String phone_tail, String news, String sms, Date birth,
			Timestamp j_date, Timestamp u_date) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.email_head = email_head;
		this.email_tail = email_tail;
		this.address = address;
		this.phone_head = phone_head;
		this.phone_mid = phone_mid;
		this.phone_tail = phone_tail;
		this.news = news;
		this.sms = sms;
		this.birth = birth;
		this.j_date = j_date;
		this.u_date = u_date;
	}

	String id,pw,name,gender,email_head,email_tail,address,phone_head,phone_mid,phone_tail,news,sms;
	Date birth;
	Timestamp j_date,u_date;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_head() {
		return email_head;
	}
	public void setEmail_head(String email_head) {
		this.email_head = email_head;
	}
	public String getEmail_tail() {
		return email_tail;
	}
	public void setEmail_tail(String email_tail) {
		this.email_tail = email_tail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_head() {
		return phone_head;
	}
	public void setPhone_head(String phone_head) {
		this.phone_head = phone_head;
	}
	public String getPhone_mid() {
		return phone_mid;
	}
	public void setPhone_mid(String phone_mid) {
		this.phone_mid = phone_mid;
	}
	public String getPhone_tail() {
		return phone_tail;
	}
	public void setPhone_tail(String phone_tail) {
		this.phone_tail = phone_tail;
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Timestamp getJ_date() {
		return j_date;
	}
	public void setJ_date(Timestamp j_date) {
		this.j_date = j_date;
	}
	public Timestamp getU_date() {
		return u_date;
	}
	public void setU_date(Timestamp u_date) {
		this.u_date = u_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
