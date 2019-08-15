/**  
 * @Title TestRemoveList.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-08-15 18:29:11
 * @version v1.0
 */
package com.ys.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-08-15 18:29:11
 * @version v1.0 
 */
public class TestRemoveList {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-08-15 18:29:11
	 * @Description TODO
	 */
	public static void main(String[] args) {

		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("1");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("1");
		list2.add("1");
		list2.add("3");
		
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println(list2.removeAll(list1));
		
		System.out.println(list1);
		System.out.println(list2);

	}

}
