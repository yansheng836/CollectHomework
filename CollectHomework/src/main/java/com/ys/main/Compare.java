package com.ys.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.PathUtil;

public class Compare {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// 比较excel中的数据和路径名
		String excelPath = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		String path = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\多媒体";
		ArrayList<String> pathList = PathUtil.raversalPath(path);
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
