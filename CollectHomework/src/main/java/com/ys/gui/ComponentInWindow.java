package com.ys.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.FileUtil;
import com.ys.util.FindStudentUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-19 14:07:01
 * @version v1.0 
 */
public class ComponentInWindow extends JFrame { // 窗口组件

	/**  
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	// 输入文本框，输入三角形三条边的值
	JTextField jtfExcel;
	JTextField jtfPath;
	JTextField jtStuNo;
	JTextField jtNoStuNo;

	JLabel jlExcel;
	JLabel jlPath;
	JLabel jlStuNo;
	JLabel jlNoStuNo;

	// 确认和取消按钮
	JButton btReadExcel;
	JButton btReadDir;
	JButton btFindBySno;
	JButton btFindBySname;
	// 保存数据到Excel表格
	JButton btSave; 

	// 显示结果
	JTextArea jTextArea;

	// 计数-测试用例个数，同时作为TestCase的id
	/**  
	 * @Fields count : 
	 */
	static int count = 0;

	public ComponentInWindow() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		// FlowLayout flowLayout = new FlowLayout();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT); // 在流行布局中每个组件都居中显示
		flowLayout.setVgap(15); // 设置布局里面的垂直间距为10px,默认为5px
		this.setLayout(flowLayout);

		jlExcel = new JLabel("请输入表格路径：");
		jlExcel.setFont(new Font("宋体", Font.BOLD, 25));
		
		jtfExcel = new JTextField(65);
		jtfExcel.setFont(new Font("宋体", Font.BOLD, 23));
		this.add(jlExcel);
		this.add(jtfExcel);

		jlPath = new JLabel("请输入文件夹路径：");
		jlPath.setFont(new Font("宋体", Font.BOLD, 25));
		
		jtfPath = new JTextField(63);
		jtfPath.setFont(new Font("宋体", Font.BOLD, 23));
		this.add(jlPath);
		this.add(jtfPath);

		int x = 10, y = 20;
		// jLabelB = new JLabel("<html><body><p>" + x + "<br>" + y + "</p></body></html>");

		
		btReadExcel = new JButton("读取班级点名册");
		btReadDir  = new JButton("读取文件夹");
		btFindBySno = new JButton("按学号进行查找文件");
		btFindBySname = new JButton("按姓名进行查找文件");
		btSave = new JButton("将未交作业的学生名单保存到excel文件中");

		btReadExcel.setFont(new Font("宋体", Font.BOLD, 25));
		btReadDir.setFont(new Font("宋体", Font.BOLD, 25));
		btFindBySno.setFont(new Font("宋体", Font.BOLD, 25));
		btFindBySname.setFont(new Font("宋体", Font.BOLD, 25));
		btSave.setFont(new Font("宋体", Font.BOLD, 25));

		this.add(btReadExcel);
		this.add(btReadDir);
		this.add(btFindBySno);
		this.add(btFindBySname);
		
		/*
		 * 显示班级总人数和已交作业的学生人数
		 */
		jlStuNo = new JLabel("班级学生人数为:");
		jlStuNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtStuNo = new JTextField(2);
		jtStuNo.setFont(new Font("宋体", Font.BOLD, 23));
		
		jlNoStuNo = new JLabel("已交作业人数为:");
		jlNoStuNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtNoStuNo = new JTextField(2);
		jtNoStuNo.setFont(new Font("宋体", Font.BOLD, 23));
		
		this.add(jlStuNo);
		this.add(jtStuNo);
		this.add(jlNoStuNo);
		this.add(jtNoStuNo);
		
		// 
		this.add(btSave);

		// 定义一个文本框，用于显示一些提示信息，行列
		jTextArea = new JTextArea(6, 73);
		jTextArea.setFont(new Font("宋体", Font.BOLD, 25));
		jTextArea.setText("这里将显示测试结果");

		// 添加滚动窗格，当内容超过范围时，显示滚动条
		JScrollPane jsp1 = new JScrollPane(jTextArea);
		// this.add(jTextArea);
		this.add(jsp1);

		// 存储测试用例
		ArrayList<Student> students = new ArrayList<Student>();

		// 为“确认输入”按钮设置监听事件
		btReadExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 获取点名册路径和文件夹路径信息
				String excelPath = "16计算机科学与技术3学生名单.xls";
				// excelPath = jTextFieldExcel.getText();
				String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";
				// dirPath = jTextFieldPath.getText();
				System.out.println(excelPath);
				System.out.println(dirPath);
				jTextArea.setText("excelPath:" + excelPath + ",dirPath:" + dirPath);

				// String excelPath = "16计算机科学与技术3学生名单.xls";
				ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
				// 遍历进行验证
				for (Student student : students) {
					System.out.println(student);
				}

				ArrayList<String> pathList = FileUtil.readDir(dirPath);

				// for (String string : pathList) {
				// System.out.println(string);
				// }

				ArrayList<String> fileList = FileUtil.readDir(dirPath);
				
				String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
				String result = compareResults[0];
				int stuNum = Integer.parseInt(compareResults[1]);
				int fileNum = Integer.parseInt(compareResults[2]);
						
				System.out.println("result:"+result);
				System.out.println("stuNum:"+stuNum);
				System.out.println("fileNum:"+fileNum);

				String sign = "sno";
				ArrayList<ArrayList<Student>> arrayStuList = FindStudentUtil.findStu(students, fileList, sign);
				ArrayList<Student> studentFindList = arrayStuList.get(0);
				ArrayList<Student> noFoundStuList = arrayStuList.get(1);
				System.out.println("在TestFindStudentUtil中遍历：");
				for (Student student : studentFindList) {
					System.out.println(student);
				}

				System.out.println("不存在的student中遍历：");
				for (Student student : noFoundStuList) {
					System.out.println(student);
				}
				jTextArea.setText(studentFindList.toString());

				// ExcelUtil.writeExcel(students);

			}
		});
		
		// 保存文件的事件监听
		btSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ExcelUtil.writeExcel(students);
			}
		});
	}
	
	

}