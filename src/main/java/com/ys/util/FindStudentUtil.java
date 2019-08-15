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
import java.util.LinkedHashSet;

import com.ys.bean.Student;

/**
 * <p>Title: </p>
 * <p>Description: 定义和查找学生相关的方法。</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-21 00:48:30
 * @version v1.0 
 */
public class FindStudentUtil {

	/**
	 * @Title findBySname
	 * @author yansheng
	 * @version v3.0
	 * @date 2019-06-22 17:30:15
	 * @Description 通过（文件名与点名册中的）姓名对比，查找已交作业的学生集合。
	 * @param students 点名册中的学生集合
	 * @param fileList 文件路径名集合
	 * @param sign 用于判断是按姓名进行检索和按学号进行检索的标志
	 * @return   
	 *ArrayList<Student> 已找到的学生列表
	 */
	public static ArrayList<Student> findStu(ArrayList<Student> students,
			ArrayList<String> fileList, String sign) {

		// 1. 定义一个已找到的学生列表
		int size = students.size();
		// 用set去重
		LinkedHashSet<Student> foundStuSet = new LinkedHashSet<Student>(size);

		String path = null;
		Student student = null;
		String sno = null;
		String sname = null;

		// 2.判断是“按姓名进行检索”还是“按学号进行检索”.
		String snoSign = "sno";
		String snameSign = "sname";
		if (snoSign.equalsIgnoreCase(sign)) {
			for (int i = 0, fileSize = fileList.size(); i < fileSize; i++) {
				path = fileList.get(i);
				for (int j = 0, studentSize = students.size(); j < studentSize; j++) {
					student = students.get(j);
					sno = student.getSno();
					if (path.contains(sno)) {
//						System.out.println("匹配成功，学生信息为：" + student.toString());
						if (foundStuSet.add(student) == false) {
							System.err.println("存在重复数据，学生信息为：" + student.toString());
						}
					}
				}
			}
		} else if (snameSign.equalsIgnoreCase(sign)) {
			for (int i = 0, fileSize = fileList.size(); i < fileSize; i++) {
				path = fileList.get(i);
				for (int j = 0, studentSize = students.size(); j < studentSize; j++) {
					student = students.get(j);
					sname = student.getSname();
					if (path.contains(sname)) {
//						System.out.println("匹配成功，学生信息为：" + student.toString());
						if (foundStuSet.add(student) == false) {
							System.err.println("存在重复数据，学生信息为：" + student.toString());
						}
					}
				}
			}
		} else {
			System.err.println("识别标志：" + sign + " 错误，应该为sno或者sname");
		}
		ArrayList<Student> foundStuList = new ArrayList<Student>(foundStuSet);

		return foundStuList;
	}

	// 为了方便理解，定义一个学生列表，存放未找到的学生（其实如果找到就移除的话，剩下的学生列表就是未找到的学生列表）
	/**
	 * @Title removeList
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-08-15 20:31:40
	 * @Description 从list1中移除list2,已得到未找到的学生列表
	 * @param students 班级学生列表
	 * @param foundStuList 已找到的学生列表
	 * @return   
	 * ArrayList<Student> 未找到的学生列表
	 */
	public static ArrayList<Student> removeList(ArrayList<Student> students,
			ArrayList<Student> foundStuList) {
		ArrayList<Student> students1 = (ArrayList<Student>) students.clone();
		boolean bool = students1.removeAll(foundStuList);
//		if (bool) {
//			System.out.println("students1.removeAll(foundStuList)成功");
//		} else {
//			System.err.println("students1.removeAll(foundStuList)失败");
//		}

		return students1;
	}

	/**
	 * @Title compareNumber
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-22 22:28:53
	 * @Description 比较班级学生人数和文件夹内的文件数目是否一致
	 * @param students 班级人数
	 * @param fileList 文件数量（已交作业数量）
	 * @return   
	 * String[] 字符串数组（字符串，学生数量，文件数量）
	 */
	public static String[] compareNumber(ArrayList<Student> students, ArrayList<String> fileList) {

		Integer classNum = students.size();
		Integer fileNum = fileList.size();
		// System.out.println("stuLen:"+stuLen);
		// System.out.println("fileLen:"+fileLen);

		String string = null;
		if (classNum.equals(fileNum)) {
			string = "文件数量和学生列表数量一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
		} else {
			string = "文件数量和学生列表数量不一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
		}

		String[] compareResults = { string, classNum.toString(), fileNum.toString() };

		return compareResults;

	}

	/**
	 * @Title findBySname
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 01:02:44
	 * @Description 通过（文件名与点名册中的）姓名对比，查找已交作业的学生集合
	 * @param students 点名册中的学生集合
	 * @param fileList 文件路径名集合
	 * @return   
	 * ArrayList<Student> 找到的学生列表
	 * @deprecated 之前用foreach遍历，但是不能在遍历时进行list的修改（会抛出ConcurrentModificationException异常）;
	 * 		但是为了效率，加快查找速度，需要在查找到后，删除该数据，方便下次查找。因此改用Iterator进行遍历，故废弃该方法。
	 */
	public static ArrayList<Student> findBySname0(ArrayList<Student> students,
			ArrayList<String> fileList) {
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
