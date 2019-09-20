package com.ys.main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 测试Iterator遍历问题，在遍历list时删除元素
 * 
 * @author yansheng
 * @date 2019/06/20
 */
public class TestIterator {

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
