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
	// 为了减少代码的重复率，直接将按姓名进行检索和按学号进行检索合并在一个方法里面。
	/**
	 * @Title findBySname
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-22 17:30:15
	 * @Description TODO
	 * @param students
	 * @param fileList
	 * @param sign
	 * @return   
	 * ArrayList<ArrayList<Student>> 一个包含ArrayList<Student>对象的列表，第一个值为已找到的学生列表，第二个值为未找到的学生列表
	 * @see  
	 * @exception
	 */
	public static ArrayList<ArrayList<Student>> findBySname(ArrayList<Student> students,
			ArrayList<String> fileList, String sign) {
		// 1.先判断是“按姓名进行检索和按学号进行检索”？
		// 定义一个布尔变量，如果是true表示为sno,false为sname
		String snoSign = "sno";
		String snameSign = "sname";
		boolean bool = false;

		if (snoSign.equalsIgnoreCase(sign)) {
			bool = true;
		} else if (snameSign.equalsIgnoreCase(sign)) {
			bool = false;
		}
		System.out.println("bool的值为：" + bool);

		// 2.

		// 2.定义一个学生列表，用于存放匹配到的学生
		ArrayList<ArrayList<Student>> arrayStuList = new ArrayList<ArrayList<Student>>();

		ArrayList<Student> foundStuList = new ArrayList<Student>();
		ArrayList<Student> noFoundStuList = new ArrayList<Student>();

		// 改进，在遍历时如果找到,移除该元素,减少循环。为防止出现异常，用Iterator遍历，而不用foreach遍历。
		// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
		// /CollectHomework/src/test/java/com/ys/main/TestList1.java

		Iterator<Student> iterStu = students.iterator();
		Iterator<String> iterPath = fileList.iterator();
		String path;
		Student student;
		String judgeSign;
		while (iterPath.hasNext()) {
			path = iterPath.next();
			// System.out.println("\n----path:" + path);

			while (iterStu.hasNext()) {
				student = iterStu.next();
				// System.out.println("----student:" + student);

				// 如果bool为真，则取学生的学号（进行检索）；否则，取学生的姓名（进行检索）。
				if (bool) {
					judgeSign = student.getSno();
				} else {
					judgeSign = student.getSname();
				}

				if (path.contains(judgeSign)) {
					// System.out.println("匹配成功，学生信息为：");
					// System.out.println(student);
					foundStuList.add(student);

					// 找到后从文件列表和学生列表中移除该项，跳出改成循环
					iterPath.remove();
					iterStu.remove();

					break;
				} else {
					// System.out.println("匹配不成功，学生信息为：");
					// System.out.println(student);
				}
			}
		}

		// 将已找到学生列表和未找到学生列表添加到arrayStuList列表中。
		arrayStuList.add(foundStuList);
		arrayStuList.add(students);

		System.out.println("\n最后进行遍历：");
		for (Student student1 : students) {
			System.out.println(student1);
		}
		for (String student1 : fileList) {
			System.out.println(student1);
		}

		System.out.println("遍历：ArrayList<ArrayList<Student>> arrayList");
		for (ArrayList<Student> object : arrayStuList) {
			System.out.println(object);
		}

		return arrayStuList;
	}

	public static String compareNumber(ArrayList<Student> students, ArrayList<String> fileList) {
		
		int stuLen = students.size();
		int fileLen = fileList.size();
		System.out.println("stuLen:"+stuLen);
		System.out.println("fileLen:"+fileLen);
		
		String string = null ;
		if (stuLen == fileLen) {
			string = "文件数量和学生列表数量一致！\n"+"学生列表有"+stuLen+"个学生，文件列表有"+fileLen+"个文件。";
		} else {
			string = "文件数量和学生列表数量不一致！\n"+"学生列表有"+stuLen+"个学生，文件列表有"+fileLen+"个文件。";
		}

		return string;

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
	 * @deprecated 之前用foreach遍历，但是不能在遍历时进行list的修改（会抛出ConcurrentModificationException异常）;
	 * 		但是为了效率，加快查找速度，需要在查找到后，删除该数据，方便下次查找。因此改用Iterator进行遍历，故废弃该方法。
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
