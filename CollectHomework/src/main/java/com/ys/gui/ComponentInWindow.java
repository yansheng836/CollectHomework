package com.ys.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ys.bean.Student;

public class ComponentInWindow extends JFrame { // 窗口组件

	private static final long serialVersionUID = 1L;

	// 输入文本框，输入三角形三条边的值
	JTextField textA;
	JTextField textB;
	JTextField textC;

	JLabel jLabelA;
	JLabel jLabelB;
	JLabel jLabelC;

	// 确认和取消按钮
	JButton bConfirm;
	JButton bCancel;
	JButton bSave; // 保存数据到Excel表格

	// 显示结果
	JTextArea jTextArea;

	// 计数-测试用例个数，同时作为TestCase的id
	static int count = 0;

	public ComponentInWindow() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		// FlowLayout flowLayout = new FlowLayout();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER); // 在流行布局中每个组件都居中显示
		flowLayout.setVgap(15); // 设置布局里面的垂直间距为10px,默认为5px
		this.setLayout(flowLayout);

		jLabelA = new JLabel("  A   ");
		jLabelB = new JLabel("    B  ");
		jLabelC = new JLabel("    C  ");

		jLabelA.setFont(new Font("宋体", Font.BOLD, 30));
		jLabelB.setFont(new Font("宋体", Font.BOLD, 30));
		jLabelC.setFont(new Font("宋体", Font.BOLD, 30));
		this.add(jLabelA);
		this.add(jLabelB);
		this.add(jLabelC);

		textA = new JTextField(10);
		textB = new JTextField(10);
		textC = new JTextField(10);
		textA.setFont(new Font("宋体", Font.BOLD, 25));
		textB.setFont(new Font("宋体", Font.BOLD, 25));
		textC.setFont(new Font("宋体", Font.BOLD, 25));
		this.add(textA);
		this.add(textB);
		this.add(textC);

		bConfirm = new JButton("确认输入");
		bCancel = new JButton("清除数据");
		bConfirm.setFont(new Font("宋体", Font.BOLD, 25));
		bCancel.setFont(new Font("宋体", Font.BOLD, 25));

		bSave = new JButton("保存测试用例到Excel表格");
		bSave.setFont(new Font("宋体", Font.BOLD, 25));

		this.add(bConfirm);
		this.add(bCancel);
		this.add(bSave);

		jTextArea = new JTextArea(6, 30); // 行列
		jTextArea.setFont(new Font("宋体", Font.BOLD, 25));
		jTextArea.setText("这里将显示测试结果");
		this.add(jTextArea);

		// 存储测试用例
		ArrayList<Student> students = new ArrayList<Student>();

		// 为“确认输入”按钮设置监听事件
//		bConfirm.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// jTextArea.setText("Hello World!");
//				// 将输入值转换为double类型，并调用 TestTriangle.isTriangle(a, b, c)方法进行测试
//				double a = Double.parseDouble(textA.getText());
//				double b = Double.parseDouble(textB.getText());
//				double c = Double.parseDouble(textC.getText());
//
//				StringBuffer resultString = TestTriangle.isTriangle(a, b, c);
//				String string = new String(resultString);
//
//				jTextArea.setText(string);
//
//				count++;
//				TestCase testCase = new TestCase(count, a, b, c, string);
//				// System.out.println(testCase.toString());
//				testCases.add(testCase);
//
//				System.out.println("\n遍历测试用例集:");
//				for (TestCase testCase1 : testCases) {
//					System.out.println(testCase1.toString());
//				}
//
//			}
//		});

		/*
		 * 为“清除数据”按钮设置监听事件
		 * 
		 * @description 把文本框的数据全部置为空
		 */
		bCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textA.setText("");
				textB.setText("");
				textC.setText("");
				jTextArea.setText("");
			}
		});

		/*
		 * 为“保存数据”按钮设置监听事件
		 * 
		 * @description 把数据写到excel表格
		 */
//		bSave.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("\n------------将保存测试用例到Excel表格------------");
//				WriteToExecl.writeToExecl(testCases);
//			}
//		});
	}
}
