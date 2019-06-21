package com.ys.bean;

/**
 * <p>Title: Student</p>
 * <p>Description: 定义一个javabean，保存学生信息，字段分别为：班级序号（2位），学号（11位），姓名</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-03 20:43:30
 * @version v1.0 
 */
public class Student {

	/**  
	 * @Fields no : 班级序号（2位）
	 */  
	private String no;
	/**  
	 * @Fields sno : 学号（11位）
	 */  
	private String sno;
	/**  
	 * @Fields sname : 姓名
	 */  
	private String sname;

	/**
	 * @Title Student
	 * @Description 构造方法
	 * @param no
	 * @param sno
	 * @param sname
	 */
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
