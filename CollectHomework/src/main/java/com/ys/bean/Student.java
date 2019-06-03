package com.ys.bean;

public class Student {

	/*
	 * 将学生封装成一个javabean 字段分别为：班级序号（2位），学号（11位），姓名
	 */

	private String no;
	private String sno;
	private String sname;

	// 构造方法

	public Student(String no, String sno, String sname) {
		super();
		this.no = no;
		this.sno = sno;
		this.sname = sname;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", sno=" + sno + ", sname=" + sname + "]";
	}

}
