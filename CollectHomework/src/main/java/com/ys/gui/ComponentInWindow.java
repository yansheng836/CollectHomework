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
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	// 输入文本框，输入三角形三条边的值
	JTextField jtfExcel;
	JTextField jtfPath;
	JTextField jtfClassNo;
	JTextField jtfStuNo;
	JTextField jtfNoStuNo;
	JTextField jtfFileNo;

	JLabel jlExcel;
	JLabel jlPath;
	JLabel jlClassNo;
	JLabel jlStuNo;
	JLabel jlNoStuNo;
	JLabel jlFileNo;

	// 确认和取消按钮
	JButton btReadExcel;
	JButton btReadDir;
	JButton btFindBySno;
	JButton btFindBySname;
	// 保存数据到Excel表格
	JButton btSave;

	// 显示结果
	JTextArea jTextArea;

	// 定义两个变量，方便从主类传数据进来
	String excelPath;
	String dirPath;
	String sign;

	// 没有找到的学生列表
	ArrayList<Student> noFoundStuList;

	// 按钮的监听器
	ButtonListen buttonListen;

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
		InitGlobalFont(new Font("宋体", Font.PLAIN, 5));  // 统一设置字体
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	 */
	private static void InitGlobalFont(Font font) {
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

		// FlowLayout flowLayout = new FlowLayout();
		// 在流行布局中每个组件都居中显示
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		// 设置布局里面的垂直间距为10px,默认为5px
		flowLayout.setVgap(15);
		this.setLayout(flowLayout);

		jlExcel = new JLabel("请输入表格路径：");
		jlExcel.setFont(new Font("宋体", Font.BOLD, 25));

		jtfExcel = new JTextField(65);
		jtfExcel.setFont(new Font("宋体", Font.BOLD, 23));

		jlPath = new JLabel("请输入文件夹路径：");
		jlPath.setFont(new Font("宋体", Font.BOLD, 25));

		jtfPath = new JTextField(63);
		jtfPath.setFont(new Font("宋体", Font.BOLD, 23));

		int x = 10, y = 20;
		// jLabelB = new JLabel("<html><body><p>" + x + "<br>" + y + "</p></body></html>");

		btReadExcel = new JButton("读取班级点名册");
		btReadDir = new JButton("读取文件夹");
		btFindBySno = new JButton("按学号进行查找文件");
		btFindBySname = new JButton("按姓名进行查找文件");
		btSave = new JButton("将未交作业的学生名单保存到excel文件中");

		JButton button = new JButton("换行按钮");
		button.setVisible(true);

		btReadExcel.setFont(new Font("宋体", Font.BOLD, 22));
		btReadDir.setFont(new Font("宋体", Font.BOLD, 22));
		btFindBySno.setFont(new Font("宋体", Font.BOLD, 22));
		btFindBySname.setFont(new Font("宋体", Font.BOLD, 22));
		btSave.setFont(new Font("宋体", Font.BOLD, 22));
		button.setFont(new Font("宋体", Font.BOLD, 22));

		/*
		 * 显示班级总人数，已交作业的学生人数，未交作业的人数，文件夹下文件总数
		 * jlClassNo，jtfClassNo，jlStuNo，jtfStuNo，jlNoStuNo，jtfNoStuNo，jlFileNo，jtfFileNo
		 */
		jlClassNo = new JLabel("班级学生人数为:");
		jlClassNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtfClassNo = new JTextField(2);
		jtfClassNo.setFont(new Font("宋体", Font.BOLD, 23));

		jlStuNo = new JLabel("已交作业人数为:");
		jlStuNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtfStuNo = new JTextField(2);
		jtfStuNo.setFont(new Font("宋体", Font.BOLD, 23));

		jlNoStuNo = new JLabel("未交作业的学生人数为:");
		jlNoStuNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtfNoStuNo = new JTextField(2);
		jtfNoStuNo.setFont(new Font("宋体", Font.BOLD, 23));

		jlFileNo = new JLabel("文件夹内文件数量为:");
		jlFileNo.setFont(new Font("宋体", Font.BOLD, 25));
		jtfFileNo = new JTextField(2);
		jtfFileNo.setFont(new Font("宋体", Font.BOLD, 23));

		// 定义一个文本框，用于显示一些提示信息，行列
		jTextArea = new JTextArea(9, 59);
		jTextArea.setFont(new Font("console", Font.PLAIN, 22));
		// jTextArea.setText("这里将显示测试结果");

		// 添加滚动窗格，当内容超过范围时，显示滚动条
		JScrollPane jsp1 = new JScrollPane(jTextArea);

		buttonListen = new ButtonListen();
		buttonListen.setBtFindBySname(btFindBySname);
		buttonListen.setBtFindBySno(btFindBySno);
		buttonListen.setBtReadDir(btReadDir);
		buttonListen.setBtReadExcel(btReadExcel);
		buttonListen.setBtSave(btSave);

		buttonListen.setDirPath(getDirPath());
		buttonListen.setExcelPath(getExcelPath());
		buttonListen.setSign(getSign());

		buttonListen.setjTextArea(jTextArea);
		buttonListen.setJtfClassNo(jtfClassNo);
		buttonListen.setJtfExcel(jtfExcel);
		buttonListen.setJtfFileNo(jtfFileNo);
		buttonListen.setJtfNoStuNo(jtfNoStuNo);
		buttonListen.setJtfPath(jtfPath);
		buttonListen.setJtfStuNo(jtfStuNo);
		buttonListen.setNoFoundStuList(noFoundStuList);

		btReadExcel.addActionListener(buttonListen);
		btReadDir.addActionListener(buttonListen);
		btFindBySno.addActionListener(buttonListen);
		btFindBySname.addActionListener(buttonListen);
		btSave.addActionListener(buttonListen);

		// 标签
		this.add(jlExcel);
		this.add(jtfExcel);
		this.add(jlPath);
		this.add(jtfPath);

		// button
		this.add(btReadExcel);
		this.add(btReadDir);
		this.add(btFindBySno);
		this.add(btFindBySname);
		this.add(button);

		this.add(jlClassNo);
		this.add(jtfClassNo);

		this.add(jlStuNo);
		this.add(jtfStuNo);

		this.add(jlNoStuNo);
		this.add(jtfNoStuNo);

		this.add(jlFileNo);
		this.add(jtfFileNo);

		//
		this.add(btSave);

		// this.add(jTextArea);
		this.add(jsp1);
		
		
		btSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExcelUtil.writeExcel(excelPath, noFoundStuList);

				// 显示保存信息
				String saveExcelPath = ExcelUtil.getSaveExcelFileName(excelPath);
				jTextArea.setText("----写数据到(" + saveExcelPath + ")成功。----\n");

			}
		});

	}

}
