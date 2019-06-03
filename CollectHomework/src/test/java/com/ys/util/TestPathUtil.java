/**  
 * @Title TestPathUtil.java
 * @Package com.ys.util
 * @Description 测试PathUtil的方法
 * @author yansheng
 * @date 2019-06-04 00:11:11
 * @version v1.0
 */
package com.ys.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: 测试PathUtil的方法</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-04 00:11:11
 * @version v1.0 
 */
public class TestPathUtil {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-04 00:11:11
	 * @Description 测试PathUtil的方法
	 * @param args   
	 * void 
	 * @see  
	 * @exception
	 */
	public static void main(String[] args) {

		// 1.测试PathUtil.raversalPath(path)
		String path = "F:\\Google\\downloads\\实验报告\\多媒体实验\\16计科3班多媒体实验一";
		ArrayList<String> pathList = null;
		try {
			pathList = PathUtil.raversalPath(path);
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		// 遍历列表
		System.out.println("\n--该目录下有" + pathList.size() + "文件，具体文件名如下：");
		for (String path1 : pathList) {
			System.out.println(path1);
		}
		
		
		
		

	}

}
