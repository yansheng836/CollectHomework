/**  
 * @Title TestMainNew.java
 * @Package com.ys.main
 * @Description TODO
 * @author yansheng
 * @date 2019-06-20 01:27:06
 * @version v1.0
 */
package com.ys.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.FindUtil;
import com.ys.util.PathUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-20 01:27:06
 * @version v1.0 
 */
public class TestMainNew {

	/**
	 * @throws FileNotFoundException 
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 01:27:06
	 * @Description TODO
	 * @param args   
	 * void 
	 * @see  
	 * @exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// excel路径
		// String excelPath = "16计算机科学与技术3学生名单.xls";
		String excelPath = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		// 文件夹路径
		String path = "F:\\Google\\downloads\\实验报告\\安卓\\16计科3班移动开发实验三";

		ArrayList<String> pathList = PathUtil.raversalPath(path);
		// for (String string : pathList) {
		// System.out.println(string);
		// }

		// 比较姓名
		ArrayList<Student> studentFindList = FindUtil.findBySname(students, pathList);
		

		System.out.println("\n--遍历--已找到学生列表：");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		// 移除找到的学生
		students.removeAll(studentFindList);

		System.out.println("\n遍历--没找到学生列表：");
		System.out.println("一共有：" + students.size() + "人");

		for (Student student : students) {
			System.out.println(student);
		}

		ExcelUtil.writeExcel(students);
	}

}
