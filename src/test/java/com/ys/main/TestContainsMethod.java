package com.ys.main;

/**
 * 测试contains方法的用法
 * @author yansheng
 * @date 2019/07/03
 */
public class TestContainsMethod {

	public static void main(String[] args) {
		String[] paths = {"张三20160310327数据库报告.doc","数据库系统原理20160310806-李四.doc"};
		String[] snos = {"20160310327","  ","  "};
		String[] snames = {"张三","  ","  "};
		
		System.out.println("路径包含学号：");
		for (String path : paths) {
			for (String sno : snos) {
				if (path.contains(sno)) {
					System.out.println("\""+path+"\" 包含  \""+sno+"\"");
				}
			}
		}
		
		System.out.println("\n路径包含姓名：");
		for (String path : paths) {
			for (String sno : snames) {
				if (path.contains(sno)) {
					System.out.println("\""+path+"\" 包含  \""+sno+"\"");
				}
			}
		}

	}

}
