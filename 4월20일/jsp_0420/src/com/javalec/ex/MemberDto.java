package com.javalec.ex;

import java.sql.Timestamp;

public class MemberDto {
	public MemberDto() {}
	public MemberDto(String id,String pw,String name,String email,String address,Timestamp d_date) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.email=email;
		this.address=address;
		this.d_date=d_date;
	}
	String id,pw,name,email,address;
	Timestamp d_date;
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
	public Timestamp getD_date() {
		return d_date;
	}
	public void setD_date(Timestamp d_date) {
		this.d_date = d_date;
	}
	
	
}
