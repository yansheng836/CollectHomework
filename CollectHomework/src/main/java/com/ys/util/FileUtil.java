/**  
 * @Title FileUtil.java
 * @Package com.ys.util
 * @Description 定义一些和文件相关的工具类，如读取文件夹里面的文件（名）
 * @author yansheng
 * @date 2019-06-21 21:39:11
 * @version v1.0
 */
package com.ys.util;

import java.io.File;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: com.ys</p>
 * @author yansheng
 * @date 2019-06-21 21:39:11
 * @version v1.0 
 */
public class FileUtil {

	/**
	 * @Title readDir
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-03 23:15:52
	 * @Description 定义一个遍历目录的方法（只是建立该目录的文件，不递归遍历子目录）,读取该目录下的文件（准确的说是文件名）
	 * @param dirPath 需要遍历的目录的路径
	 * @return ArrayList<String> 该目录下的文件名组成的ArrayList
	 */
	public static ArrayList<String> readDir(String dirPath) {

		// 用于存储文件列表
		ArrayList<String> fileList = new ArrayList<String>();
		File file = new File(dirPath);

		// 遍历path下的文件和目录，存进File数组中
		File[] files = file.listFiles();
//		System.out.println("在\"" + dirPath + "\" 路径下有  " + files.length + " 个文件。");
		String fileName;
		for (File file1 : files) {
			// 1.（含盘符的）绝对路径
			// System.out.println(file1);
			// System.out.println(file1.toString());

			// 2.文件名
			// System.out.println(file1.getName());
			fileName = file1.getName();
			fileList.add(fileName);
		}

		// 遍历列表，验证输出
		// System.out.println("\n--该目录下有" + pathList.size() + "文件，文件名如下：");
		// for (String file1 : fileList) {
		// System.out.println(file1);
		// }

		return fileList;
	}

}
