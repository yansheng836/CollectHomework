package com.ys.gui;

/**
 * 图形界面的主类 。
 * 
 * @author yansheng
 * @date 2019/06/19
 */
public class CollectHomeworkMain {

    public static void main(String[] args) {

        // 为了方便测试，直接在这里输入输入路径
        String excelPath = "./测试数据/测试用班级点名册.xls";
        String dirPath = "./测试数据/测试用文件夹--已收作业";

        // 按照学号还是按照姓名进行查找，只能是sno、sname中的一个
        String sign = "sno";

        ComponentInWindow win = new ComponentInWindow();

        win.setExcelPath(excelPath);
        win.setDirPath(dirPath);
        win.setSign(sign);
        // 设置窗口为不可拉伸的
        win.setResizable(false);
        win.setBounds(400, 200, 1100, 660);
        win.setTitle("查询未交作业的学生名单");
    }
}
