/**  
 * @Title TestExcelUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-03 20:32:38
 * @version v1.0
 */
package com.ys.util;

import java.util.ArrayList;

import com.ys.bean.Student;


/**
 * <p>Title: </p>
 * <p>Description: 测试ExcelUtil类的函数功能。</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-03 22:19:26
 * @version v1.0 
 */
public class TestExcelUtil {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-03 20:32:38
	 * @Description 测试ExcelUtil类的函数功能
	 * @param args 主方法参数
	 * @see  ExcelUtil
	 */
	public static void main(String[] args) {

		String excelPath = "16计算机科学与技术3学生名单.xls";
		
		// 测试方法1--读excel表格
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		System.out.println("在TestExcelUtil中遍历students：");
		for (Student student : students) {
			System.out.println(student);
		}
		
		// 测试方法2--写excel表格
		ExcelUtil.writeExcel(excelPath, students);

	}

}
