/**  
 * @Title PathUtil.java
 * @Package com.ys.util
 * @Description 作为一个工具类提供一个有关路径问题的方法
 * @author yansheng
 * @date 2019-06-03 23:13:48
 * @version v1.0
 */
package com.ys.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: 作为一个工具类提供一个有关路径问题的方法</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-03 23:13:48
 * @version v1.0 
 */
public class PathUtil {

	/**
	 * @Title raversalPath
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-03 23:15:52
	 * @Description 1.定义一个遍历目录的方法（只是建立该目录的文件，不递归遍历子目录）
	 * @param path 需要遍历的目录的路径
	 * @return ArrayList<String> 返回该目录下的文件名组成的ArrayList
	 * @see  
	 * @exception
	 */
	public static ArrayList<String> raversalPath(String path) throws FileNotFoundException {

		ArrayList<String> pathList = new ArrayList<String>();

		File file = new File(path);

		// 遍历path下的文件和目录，放在File数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// 1.绝对路径
			// System.out.println(f);
			// System.out.println(f.toString());

			// 2.文件名
			// System.out.println(f.getName());
			String fileName = f.getName();
			fileName = subPath(fileName);
			pathList.add(fileName);
		}

		// 遍历列表
		// System.out.println("\n--该目录下有" + pathList.size() + "文件，文件名如下：");
		// for (String path1 : pathList) {
		// System.out.println(path1);
		// }

		return pathList;
	}

	
	/**
	 * @Title subPath
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-04 00:36:37
	 * @Description 对文件名超过11个字符的文件名进行裁剪,后期考虑用正则进行匹配
	 * @param path
	 * @return  String
	 * @see  
	 * @exception
	 */
	public static String subPath(String path) {

		String subpath;
		int snoLength = 11;
		// 如果文件名长度大于11，就截取前面的11个字符
		if (path.length() > snoLength) {
			// System.out.println("路径("+path1+")长度超过11位，裁剪后为：");
			subpath = path.substring(0, snoLength);
		} else {
			subpath = path;
		}

		return subpath;
	}

}
