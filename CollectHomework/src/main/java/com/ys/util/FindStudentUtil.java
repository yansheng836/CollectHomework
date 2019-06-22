/**  
 * @Title FindStudentUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-21 00:48:30
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
 * @date 2019-06-21 00:48:30
 * @version v1.0 
 */
public class FindStudentUtil {

	
	
	public static ArrayList<Student> findBySno(ArrayList<Student> students, ArrayList<String> fileList) {
		// 定义一个学生列表，用于存放匹配到的学生
		ArrayList<Student> studentFindList = new ArrayList<Student>();

		// 改进，在遍历时如果找到,移除该元素,减少循环。为防止出现异常，用Iterator遍历，而不用foreach遍历。
		// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
		// /CollectHomework/src/test/java/com/ys/main/TestList1.java

		Iterator<Student> iteratorStu = students.iterator();
		Iterator<String> iteratorPath = fileList.iterator();
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
	

	/**
	 * @Title findBySname
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-22 00:36:35
	 * @Description 通过（文件名与点名册中的）姓名对比，查找已交作业的学生集合。
	 * @param students	点名册中的学生集合
	 * @param pathList	文件路径名集合
	 * @return   
	 * ArrayList<Student> 找到的学生列表
	 * @see  Student /CollectHomework/src/test/java/com/ys/main/TestList1.java
	 */
	// 为了防止代码重复，直接将按姓名进行检索
	public static ArrayList<Student> findBySname(ArrayList<Student> students, ArrayList<String> fileList,String sign) {
		// 定义一个学生列表，用于存放匹配到的学生
		ArrayList<Student> studentFindList = new ArrayList<Student>();

		// 改进，在遍历时如果找到,移除该元素,减少循环。为防止出现异常，用Iterator遍历，而不用foreach遍历。
		// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
		// /CollectHomework/src/test/java/com/ys/main/TestList1.java

		Iterator<Student> iteratorStu = students.iterator();
		Iterator<String> iteratorPath = fileList.iterator();
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
	public static ArrayList<Student> findBySname0(ArrayList<Student> students, ArrayList<String> fileList) {
		// 比较姓名
		ArrayList<Student> studentFindList = new ArrayList<Student>();
		for (String path : fileList) {
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
					fileList.remove(path);
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
