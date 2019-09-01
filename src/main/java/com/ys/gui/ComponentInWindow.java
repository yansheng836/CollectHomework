package com.ys.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.FileUtil;
import com.ys.util.FindStudentUtil;

/**
 * <p>Title: 窗口的具体实现。</p>
 * <p>Description: 窗口的相关组件，以及事件监听。</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-19 14:07:01
 * @version v1.0 
 */
public class ComponentInWindow extends JFrame {

	/**  
	 * @Fields serialVersionUID : 1L
	 */
	private static final long serialVersionUID = 1L;

	// 在类里面先声明全局变量，方便各方法访问；先声明窗口组件变量，后参数

	// 文本显示（标签）对象
	// 显示读取文件的信息
	/**  
	 * @Fields jlExcelPath : Excel表格路径（标签）
	 */
	JLabel jlExcelPath;
	/**  
	 * @Fields jtfExcelPath : Excel表格路径（文本框）
	 */
	JTextField jtfExcelPath;

	/**  
	 * @Fields jlDirPath : 文件夹路径（标签）
	 */
	JLabel jlDirPath;

	/**  
	 * @Fields jtfDirPath : 文件夹路径（文本框）
	 */
	JTextField jtfDirPath;

	/**  
	 * @Fields jlClassNo : 原班级总人数（标签）
	 */
	JLabel jlClassNo;

	/**  
	 * @Fields jtfClassNo : 原班级总人数（文本框）
	 */
	JTextField jtfClassNo;

	/**  
	 * @Fields jlSpecialStuNo : 有特殊情况的学生人数（标签）
	 */
	JLabel jlSpecialStuNo;

	/**  
	 * @Fields jtfSpecialStuNo : 有特殊情况的学生人数（文本框）
	 */
	JTextField jtfSpecialStuNo;

	/**  
	 * @Fields jlCurrentStuNo : 当前学生人数（原班级总人数-有特殊情况的学生人数）（标签）
	 */
	JLabel jlCurrentStuNo;

	/**  
	 * @Fields jtfCurrentStuNo : 当前学生人数（原班级总人数-有特殊情况的学生人数）（文本框）
	 */
	JTextField jtfCurrentStuNo;

	/**  
	 * @Fields jlFileNo : 文件数量（标签）
	 */
	JLabel jlFileNo;

	/**  
	 * @Fields jtfFileNo : 文件数量（文本框）
	 */
	JTextField jtfFileNo;

	/**  
	 * @Fields jlFindStuNo : 已找到的学生人数（标签）
	 */
	JLabel jlFindStuNo;

	/**  
	 * @Fields jtfFindStuNo : 已找到的学生人数（文本框）
	 */
	JTextField jtfFindStuNo;

	/**  
	 * @Fields jlNoFindStuNo : 未找到的学生人数（当前学生人数-已找到的学生人数）（标签）
	 */
	JLabel jlNoFindStuNo;

	/**  
	 * @Fields jtfNoFindStuNo : 未找到的学生人数（当前学生人数-已找到的学生人数）（文本框）
	 */
	JTextField jtfNoFindStuNo;

	// 按钮：触发事件
	/**  
	 * @Fields btReadExcel : 读Excel的按钮
	 */
	JButton btReadExcel;
	/**  
	 * @Fields btReadDir : 读文件夹的按钮
	 */
	JButton btReadDir;
	/**  
	 * @Fields btFindBySno : 按学号查找学生的按钮
	 */
	JButton btFindBySno;
	/**  
	 * @Fields btFindBySname : 按姓名查找学生的按钮
	 */
	JButton btFindBySname;
	/**  
	 * @Fields btSaveNoStuToExcel : 保存未找到的学生的按钮
	 */
	JButton btSaveNoStuToExcel;

	/**  
	 * @Fields jTextArea : 显示多行文本的文本域：显示事件监听的相关信息
	 */
	JTextArea jTextArea;

	// 以下是相关参数声明（非组件）
	// 定义三个变量，方便从主类传数据进来
	/**  
	 * @Fields excelPath : Excel表格路径
	 */
	String excelPath;
	/**  
	 * @Fields dirPath : 文件夹路径
	 */
	String dirPath;
	/**  
	 * @Fields sign : 按学号查找还是按姓名查找的标志，可选值为sno/sname.
	 */
	String sign;

