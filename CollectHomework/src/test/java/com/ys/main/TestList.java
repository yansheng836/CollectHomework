package com.ys.main;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * <p>Title: </p>
 * <p>Description: 测试list的使用</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-05 23:33:39
 * @version v1.0 
 */
public class TestList {

	public static void main(String[] args) {
		
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> stringss = new ArrayList<String>();
		strings.add("1");
		strings.add("2");
		strings.add("3");
		
		stringss.add("1");
		stringss.add("2");
		
		strings.remove("1");
		strings.removeAll(stringss);
		
		
		
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println();
		for (String string : stringss) {
			System.out.println(string);
		}
		
		//
		System.out.println("打印列表信息：");
		System.out.println(strings.toString());
		
		
		//尝试正则匹配
		boolean bool = false;
		String regex = "颜";
		String string = "我是颜升";
		bool = Pattern.matches(regex, string);
		boolean bool1 = string.contains(regex);
		System.out.println("匹配返回值为："+bool);
		System.out.println("匹配返回值为："+bool1);
		

	}

}
