/**  
 * @Title FindUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-20 00:58:05
 * @version v1.0
 */
package com.ys.util;

import java.util.ArrayList;

import com.ys.bean.Student;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-20 00:58:05
 * @version v1.0 
 */
public class FindUtil {

	/**
	 * @Title findBySno
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 01:02:44
	 * @Description 通过（文件名与点名册中的）学号对比，查找已交作业的学生集合
	 * @param students 点名册中的学生集合
	 * @param pathList 文件路径名集合
	 * @return   
	 * ArrayList<Student> 找到的学生列表
	 */
	public static ArrayList<Student> findBySno(ArrayList<Student> students, ArrayList<String> pathList) {
		// 比较学号
		ArrayList<Student> studentFindList = new ArrayList<Student>();
		for (Student student : students) {
			// 取得学号信息
			String sno = student.getSno();
			for (String path1 : pathList) {
				 // 匹配成功返回0
				if (sno.compareTo(path1) == 0) {
					// System.out.println("\n匹配成功，学生信息为：");
					// System.out.println(student);
					studentFindList.add(student);
				}

			}

		}
		return studentFindList;
	}

	/**
	 * @Title findBySname
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 01:02:44
	 * @Description 通过（文件名与点名册中的）姓名对比，查找已交作业的学生集合
	 * @param students 点名册中的学生集合
	 * @param pathList 文件路径名集合
	 * @return   
	 * ArrayList<Student> 找到的学生列表
	 * @deprecated 
	 */
	public static ArrayList<Student> findBySname0(ArrayList<Student> students, ArrayList<String> pathList) {
		// 比较姓名
		ArrayList<Student> studentFindList = new ArrayList<Student>();
		for (String path : pathList) {
			System.out.println("path:" + path);

			for (Student student : students) {
				// 从集合中的学生对象哦中取得姓名
				String sname = student.getSname();
				System.out.println("student:" + student);
				// 查看文件名中是否含有学生姓名
				// 如果含有，将该学生添加到另一个学生列表中
				if (path.contains(sname)) {
					System.out.println("\n匹配成功，学生信息为：");
					System.out.println(student);
					studentFindList.add(student);

					// 找到后从文件列表中删除该文件，跳出改成循环
					pathList.remove(path);
					students.remove(student);

					break;
				} else {
					System.out.println("\n匹配不成功，学生信息为：");
					System.out.println(student);
				}
			}

		}

		return studentFindList;
	}

	

}
