package com.ys.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ys.bean.Student;
import com.ys.util.ExcelUtil;
import com.ys.util.PathUtil;

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
	JTextField jTextFieldExcel;
	JTextField jTextFieldPath;
	// JTextField textC;

	JLabel jLabelExcel;
	JLabel jLabelPath;
	// JLabel jLabelC;

	// 确认和取消按钮
	JButton bConfirm;
	JButton bCancel;
	JButton bSave; // 保存数据到Excel表格

	// 显示结果
	JTextArea jTextArea;

	// 计数-测试用例个数，同时作为TestCase的id
	/**  
	 * @Fields count : TODO
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

		jLabelExcel = new JLabel("请输入表格路径：");
		jLabelExcel.setFont(new Font("宋体", Font.BOLD, 25));
		jTextFieldExcel = new JTextField(65);
		jTextFieldExcel.setFont(new Font("宋体", Font.BOLD, 23));
		this.add(jLabelExcel);
		this.add(jTextFieldExcel);

		jLabelPath = new JLabel("请输入文件夹路径：");
		jLabelPath.setFont(new Font("宋体", Font.BOLD, 25));
		jTextFieldPath = new JTextField(63);
		jTextFieldPath.setFont(new Font("宋体", Font.BOLD, 23));
		this.add(jLabelPath);
		this.add(jTextFieldPath);

		int x = 10, y = 20;
		// jLabelB = new JLabel("<html><body><p>" + x + "<br>" + y + "</p></body></html>");

		bConfirm = new JButton("读取班级点名册");
		bCancel = new JButton("按学号进行查找文件");
		bSave = new JButton("按姓名进行查找文件");

		bConfirm.setFont(new Font("宋体", Font.BOLD, 25));
		bCancel.setFont(new Font("宋体", Font.BOLD, 25));
		bSave.setFont(new Font("宋体", Font.BOLD, 25));

		this.add(bConfirm);
		this.add(bCancel);
		this.add(bSave);

		// 行列
		jTextArea = new JTextArea(6, 73);
		jTextArea.setFont(new Font("宋体", Font.BOLD, 25));
		jTextArea.setText("这里将显示测试结果");
		
		// 添加滚动窗格，当内容超过范围时，显示滚动条
		JScrollPane jsp1 = new JScrollPane(jTextArea);
//		this.add(jTextArea);
		this.add(jsp1);

		// 存储测试用例
		ArrayList<Student> students = new ArrayList<Student>();

		// 为“确认输入”按钮设置监听事件
		bConfirm.addActionListener(new ActionListener() {

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

				// 文件夹路径
				String path = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";

				ArrayList<String> pathList = null;
				try {
					pathList = PathUtil.raversalPath(path);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				// for (String string : pathList) {
				// System.out.println(string);
				// }

				// 比较学号
				ArrayList<Student> studentFindList = new ArrayList<Student>();
				for (Student student : students) {
					String sno = student.getSno();
					for (String path1 : pathList) {
						if (sno.compareTo(path1) == 0) { // 匹配成功返回0
							studentFindList.add(student);
						}
					}
				}

				System.out.println("\n--遍历--已找到学生列表：");
				for (Student student : studentFindList) {
					System.out.println(student);
				}

				// 移除找到的学生
				students.removeAll(studentFindList);

				System.out.println("\n遍历--没找到学生列表：");
				System.out.println("一共有：" + students.size() + "人");

				for (Student student : students) {
					System.out.println(student);
				}

				// ExcelUtil.writeExcel(students);

			}
		});

	}

}