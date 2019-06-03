package com.ys.main;

import java.util.ArrayList;

import com.ys.bean.Student;

public class FindStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "16计算机科学与技术3学生名单.xls";
		ArrayList<Student> students = ReadExcel.readExcel(path);
		for (Student student : students) {
			System.out.println(student);
		}
		
		
		

	}

}