	/**  
	 * @Fields students : 现有班级学生列表
	 */
	ArrayList<Student> students;
	/**  
	 * @Fields fileList : 找到的学生列表
	 */
	ArrayList<String> fileList;
	/**  
	 * @Fields noFoundStuList : 没有找到的学生列表
	 */
	ArrayList<Student> noFoundStuList;

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public ComponentInWindow() {
		// 统一设置字体
		initGlobalFont(new Font("宋体", Font.BOLD, 25)); 
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @Title initGlobalFont
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-07-02 00:50:30
	 * @Description 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	 * @param font  字体
	 * void 
	 */
	private static void initGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}

	void init() {

		// 在流行布局中每个组件都居中显示
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		// 设置布局里面的垂直间距为10px,默认为5px
		flowLayout.setVgap(15);
		this.setLayout(flowLayout);

		// 设置excel和文件夹的显示信息和路径文本框
		jlExcelPath = new JLabel("请输入表格路径:");
		jtfExcelPath = new JTextField(61);
		jlDirPath = new JLabel("请输入文件夹路径:");
		jtfDirPath = new JTextField(59);

		btReadExcel = new JButton("读取班级点名册");
		btReadDir = new JButton("读取文件夹");
		btFindBySno = new JButton("按学号进行查找文件");
		btFindBySname = new JButton("按姓名进行查找文件");
		btSaveNoStuToExcel = new JButton("<br>将未交作业的学生名单保存到excel文件中");

		JButton button = new JButton("换行按钮");

		/*
		 * 显示班级总人数，已交作业的学生人数，未交作业的人数，文件夹下文件总数
		 * jlClassNo，jtfClassNo，jlStuNo，jtfStuNo，jlNoStuNo，jtfNoStuNo，jlFileNo，jtfFileNo
		 */
		jlClassNo = new JLabel("原班级学生人数:");
		jlSpecialStuNo = new JLabel("有特殊情况的学生人数:");
		jlCurrentStuNo = new JLabel("现班级学生人数:");
		jlFileNo = new JLabel("文件夹内文件数量:");
		jlFindStuNo = new JLabel("已交作业的学生人数:");
		jlNoFindStuNo = new JLabel("未交作业的学生人数:");

		jtfClassNo = new JTextField(2);
		jtfSpecialStuNo = new JTextField(2);
		jtfCurrentStuNo = new JTextField(2);
		jtfFileNo = new JTextField(2);
		jtfFindStuNo = new JTextField(2);
		jtfNoFindStuNo = new JTextField(2);

		// 定义一个文本框，用于显示一些提示信息，行列
		jTextArea = new JTextArea(9, 59);
		jTextArea.setFont(new Font("console", Font.PLAIN, 22));
		jTextArea.setText("这里将显示事件监听的一些结果");

		// 添加滚动窗格，当内容超过范围时，显示滚动条
		JScrollPane jsp1 = new JScrollPane(jTextArea);

		// 标签
		this.add(jlExcelPath);
		this.add(jtfExcelPath);
		this.add(jlDirPath);
		this.add(jtfDirPath);

		// button
		this.add(btReadExcel);
		this.add(btReadDir);
		this.add(btFindBySno);
		this.add(btFindBySname);
		this.add(button);

		// 添加显示数量信息的组件
		this.add(jlClassNo);
		this.add(jtfClassNo);

		this.add(jlSpecialStuNo);
		this.add(jtfSpecialStuNo);

		this.add(jlCurrentStuNo);
		this.add(jtfCurrentStuNo);

		this.add(jlFileNo);
		this.add(jtfFileNo);

		this.add(jlFindStuNo);
		this.add(jtfFindStuNo);

		this.add(jlNoFindStuNo);
		this.add(jtfNoFindStuNo);

		//
		this.add(btSaveNoStuToExcel);

		// this.add(jTextArea);
		this.add(jsp1);

		// 设置事件监听
		jtfExcelPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("触发了jtfExcelPath的事件。");
				readExcel();
			}
		});

		btReadExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("触发了btReadExcel的事件。");
				readExcel();
			}
		});

		jtfDirPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("触发了jtfDirPath的事件。");
				readDir();
			}
		});

		btReadDir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("触发了btReadDir的事件。");
				readDir();
			}
		});

		btFindBySname.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea.setText("--按姓名进行查找文件");
				sign = "sname";
				btFindBySnoFunction(excelPath, dirPath, sign);
			}
		});

		btFindBySno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea.setText("--按学号进行查找文件");
				sign = "sno";
				btFindBySnoFunction(excelPath, dirPath, sign);
			}
		});

		btSaveNoStuToExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExcelUtil.writeExcel(excelPath, noFoundStuList);

				// 显示保存信息
				String saveExcelPath = ExcelUtil.getSaveExcelFileName(excelPath);
				jTextArea.setText("----写数据到(" + saveExcelPath + ")成功。----\n");

			}
		});

	}

	public void readExcel() {
		if ("".equals(jtfExcelPath.getText()) != true) {
			excelPath = jtfExcelPath.getText();
		} else {
			jtfExcelPath.setText(excelPath);
		}
		// System.out.println("--表格路径为:" + excelPath + "\n");
		jTextArea.setText("--表格路径为:" + excelPath + "\n");

		students = ExcelUtil.readExcel(excelPath);
		int studentSize = students.size();
		// 显示班级人数
		jtfCurrentStuNo.setText(String.valueOf(studentSize));

		jTextArea.append("--扫描到的学生人数为:" + studentSize + "，学生信息如下：\n");
		System.out.println("--扫描Excel得到的学生人数为:" + studentSize + "，学生信息如下：");
		for (Student student : students) {
			System.out.println(student.toString());
			jTextArea.append("  " + student.toString() + System.getProperty("line.separator"));
		}
	}

	public void readDir() {

		if ("".equals(jtfDirPath.getText()) != true) {
			dirPath = jtfDirPath.getText();
		} else {
			jtfDirPath.setText(dirPath);
		}
		System.out.println("--文件夹路径为:" + dirPath + "\n");
		jTextArea.setText("--文件夹路径为:" + dirPath + "\n");

		fileList = FileUtil.readDir(dirPath);
		int fileSize = fileList.size();
		// 显示文件数量
		jtfFileNo.setText(String.valueOf(fileSize));

		jTextArea.append("--扫描文件夹得到的文件数量为:" + fileSize + "，文件名如下：\n");
		System.out.println("--扫描文件夹得到的文件数量为:" + fileSize + "，文件名如下：");
		for (String string : fileList) {
			jTextArea.append("  " + string + System.getProperty("line.separator"));
		}

	}

	public void btFindBySnoFunction(String excelPath, String dirPath, String sign) {

		// 3.取得返回的数据比较结果
		String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
		String result = compareResults[0];
		int classNum = Integer.parseInt(compareResults[1]);
		int fileNum = Integer.parseInt(compareResults[2]);

		System.out.println("result:" + result);

		// 3.取得返回的列表结果
		ArrayList<Student> studentFindList = FindStudentUtil.findStu(students, fileList, sign);

		noFoundStuList = FindStudentUtil.removeList(students, studentFindList);

		// jlClassNo，jtfClassNo，jlStuNo，jtfStuNo，jlNoStuNo，jtfNoStuNo，jlFileNo，jtfFileNo
		int stuNum = studentFindList.size();
		int noStuNum = noFoundStuList.size();

		// 显示数量信息
		jtfFindStuNo.setText(String.valueOf(stuNum));
		jtfNoFindStuNo.setText(String.valueOf(noStuNum));
		jtfFileNo.setText(String.valueOf(fileNum));

		System.out.println("--1.已找到学生有 " + stuNum + " 名，学生列表为：");
		for (Student student : studentFindList) {
			System.out.println(student);
		}

		System.out.println("\n--2.未找到学生有 " + noStuNum + " 名，学生列表为：");
		for (Student student : noFoundStuList) {
			System.out.println(student);
		}

		// jTextArea.setText("");
		jTextArea.append(result + "\n");
		jTextArea.append("--1.已找到学生有 " + stuNum + " 名，学生列表为：\n");
		for (Student student : studentFindList) {
			// 获取原内容，增加换行符，再拼接list当前值
			// System.getProperty("line.separator") 为换行，当然"\n"也可以
			// jTextArea.append(jTextArea.getText() + System.getProperty("line.separator") + temp);
			jTextArea.append(student.toString() + System.getProperty("line.separator"));
		}

		jTextArea.append("\n--2.未找到学生有 " + noStuNum + " 名，学生列表为：\n");
		for (Student student : noFoundStuList) {
			jTextArea.append(student.toString() + System.getProperty("line.separator"));
		}

	}
}
