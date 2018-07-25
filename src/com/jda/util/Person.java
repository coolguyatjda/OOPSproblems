package com.jda.util;

public class Person {
	private String Name;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long p_no;
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.Name;
	}
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}
	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}
	public int getZip() {
		// TODO Auto-generated method stub
		return this.zip;
	}
	public long getpno() {
		// TODO Auto-generated method stub
		return this.p_no;
	}
	public void setName(String Name) {
		// TODO Auto-generated method stub
		this.Name = Name;
	}
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;
	}
	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;
	}
	public void setState(String state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	public void setZip(int zip) {
		// TODO Auto-generated method stub
		this.zip = zip;
	}
	public void setpno(long p_no) {
		// TODO Auto-generated method stub
		this.p_no = p_no;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.getName() + ", " + this.getAddress() + ", " + this.getCity() + ", " + this.getState() + ", " + this.getZip() + ", " + this.getpno();
		return str;
	}
}
