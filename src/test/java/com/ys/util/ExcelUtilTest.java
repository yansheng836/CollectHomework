package com.ys.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import com.ys.bean.Student;

/**
 * @author yansheng
 * @date 2019/09/21
 */
public class ExcelUtilTest {

    private String excelPath = "./测试数据/测试用班级点名册.xls";

    /**
     * Test method for {@link com.ys.util.ExcelUtil#readExcel(java.lang.String)}.
     */
    @Test
    public void testReadExcel() {

        // 测试方法1--读excel表格
        ArrayList<Student>[] studentsArray = ExcelUtil.readExcel(excelPath);

        ArrayList<Student> students = studentsArray[0];
        assertNotNull(students);

        System.out.println("在TestExcelUtil中遍历students：");
        for (Student student : students) {
            System.out.println(student);
        }

        // 测试方法2--写excel表格
        ExcelUtil.writeExcel(excelPath, students);
    }


    /**
     * Test method for {@link com.ys.util.ExcelUtil#getSaveExcelFileName(java.lang.String)}.
     */
    @Test
    public void testGetSaveExcelFileName() {

        String perfix = excelPath.substring(0, excelPath.lastIndexOf("."));
        String excelPath1 = perfix + "--未交作业的学生名单.xls";

        String[] strings1 = {excelPath1};
        String[] strings2 = {ExcelUtil.getSaveExcelFileName(excelPath)};

        assertArrayEquals(strings1, strings2);
    }

}
