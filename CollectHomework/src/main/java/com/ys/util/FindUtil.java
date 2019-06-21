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
import java.util.Iterator;

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
	 */
	public static ArrayList<Student> findBySname(ArrayList<Student> students, ArrayList<String> pathList) {
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

		// 测试
		// String path;
		// Student student;
		// for (int i = 0, len = pathList.size(); i < len; i++) {
		// path = pathList.get(0);
		// System.out.println("path:"+path);
		//
		// student = students.get(0);
		// System.out.println("student:"+student);
		//
		// }

		return studentFindList;
	}

	// 改进，在遍历时，如果找到移除该元素
	// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
	/*
	 * 
	 */
	
	public static ArrayList<Student> findBySname1(ArrayList<Student> students, ArrayList<String> pathList) {
		// 比较姓名
		ArrayList<Student> studentFindList = new ArrayList<Student>();

		// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		Iterator<Integer> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Integer integer = iterator.next();
//			if (integer == 2)
//				iterator.remove();   // 注意这个地方
//		}

		
		Iterator<Student> iteratorStu = students.iterator();
		Iterator<String> iteratorPath = pathList.iterator();
		String path;
		Student student;
		String sname;
		while (iteratorPath.hasNext()) {
			path = iteratorPath.next();
			System.out.println("\n----path:" + path);

			while (iteratorStu.hasNext()) {
				student = iteratorStu.next();
				sname = student.getSname();
				System.out.println("----student:" + student);
				if (path.contains(sname)) {
					System.out.println("匹配成功，学生信息为：");
					System.out.println(student);
					studentFindList.add(student);

					// 找到后从文件列表中删除该文件，跳出改成循环
					iteratorPath.remove();
					iteratorStu.remove();

					break;
				} else {
					System.out.println("匹配不成功，学生信息为：");
					System.out.println(student);
				}
			}

		}

		return studentFindList;
	}

}
