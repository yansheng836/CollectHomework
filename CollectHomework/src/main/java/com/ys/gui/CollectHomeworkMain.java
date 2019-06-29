package com.ys.gui;

/**
 * <p>Title:图形界面的主类 。 </p>
 * <p>Description:图形界面的主类 。</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-19 14:07:11
 * @version v1.0 
 */
public class CollectHomeworkMain {

	public static void main(String[] args) {

		// 为了方便测试，直接在这里输入输入路径
		String excelPath = "16计算机科学与技术3学生名单.xls";
		String dirPath = "E:\\1学习，作业，文档\\6大三下相关文档资料及作业\\收作业\\16计科3班Linux实验报告";
		
		ComponentInWindow win = new ComponentInWindow();
		win.setExcelPath(excelPath);
		win.setDirPath(dirPath);
		win.setBounds(400, 200, 1100, 600);
		win.setTitle("查询未交作业的学生名单");
	}

}
