package com.ys.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试删除list中元素
 * 
 * @author yansheng
 * @date 2019/09/20
 */
public class TestRemoveList {

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
