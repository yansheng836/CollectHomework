package com.ys.main;

import java.util.ArrayList;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	}

}
