package com.ys.util;

import java.io.File;
import java.util.ArrayList;

/**
 * 文件工具类，提供一些和文件相关的静态方法，如读取文件夹里面的文件（名）。
 * 
 * @author yansheng
 * @date 2019/06/21
 */
public class FileUtil {

    /**
     * 遍历目录的方法（只是建立该目录的文件，不递归遍历子目录）,读取该目录下的文件（准确的说是文件名）。
     * 
     * @param dirPath
     *            需要遍历的目录的路径
     * @return ArrayList<String> 该目录下的文件名组成的ArrayList
     */
    public static ArrayList<String> readDir(String dirPath) {

        // 用于存储文件列表
        ArrayList<String> fileList = null;
        File file = null;
        try {
            file = new File(dirPath);
        } catch (NullPointerException e) {
            System.err.println("读取文件夹时发生NullPointerException异常，即文件夹路径为空。");
            e.printStackTrace();
        }

        // 遍历path下的文件和目录，存进File数组中
        File[] files = file.listFiles();
        fileList = new ArrayList<String>(files.length);
        // System.out.println("在\"" + dirPath + "\" 路径下有 " + files.length + " 个文件。");
        String fileName;
        for (File file1 : files) {
            // 1.（含盘符的）绝对路径
            // System.out.println(file1);
            // System.out.println(file1.toString());

            // 2.仅仅是文件名
            fileName = file1.getName();
            fileList.add(fileName);
        }

        return fileList;
    }

}
