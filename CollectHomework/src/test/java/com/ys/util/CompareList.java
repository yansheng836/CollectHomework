/**  
 * @Title CompareList.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-06 00:04:00
 * @version v1.0
 */
package com.ys.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ys.bean.Student;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-06 00:04:00
 * @version v1.0 
 */
public class CompareList {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-06 00:04:00
	 * @Description 比较从点名册中取得的列表和指定目录的文件数量是否相同,对结果给出对应的提示
	 * @param args   
	 * void 
	 * @see  
	 * @exception
	 */
	public static void main(String[] args) {

		String path = "16计算机科学与技术3学生名单.xls";
		// 测试方法1--读excel表格
		ArrayList<Student> students = ExcelUtil.readExcel(path);
		// for (Student student : students) {
		// System.out.println(student);
		// }
		int stuNum = students.size();
		System.out.println("stuNum:" + stuNum);

		
		// 1.测试PathUtil.raversalPath(path)
		String pathDir = "F:\\Google\\downloads\\实验报告\\多媒体实验\\16计科3班多媒体实验一";
		ArrayList<String> pathList = null;
		try {
			pathList = PathUtil.raversalPath(pathDir);
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		int fileNum = pathList.size();
		
		System.out.println("fileNum:" + fileNum);

	}

}
