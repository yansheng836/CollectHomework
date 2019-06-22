/**  
 * @Title TestFileUtil.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-21 21:51:46
 * @version v1.0
 */
package com.ys.util;

import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-21 21:51:46
 * @version v1.0 
 */
public class TestFileUtil {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-21 21:51:46
	 * @Description 测试FileUtil类的方法。
	 * @param args   
	 * @return void 
	 */
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
