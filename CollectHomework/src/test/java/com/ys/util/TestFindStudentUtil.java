/**  
 * @Title TestFindStudentUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-21 00:49:49
 * @version v1.0
 */
package com.ys.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ys.bean.Student;

/**
 * <p>Title: </p>
 * <p>Description: 测试FindStudentUtil的方法</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-21 00:49:49
 * @version v1.0 
 */
public class TestFindStudentUtil {

	/**
	 * @throws FileNotFoundException 
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-21 00:49:49
	 * @Description TODO
	 * @param args   
	 * @return void 
	 * @see  
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String excelPath = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		// 文件夹路径
		String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";
		ArrayList<String> fileList = FileUtil.readDir(dirPath);
		
		// 测试“比较比较班级学生人数和文件夹内的文件数目”的方法
		String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
		String result = compareResults[0];
		int stuNum = Integer.parseInt(compareResults[1]);
		int fileNum = Integer.parseInt(compareResults[2]);
				
		System.out.println("result:"+result);
		System.out.println("stuNum:"+stuNum);
		System.out.println("fileNum:"+fileNum);
		
		
		// 测试“比较比较班级学生人数和文件夹内的文件数目”的方法
		String sign = "sno";
		ArrayList<ArrayList<Student>> arrayStuList = FindStudentUtil.findStu(students, fileList, sign);
		ArrayList<Student> studentFindList = arrayStuList.get(0);
		ArrayList<Student> noFoundStuList = arrayStuList.get(1);
		System.out.println("\n在TestFindStudentUtil中遍历已交作业的学生：");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		System.out.println("\n遍历未交作业的学生：");
		for (Student student : noFoundStuList) {
			System.out.println(student);
		}

		

	}

}
