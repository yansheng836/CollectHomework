/**  
 * @Title TestContain.java
 * @Package com.ys.main
 * @Description TODO
 * @author yansheng
 * @date 2019-07-03 19:05:16
 * @version v1.0
 */
package com.ys.main;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-07-03 19:05:16
 * @version v1.0 
 */
public class TestContain {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-07-03 19:05:16
	 * @Description TODO
	 * @param args   
	 * void 
	 * @see  
	 * @exception
	 */
	public static void main(String[] args) {
		String[] paths = {"郭晓20160310327数据库报告.doc","数据库系统原理20160310806-关锡琮.doc"};
		String[] snos = {"20160310327","  ","  "};
		String[] snames = {"郭晓","  ","  "};
		
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
