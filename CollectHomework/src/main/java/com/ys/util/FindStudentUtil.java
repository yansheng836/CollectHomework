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
	// 改进，在遍历时，如果找到移除该元素
	// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
	/*
	 * 
	 */

	public static ArrayList<Student> findBySname1(ArrayList<Student> students, ArrayList<String> pathList) {
		// 比较姓名
		ArrayList<Student> studentFindList = new ArrayList<Student>();

		// 参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
		// ArrayList<Integer> list = new ArrayList<Integer>();
		// list.add(2);
		// Iterator<Integer> iterator = list.iterator();
		// while (iterator.hasNext()) {
		// Integer integer = iterator.next();
		// if (integer == 2)
		// iterator.remove(); // 注意这个地方
		// }

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
