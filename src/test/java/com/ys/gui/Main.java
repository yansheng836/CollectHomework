package com.ys.gui;

import java.util.ArrayList;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.FileUtil;
import com.ys.util.FindStudentUtil;

/**
 * 直接在控制台输出结果。
 * 
 * @author yansheng
 * @date 2019/06/19
 */
public class Main {

	public static void main(String[] args) {
		String excelPath = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student>[] studentsArray = ExcelUtil.readExcel(excelPath);

		ArrayList<Student> students = studentsArray[0];
		
		// 遍历进行验证
		System.out.println("在TestFindStudentUtil中遍历：");
		for (Student student : students) {
			System.out.println(student);
		}

		// 文件夹路径
		String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3-Linux第一次作业";
		ArrayList<String> fileList = FileUtil.readDir(dirPath);

		// 先比较学生列表数量和文件夹内文件数量
        int classNum = students.size();
        int fileNum = fileList.size();
        String compareResult = null;
        if (classNum == fileNum) {
            compareResult = "文件数量和学生列表数量一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        } else {
            compareResult = "文件数量和学生列表数量不一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        }
        System.out.println("compareResult:" + compareResult);
        

		// 测试“比较比较班级学生人数和文件夹内的文件数目”的方法
		String sign = "sno";
		ArrayList<Student> studentFindList = FindStudentUtil.findStu(students, fileList, sign);
		ArrayList<Student> noFoundStuList = FindStudentUtil.removeList(students, studentFindList);

		System.out.println("\n在TestFindStudentUtil中遍历已交作业的学生：" + studentFindList.size());
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		System.out.println("\n在TestFindStudentUtil中遍历未交作业的学生：" + noFoundStuList.size());
		for (Student student : noFoundStuList) {
			System.out.println(student);
		}

	}

}
