package com.ys.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class TestGlobalFont {

	public static void main(String[] args) {
		
		JFrame jFrame = new JFrame("测试设置全局字体");
		// 初始化窗口
		init(jFrame);
		
		jFrame.setBounds(800, 400, 400, 400);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @Title init
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-07-01 11:28:31
	 * @Description 初始化窗口
	 * @param jFrame   
	 * void 
	 */
	public static void init(JFrame jFrame) {
		InitGlobalFont(new Font("宋体", Font.PLAIN, 40)); // 统一设置字体
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		jFrame.setLayout(flowLayout);
		
		JLabel jLabel = new JLabel("JLabel显示文本信息");
		jFrame.add(jLabel);
		JButton jButton = new JButton("JButton按钮");
		jFrame.add(jButton);
		
		JButton jButton1 = new JButton("这个按钮的字体是微软雅黑");
		jButton1.setFont(new Font("微软雅黑", Font.BOLD, 25));
		jFrame.add(jButton1);
	}

	
	
	/**
	* 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	*/
	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		// 打印字体信息
		System.out.println("fontRes:" + fontRes);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);

			if (value instanceof FontUIResource) {
				// 打印默认的所有有关字体的信息
				System.out.println("\nkey:" + key + "\nvalue:" + value);
				UIManager.put(key, fontRes);
				// 打印更改后的相关信息
				System.out.println("\nkey:" + key + "\nvalue:" + UIManager.get(key));
			}

		}
	}
	
	/**精简版，无注释的
	* 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	*/
	private static void InitGlobalFont1(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}
}
