package com.ys.main;

import java.io.File;
import java.util.ArrayList;

// 遍历路径
public class TraversalPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String path = "16计算机科学与技术3学生名单.xls";
		String path = "G:\\Workspaces\\eclipse最新英文版\\HomeWork";
		ArrayList<String> pathList = raversalPath(path);
		for (String path1 : pathList) {
			System.out.println(path1);
		}
		
		System.out.println();
		raversalSubPath(path);
		
		

	}
	
	public static ArrayList<String> raversalPath(String path) {
		
		ArrayList<String> pathList = new ArrayList<String>();
		
		File file = new File(path); // 获取其file对象
		File[] fs = file.listFiles(); // 遍历path下的文件和目录，放在File数组中
		for (File f : fs) { // 遍历File[]数组
			//if (!f.isDirectory()) // 若非目录(即文件)，则打印
			
				//1.绝对路径
				//System.out.println(f);

				//System.out.println(f.toString());
				//pathList.add(f.toString());
				
				//2.文件名
				//System.out.println(f.getName());
				pathList.add(f.getName());
				
		}
		return pathList;

	}
	
public static ArrayList<String> raversalSubPath(String path) {
		
		ArrayList<String> pathList = raversalPath(path);
		ArrayList<String> pathSubList =new ArrayList<String>();
		
		for (String path1 : pathList) {
			//3.如果文件名长度大于11，就截取前面的11个字符
			if (path1.length()>11) {
				//System.out.println("路径("+path1+")长度超过11位，裁剪后为：");
				String pathSubString = path1.substring(0, 11);
				//System.out.println(pathSubString);
				pathSubList.add(pathSubString);
			}
		}
		
		//
//		System.out.println("\n遍历剪切后的目录列表：");
//		for (String paths : pathSubList) {
//			System.out.println(paths);
//		}
		
		
		return pathSubList;

	}

}
