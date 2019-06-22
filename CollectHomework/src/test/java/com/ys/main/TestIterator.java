/**  
 * @Title TestList1.java
 * @Package com.ys.main
 * @Description TODO
 * @author yansheng
 * @date 2019-06-20 02:26:08
 * @version v1.0
 */
package com.ys.main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-20 02:26:08
 * @version v1.0 
 */
public class TestIterator {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-20 02:26:08
	 * @Description TODO
	 * @param args   
	 * void 
	 * @see  
	 * @exception
	 */
	public static void main(String[] args) {

		/*
		 * 为了实现在遍历list是，进行修改，如果用简单foreach会抛出java.util.ConcurrentModificationException异常
		 * 要用Iterator方法，参考：https://www.cnblogs.com/dolphin0520/p/3933551.html
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer = iterator.next();
			if (integer == 2) {
				iterator.remove();   // 注意这个地方
			}
				
		}
	}

}
