/**  
 * @Title ButtonListen.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-07-01 01:17:10
 * @version v1.0
 */
package com.ys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
 * @date 2019-07-01 01:17:11
 * @version v1.0 
 */
public class ButtonListen implements ActionListener {

	// 输入文本框，输入三角形三条边的值
	JTextField jtfExcel;
	JTextField jtfPath;
	JTextField jtfClassNo;
	JTextField jtfStuNo;
	JTextField jtfNoStuNo;
	JTextField jtfFileNo;

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

	public JTextField getJtfExcel() {
		return jtfExcel;
	}

	public void setJtfExcel(JTextField jtfExcel) {
		this.jtfExcel = jtfExcel;
	}

	public JTextField getJtfPath() {
		return jtfPath;
	}

	public void setJtfPath(JTextField jtfPath) {
		this.jtfPath = jtfPath;
	}

	public JTextField getJtfClassNo() {
		return jtfClassNo;
	}

	public void setJtfClassNo(JTextField jtfClassNo) {
		this.jtfClassNo = jtfClassNo;
	}

	public JTextField getJtfStuNo() {
		return jtfStuNo;
	}

	public void setJtfStuNo(JTextField jtfStuNo) {
		this.jtfStuNo = jtfStuNo;
	}

	public JTextField getJtfNoStuNo() {
		return jtfNoStuNo;
	}

	public void setJtfNoStuNo(JTextField jtfNoStuNo) {
		this.jtfNoStuNo = jtfNoStuNo;
	}

	public JTextField getJtfFileNo() {
		return jtfFileNo;
	}

	public void setJtfFileNo(JTextField jtfFileNo) {
		this.jtfFileNo = jtfFileNo;
	}

	public JButton getBtReadExcel() {
		return btReadExcel;
	}

	public void setBtReadExcel(JButton btReadExcel) {
		this.btReadExcel = btReadExcel;
	}

	public JButton getBtReadDir() {
		return btReadDir;
	}

	public void setBtReadDir(JButton btReadDir) {
		this.btReadDir = btReadDir;
	}

	public JButton getBtFindBySno() {
		return btFindBySno;
	}

	public void setBtFindBySno(JButton btFindBySno) {
		this.btFindBySno = btFindBySno;
	}

	public JButton getBtFindBySname() {
		return btFindBySname;
	}

	public void setBtFindBySname(JButton btFindBySname) {
		this.btFindBySname = btFindBySname;
	}

	public JButton getBtSave() {
		return btSave;
	}

	public void setBtSave(JButton btSave) {
		this.btSave = btSave;
	}

	public JTextArea getjTextArea() {
		return jTextArea;
	}

	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

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

	public ArrayList<Student> getNoFoundStuList() {
		return noFoundStuList;
	}

	public void setNoFoundStuList(ArrayList<Student> noFoundStuList) {
		this.noFoundStuList = noFoundStuList;
	}

	/**
	 * <p>Title: actionPerformed</p>
	 * <p>Description: </p>
	 * @param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		String btFindBySnoText = "按学号进行查找文件";

		if (btFindBySnoText.equals(cmd)) {
			System.out.println("sno:" + btFindBySnoText);

			String sign = "sno";
			btFindBySnoFunction(excelPath, dirPath, sign);
		}

	}

	public void btFindBySnoFunction(String excelPath, String dirPath, String sign) {
		// 1.获取点名册路径和文件夹路径信息
		// String excelPath = "16计算机科学与技术3学生名单.xls";
		// String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";
//		 excelPath = getExcelPath();
//		 dirPath = getDirPath();
		// String excelPath = jtfExcel.getText();
		// String dirPath = jtfPath.getText();
		// 设置默认值
		if ("".equals(jtfExcel.getText()) != true) {
			excelPath = jtfExcel.getText();
		} else {
			jtfExcel.setText(excelPath);
		}
		if ("".equals(jtfPath.getText()) != true) {
			dirPath = jtfPath.getText();
		} else {
			jtfPath.setText(dirPath);
		}

		// System.out.println("--表格路径为:" + excelPath + "\n--文件夹路径为:" + dirPath + "\n\n");
		jTextArea.setText("--表格路径为:" + excelPath + "\n--文件夹路径为:" + dirPath + "\n\n");

		// 2.读取表格和文件夹
		ArrayList<Student> students = ExcelUtil.readExcel(excelPath);
		// 遍历进行验证
		// for (Student student : students) {
		// System.out.println(student);
		// }

		ArrayList<String> fileList = FileUtil.readDir(dirPath);

		// 3.取得返回的数据比较结果
		String[] compareResults = FindStudentUtil.compareNumber(students, fileList);
		String result = compareResults[0];
		int classNum = Integer.parseInt(compareResults[1]);
		int fileNum = Integer.parseInt(compareResults[2]);

		System.out.println("result:" + result);
		// System.out.println("classNum:" + classNum+",fileNum:" + fileNum);

		// 3.取得返回的列表结果
		// String sign = "sno";
		ArrayList<ArrayList<Student>> arrayStuList = FindStudentUtil.findStu(students, fileList, sign);
		ArrayList<Student> studentFindList = arrayStuList.get(0);
		noFoundStuList = arrayStuList.get(1);

		// jlClassNo，jtfClassNo，jlStuNo，jtfStuNo，jlNoStuNo，jtfNoStuNo，jlFileNo，jtfFileNo
		int stuNum = studentFindList.size();
		int noStuNum = noFoundStuList.size();

		// 显示数量信息
		jtfClassNo.setText(String.valueOf(classNum));
		jtfStuNo.setText(String.valueOf(stuNum));
		jtfNoStuNo.setText(String.valueOf(noStuNum));
		jtfFileNo.setText(String.valueOf(fileNum));

		System.out.println("在TestFindStudentUtil中遍历:");
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

		// ExcelUtil.writeExcel(students);

	}

	public void saveExcel() {
		// ExcelUtil.writeExcel(excelPath, noFoundStuList);
		//
		// // 显示保存信息
		// String saveExcelPath = ExcelUtil.getSaveExcelFileName(excelPath);
		// jTextArea.setText("----写数据到(" + saveExcelPath + ")成功。----\n");
	}

}
