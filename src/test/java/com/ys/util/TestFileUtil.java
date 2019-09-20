package com.ys.util;

import java.util.ArrayList;

/**
 * 测试FileUtil类的方法。
 * 
 * @author yansheng
 * @date 2019/06/21
 */
public class TestFileUtil {

    public static void main(String[] args) {

        // 测试方法readDir(dirPath)
        // 文件夹路径
        String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";

        ArrayList<String> fileList = FileUtil.readDir(dirPath);
        System.out.println("----在TestFileUtil中打印返回列表：");
        for (String file : fileList) {
            System.out.println(file);
        }

    }

}
