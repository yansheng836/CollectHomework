package com.ys.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.ys.bean.Student;

/**
 * 查找学生的工具类。
 * 
 * @author yansheng
 * @date 2019/06/21
 */
public class FindStudentUtil {

    /**
     * 通过（文件名与点名册中的）姓名对比，查找已交作业的学生集合。
     * 
     * @param students
     *            点名册中的学生集合
     * @param fileList
     *            文件路径名集合
     * @param sign
     *            用于判断是按姓名进行检索和按学号进行检索的标志
     * @return ArrayList<Student> 已找到的学生列表
     */
    public static ArrayList<Student> findStu(ArrayList<Student> students, ArrayList<String> fileList, String sign) {

        // 1. 定义一个已找到的学生列表
        int size = students.size();
        // 用set去重
        LinkedHashSet<Student> foundStuSet = new LinkedHashSet<Student>(size);

        String path = null;
        Student student = null;
        String sno = null;
        String sname = null;

        // 2.判断是“按姓名进行检索”还是“按学号进行检索”.
        String snoSign = "sno";
        String snameSign = "sname";
        int fileSize = 0;
        int studentSize = 0;
        if (snoSign.equalsIgnoreCase(sign)) {
            fileSize = fileList.size();
            for (int i = 0; i < fileSize; i++) {
                path = fileList.get(i);
                studentSize = students.size();
                for (int j = 0; j < studentSize; j++) {
                    student = students.get(j);
                    sno = student.getSno();
                    // 如果路径名中包含学号，将该学生添加到学生集合（set）中；如果重复会添加失败，在控制台打印错误信息。
                    if (path.contains(sno)) {
                        if (!foundStuSet.add(student)) {
                            System.err.println("存在重复数据，学生信息为：" + student.toString());
                        }
                    }
                }
            }
        } else if (snameSign.equalsIgnoreCase(sign)) {
            fileSize = fileList.size();
            for (int i = 0; i < fileSize; i++) {
                path = fileList.get(i);
                studentSize = students.size();
                for (int j = 0; j < studentSize; j++) {
                    student = students.get(j);
                    sname = student.getSname();
                    if (path.contains(sname)) {
                        if (!foundStuSet.add(student)) {
                            System.err.println("存在重复数据，学生信息为：" + student.toString());
                        }
                    }
                }
            }
        } else {
            System.err.println("识别标志：" + sign + " 错误，可用标志为：sno或者sname");
        }
        ArrayList<Student> foundStuList = new ArrayList<Student>(foundStuSet);

        return foundStuList;
    }

    /**
     * 为了方便理解，定义一个学生列表，存放未找到的学生（其实如果找到就移除的话，剩下的学生列表就是未找到的学生列表）；从list1中移除list2,已得到未找到的学生列表
     * 
     * @param students
     *            班级学生列表
     * @param foundStuList
     *            已找到的学生列表
     * @return ArrayList<Student> 未找到的学生列表
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> removeList(ArrayList<Student> students, ArrayList<Student> foundStuList) {
        ArrayList<Student> students1 = (ArrayList<Student>)students.clone();
        students1.removeAll(foundStuList);

        return students1;
    }

    /**
     * @Title compareNumber
     * @author yansheng
     * @version v1.0
     * @date 2019-06-22 22:28:53
     * @Description 比较班级学生人数和文件夹内的文件数目是否一致
     * @param students
     *            班级人数
     * @param fileList
     *            文件数量（已交作业数量）
     * @return String[] 字符串数组（字符串，学生数量，文件数量）
     */
    public static String[] compareNumber(ArrayList<Student> students, ArrayList<String> fileList) {

        Integer classNum = students.size();
        Integer fileNum = fileList.size();

        String string = null;
        if (classNum.equals(fileNum)) {
            string = "文件数量和学生列表数量一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        } else {
            string = "文件数量和学生列表数量不一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        }

        String[] compareResults = {string, classNum.toString(), fileNum.toString()};

        return compareResults;

    }

}
