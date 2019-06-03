package com.ys.main;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.ys.bean.Student;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 比较excel中的数据和路径名
		String excelPath = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ReadExcel.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		String path = "G:\\Workspaces\\eclipse最新英文版\\HomeWork";
		ArrayList<String> pathList = TraversalPath.raversalPath(path);
		// 遍历进行验证
		// System.out.println("\n" + path + "有文件：");
		// for (String path1 : pathList) {
		// System.out.println(path1);
		// System.out.println(path1.length());
		// }

		// 比较学号
		for (Student student : students) {
			String sno = student.getSno();
			for (String path1 : pathList) {
				if (sno.compareTo(path1) == 0) { // 匹配成功返回0
					System.out.println("\n匹配成功，学生信息为：");
					System.out.println(student);
				}
			}

		}

		// 比较姓名
		for (Student student : students) {
			String sname = student.getSname();
			//System.out.println(sname);
			
			for (String path1 : pathList) {
				if (Pattern.matches("颜升1", sname)) {
					System.out.println(sname+" 匹配成功");
				}
				
//				if (sname.compareTo(path1) == 0) { // 匹配成功返回0
//					System.out.println("\n匹配成功，学生信息为：");
//					System.out.println(student);
//				}
			}

		}

	}

}
