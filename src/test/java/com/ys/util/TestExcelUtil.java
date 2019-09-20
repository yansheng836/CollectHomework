package com.ys.util;

import java.util.ArrayList;

import com.ys.bean.Student;

/**
 * 测试ExcelUtil类的函数功能。
 * 
 * @author yansheng
 * @date 2019/06/03
 */
public class TestExcelUtil {

    public static void main(String[] args) {

        String excelPath = "16计算机科学与技术3学生名单.xls";

        // 测试方法1--读excel表格
        ArrayList<Student>[] studentsArray = ExcelUtil.readExcel(excelPath);

        ArrayList<Student> students = studentsArray[0];

        System.out.println("在TestExcelUtil中遍历students：");
        for (Student student : students) {
            System.out.println(student);
        }

        // 测试方法2--写excel表格
        ExcelUtil.writeExcel(excelPath, students);

    }

}
