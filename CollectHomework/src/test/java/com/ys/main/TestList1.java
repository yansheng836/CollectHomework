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
public class TestList1 {

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
