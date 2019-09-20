package com.ys.bean;

/**
 * 学生实体类，保存学生信息，属性分别为：班级序号（2位），学号，姓名。
 * 
 * @author yansheng
 * @date 2019/06/03
 */
public class Student {

    /**
     * @Fields no : 班级序号（班级排位号，随机的，不是按照成绩排的）
     */
    private String no;
    /**
     * @Fields sno : 学号
     */
    private String sno;
    /**
     * @Fields sname : 姓名
     */
    private String sname;

    /**
     * 构造方法
     * 
     * @param no
     *            班级序号
     * @param sno
     *            学号
     * @param sname
     *            姓名
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

    /**
     * 打印学生信息
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [no=" + no + ", sno=" + sno + ", sname=" + sname + "]";
    }

}
