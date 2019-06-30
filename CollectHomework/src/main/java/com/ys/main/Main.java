package com.ys.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.FileUtil;
import com.ys.util.FindStudentUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-19 14:07:33
 * @version v1.0 
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String excelPath = "./测试用班级点名册.xls";
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		// 文件夹路径
		String dirPath = "./测试用文件夹--已收作业";
		ArrayList<String> fileList = FileUtil.readDir(dirPath);
		
		String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
		String result = compareResults[0];
		int stuNum = Integer.parseInt(compareResults[1]);
		int fileNum = Integer.parseInt(compareResults[2]);
				
		System.out.println("result:"+result);
		System.out.println("stuNum:"+stuNum);
		System.out.println("fileNum:"+fileNum);
		
		
		String sign = "sno";
		ArrayList<ArrayList<Student>> arrayStuList = FindStudentUtil.findStu(students, fileList, sign);
		ArrayList<Student> studentFindList = arrayStuList.get(0);
		ArrayList<Student> noFoundStuList = arrayStuList.get(1);
		System.out.println("\n在Main中遍历已交作业的学生：");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		System.out.println("\n遍历未交作业的学生：");
		for (Student student : noFoundStuList) {
			System.out.println(student);
		}
		
		ExcelUtil.writeExcel(excelPath, students);

	}

}
