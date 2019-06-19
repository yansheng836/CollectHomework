package com.ys.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.PathUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-19 14:07:42
 * @version v1.0 
 */
public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

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
		//String path = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计算机3班-嵌入式实验报告";
		
		ArrayList<String> pathList = PathUtil.raversalPath(path);
//		for (String string : pathList) {
//			System.out.println(string);
//		}

		// 比较学号
		ArrayList<Student> studentFindList = new ArrayList<Student>();
		for (Student student : students) {
			String sno = student.getSno();
			for (String path1 : pathList) {
				if (sno.compareTo(path1) == 0) { // 匹配成功返回0
					// System.out.println("\n匹配成功，学生信息为：");
					// System.out.println(student);
					studentFindList.add(student);
				}

			}

		}

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
