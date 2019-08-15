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
		// String excelPath = "./测试用班级点名册.xls";
		String excelPath = "./16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		System.out.println("\nMain:现有班级学生人数：" + students.size() + ",遍历:");
		for (Student student : students) {
			System.out.println(student);
		}

		// 文件夹路径
		// String dirPath = "./测试用文件夹--已收作业";
		// String dirPath = "F:\\Google\\downloads\\新建文件夹";
		String dirPath = "F:\\Google\\downloads\\新建PDF";
		ArrayList<String> fileList = FileUtil.readDir(dirPath);

		String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
		String result = compareResults[0];
		int stuNum = Integer.parseInt(compareResults[1]);
		int fileNum = Integer.parseInt(compareResults[2]);

		System.out.println("result:" + result);
		System.out.println("stuNum:" + stuNum);
		System.out.println("fileNum:" + fileNum);

		// String sign = "sno";
		String sign = "sname";
		ArrayList<ArrayList<Student>> arrayStuList = FindStudentUtil.findStu(students, fileList, sign);
		ArrayList<Student> studentFindList = arrayStuList.get(0);
		ArrayList<Student> noFoundStuList = arrayStuList.get(1);
		System.out.println("\nMain:已交作业的学生人数：" + studentFindList.size() + ",遍历:");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		System.out.println("\n未交作业的学生人数：" + noFoundStuList.size() + ",遍历:");
		for (Student student : noFoundStuList) {
			System.out.println(student);
		}

		ExcelUtil.writeExcel(excelPath, students);

	}

}
