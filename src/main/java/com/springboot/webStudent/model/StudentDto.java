package com.springboot.webStudent.model;

public class StudentDto {
	private int sid;
	private String sname;
	private int sage;
	private String sdept;
	
	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", sdept=" + sdept + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}

}
