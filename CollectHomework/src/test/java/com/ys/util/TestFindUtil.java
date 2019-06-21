/**  
 * @Title TestFindUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-20 01:32:24
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
 * @date 2019-06-20 01:32:24
 * @version v1.0 
 */
public class TestFindUtil {

	/**
	 * @throws FileNotFoundException 
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 01:32:24
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
		String path = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";

		ArrayList<String> pathList = PathUtil.raversalPath(path);

		// 比较姓名
		ArrayList<Student> studentFindList = FindUtil.findBySname1(students, pathList);
		
		// 
		System.out.println("\n匹配成功的学生有"+studentFindList.size()+"人，具体信息如下：");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

	}

}
