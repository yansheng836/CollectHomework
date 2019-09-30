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
 * 窗口的具体实现，包含窗口的相关组件，以及事件监听。
 * 
 * @author yansheng
 * @date 2019/06/19
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
    private JLabel jlExcelPath;
    /**
     * @Fields jtfExcelPath : Excel表格路径（文本框）
     */
    private JTextField jtfExcelPath;

    /**
     * @Fields jlDirPath : 文件夹路径（标签）
     */
    private JLabel jlDirPath;

    /**
     * @Fields jtfDirPath : 文件夹路径（文本框）
     */
    private JTextField jtfDirPath;

    /**
     * @Fields jlClassNo : 原班级总人数（标签）
     */
    private JLabel jlClassNo;

    /**
     * @Fields jtfClassNo : 原班级总人数（文本框）
     */
    private JTextField jtfClassNo;

    /**
     * @Fields jlSpecialStuNo : 有特殊情况的学生人数（标签）
     */
    private JLabel jlSpecialStuNo;

    /**
     * @Fields jtfSpecialStuNo : 有特殊情况的学生人数（文本框）
     */
    private JTextField jtfSpecialStuNo;

    /**
     * @Fields jlCurrentStuNo : 当前学生人数（原班级总人数-有特殊情况的学生人数）（标签）
     */
    private JLabel jlCurrentStuNo;

    /**
     * @Fields jtfCurrentStuNo : 当前学生人数（原班级总人数-有特殊情况的学生人数）（文本框）
     */
    private JTextField jtfCurrentStuNo;

    /**
     * @Fields jlFileNo : 文件数量（标签）
     */
    private JLabel jlFileNo;

    /**
     * @Fields jtfFileNo : 文件数量（文本框）
     */
    private JTextField jtfFileNo;

    /**
     * @Fields jlFindStuNo : 已找到的学生人数（标签）
     */
    private JLabel jlFindStuNo;

    /**
     * @Fields jtfFindStuNo : 已找到的学生人数（文本框）
     */
    private JTextField jtfFindStuNo;

    /**
     * @Fields jlNoFindStuNo : 未找到的学生人数（当前学生人数-已找到的学生人数）（标签）
     */
    private JLabel jlNoFindStuNo;

    /**
     * @Fields jtfNoFindStuNo : 未找到的学生人数（当前学生人数-已找到的学生人数）（文本框）
     */
    private JTextField jtfNoFindStuNo;

    // 按钮：触发事件
    /**
     * @Fields btReadExcel : 读Excel的按钮
     */
    private JButton btReadExcel;
    /**
     * @Fields btReadDir : 读文件夹的按钮
     */
    private JButton btReadDir;
    /**
     * @Fields btFindBySno : 按学号查找学生的按钮
     */
    private JButton btFindBySno;
    /**
     * @Fields btFindBySname : 按姓名查找学生的按钮
     */
    private JButton btFindBySname;

    /**
     * 清空路径文本框数据的按钮
     */
    private JButton cleanPathJbt;

    /**
     * 清空统计数据的文本框的按钮
     */
    private JButton cleanNumJbt;

    /**
     * 清空文本域显示的数据的按钮
     */
    private JButton cleanJButton;

    /**
     * 清空所有文本数据的按钮
     */
    private JButton cleanAllJbt;

    /**
     * @Fields btSaveNoStuToExcel : 保存未找到的学生的按钮
     */
    private JButton btSaveNoStuToExcel;

    /**
     * @Fields jTextArea : 显示多行文本的文本域：显示事件监听的相关信息
     */
    private JTextArea jTextArea;

    // 以下是相关参数声明（非组件）
    // 定义三个变量，方便从主类传数据进来
    /**
     * @Fields excelPath : Excel表格路径
     */
    private String excelPath;
    /**
     * @Fields dirPath : 文件夹路径
     */
    private String dirPath;
    /**
     * @Fields sign : 按学号查找还是按姓名查找的标志，可选值为sno/sname.
     */
    private String sign;

    /**
     * @Fields students : 现有班级学生列表
     */
    private ArrayList<Student> students;
    /**
     * @Fields fileList : 找到的学生列表
     */
    private ArrayList<String> fileList;
    /**
     * @Fields noFoundStuList : 没有找到的学生列表
     */
    private ArrayList<Student> noFoundStuList;

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

    /**
     * 统一设置默认字体，如特殊组件有需要可在定义时进行设置，会覆盖默认设置。
     */
    public ComponentInWindow() {
        initGlobalFont(new Font("宋体", Font.BOLD, 25));
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体。
     * 
     * @param font
     *            字体
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

    /**
     * 窗口初始化的方法。
     */
    private void init() {
        // 在流型布局中每个组件都居中显示
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
        btSaveNoStuToExcel = new JButton("将未交作业的学生名单保存到excel文件中");

        cleanPathJbt = new JButton("清空路径");
        cleanNumJbt = new JButton("清空统计数据");
        cleanJButton = new JButton("清空文本打印数据");
        cleanAllJbt = new JButton("清空所有显示数据");

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

        // 路径标签和文本框
        this.add(jlExcelPath);
        this.add(jtfExcelPath);
        this.add(jlDirPath);
        this.add(jtfDirPath);

        // button
        this.add(cleanPathJbt);
        this.add(btReadExcel);
        this.add(btReadDir);
        this.add(btFindBySno);
        this.add(btFindBySname);

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

        this.add(cleanNumJbt);

        //
        this.add(btSaveNoStuToExcel);
        this.add(cleanJButton);
        this.add(cleanAllJbt);

        // this.add(jTextArea);
        this.add(jsp1);

        // 设置事件监听
        jtfExcelPath.addActionListener(new ActionListener() {

            /**
             * 文本框输入数据回车，触发事件，读Excel表格
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了jtfExcelPath的事件。");
                readExcel();
            }
        });

        btReadExcel.addActionListener(new ActionListener() {

            /**
             * 点击按钮，触发事件，读Excel表格
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了btReadExcel的事件。");
                readExcel();
            }
        });

        jtfDirPath.addActionListener(new ActionListener() {

            /**
             * 文本框输入数据回车，触发事件，读文件夹
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了jtfDirPath的事件。");
                readDir();
            }
        });

        btReadDir.addActionListener(new ActionListener() {

            /**
             * 点击按钮，触发事件，读文件夹
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了btReadDir的事件。");
                readDir();
            }
        });

        btFindBySname.addActionListener(new ActionListener() {

            /**
             * 点击按钮，触发事件，按照学生姓名进行检索
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                // 路径不为空才进行查找，否则返回错误信息
                boolean bool = judgePathIsNoNull();
                if (bool) {
                    jTextArea.setText("--按姓名进行查找文件\n");
                    sign = "sname";
                    btFindStuBySign(excelPath, dirPath, sign);
                } else {
                    jTextArea.setText("--查找失败，Excel或文件夹路径为空！！\n");
                }
            }
        });

        btFindBySno.addActionListener(new ActionListener() {

            /**
             * 点击按钮，触发事件，按照学号进行检索
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // 路径不为空才进行查找，否则返回错误信息
                boolean bool = judgePathIsNoNull();
                if (bool) {
                    jTextArea.setText("--按学号进行查找文件\n");
                    sign = "sno";
                    btFindStuBySign(excelPath, dirPath, sign);
                } else {
                    jTextArea.setText("--查找失败，Excel或文件夹路径为空！！\n");
                }
            }
        });

        btSaveNoStuToExcel.addActionListener(new ActionListener() {

            /**
             * 点击按钮，触发事件，将未检索到的学生信息写到Excel表格中
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // 路径不为空保存数据，否则返回错误信息
                boolean bool = judgePathIsNoNull();
                if (bool) {
                    String saveExcelPath = ExcelUtil.writeExcel(excelPath, noFoundStuList);
                    // 判空，显示保存信息
                    if (saveExcelPath != null) {
                        jTextArea.setText("----写数据到(" + saveExcelPath + ")成功。----\n");
                    }else {
                        System.err.println("----文件路径( " + excelPath + ") 不存在，保存数据到Excel失败！！");
                        jTextArea.setText("----文件路径( " + excelPath + ") 不存在，保存数据到Excel失败！！");
                    }
                } else {
                    jTextArea.setText("--保存数据失败，Excel或文件夹路径为空！！\n");
                }

            }
        });

        cleanPathJbt.addActionListener(new ActionListener() {

            /**
             * 清空路径文本框的内容
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanPath();
            }
        });

        cleanNumJbt.addActionListener(new ActionListener() {

            /**
             * 清空路径文本框的内容
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanNum();
            }
        });

        cleanJButton.addActionListener(new ActionListener() {

            /**
             * 清空文本域的内容
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanJta();
            }
        });

        cleanAllJbt.addActionListener(new ActionListener() {

            /**
             * 清空文本域的内容
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanPath();
                cleanNum();
                cleanJta();
            }
        });

    }

    // 下面这三个clean开头的函数用于清除显示数据
    public void cleanPath() {
        jtfExcelPath.setText("");
        jtfDirPath.setText("");
        setListToNull();
    }

    public void cleanNum() {
        jtfClassNo.setText("");
        jtfCurrentStuNo.setText("");
        jtfFileNo.setText("");
        jtfFindStuNo.setText("");
        jtfNoFindStuNo.setText("");
        jtfSpecialStuNo.setText("");
        setListToNull();
    }

    public void cleanJta() {
        jTextArea.setText("");
        setListToNull();
    }

    /**
     * 将列表置为空
     */
    public void setListToNull() {
        if (students != null) {
            students = null;
        }
        if (fileList != null) {
            fileList = null;
        }
    }

    /**
     * 读Excel表格
     */
    public void readExcel() {
        if (!"".equals(jtfExcelPath.getText())) {
            excelPath = jtfExcelPath.getText();
        } else {
            jtfExcelPath.setText(excelPath);
        }
        jTextArea.setText("--表格路径为:" + excelPath + "\n");

        ArrayList<Student>[] studentsArray = ExcelUtil.readExcel(excelPath);
        // 判断是否为空，如果为空，则表示文件不存在
        if (studentsArray != null) {
            students = studentsArray[0];
            ArrayList<Student> specialStudents = studentsArray[1];

            int studentSize = students.size();
            int specialStuNo = specialStudents.size();
            // 显示班级人数
            jtfClassNo.setText(String.valueOf(studentSize + specialStuNo));
            jtfSpecialStuNo.setText(String.valueOf(specialStuNo));
            jtfCurrentStuNo.setText(String.valueOf(studentSize));

            jTextArea.append("--扫描到的学生人数为:" + studentSize + "，学生信息如下：\n");
            System.out.println("--扫描Excel得到的学生人数为:" + studentSize + "，学生信息如下：");
            for (Student student : students) {
                System.out.println("  " + student.toString());
                jTextArea.append("  " + student.toString() + System.getProperty("line.separator"));
            }
        } else {
            jTextArea.append("--文件不存在、或者表格格式不正确，请检查后重新输入！！！");
            cleanNum();
        }

    }

    /**
     * 读文件夹
     */
    public void readDir() {

        if (!"".equals(jtfDirPath.getText())) {
            dirPath = jtfDirPath.getText();
        } else {
            jtfDirPath.setText(dirPath);
        }
        System.out.println("--文件夹路径为:" + dirPath + "\n");
        jTextArea.setText("--文件夹路径为:" + dirPath + "\n");

        fileList = FileUtil.readDir(dirPath);
        // 判断是否为空，如果为空，则表示文件不存在
        if (fileList != null) {
            int fileSize = fileList.size();
            // 显示文件数量
            jtfFileNo.setText(String.valueOf(fileSize));

            jTextArea.append("--扫描文件夹得到的文件数量为:" + fileSize + "，文件名如下：\n");
            System.out.println("--扫描文件夹得到的文件数量为:" + fileSize + "，文件名如下：");
            for (String string : fileList) {
                jTextArea.append("  " + string + System.getProperty("line.separator"));
            }
        } else {
            jTextArea.append("--文件不存在，请检查后重新输入！！！");
        }

    }

    /**
     * 通过标识查找学生
     * 
     * @param excelPath
     *            Excel路径
     * @param dirPath
     *            文件夹路径
     * @param sign
     *            标识
     */
    public void btFindStuBySign(String excelPath, String dirPath, String sign) {

        // 先判空，防止NPE问题，如果读取Excel或者文件夹失败就可能是空
        if (students == null || fileList == null) {
            jTextArea.append("--读取文件失败，请检查路径是否有误！！！");
            return;
        }

        // 先比较学生列表数量和文件夹内文件数量
        int classNum = students.size();
        int fileNum = fileList.size();
        String compareResult = null;
        if (classNum == fileNum) {
            compareResult = "文件数量和学生列表数量一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        } else {
            compareResult = "文件数量和学生列表数量不一致！" + "学生列表有" + classNum + "个学生，文件列表有" + fileNum + "个文件。";
        }
        System.out.println("compareResult:" + compareResult);

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
            System.out.println("  " + student.toString());
        }

        System.out.println("\n--2.未找到学生有 " + noStuNum + " 名，学生列表为：");
        for (Student student : noFoundStuList) {
            System.out.println("  " + student.toString());
        }

        jTextArea.append(compareResult + "\n");

        jTextArea.append("--1.已找到学生有 " + stuNum + " 名，学生列表为：\n");
        for (Student student : studentFindList) {
            // 获取原内容，增加换行符，再拼接list当前值
            jTextArea.append("  " + student.toString() + System.getProperty("line.separator"));
        }

        jTextArea.append("\n--2.未找到学生有 " + noStuNum + " 名，学生列表为：\n");
        for (Student student : noFoundStuList) {
            jTextArea.append("  " + student.toString() + System.getProperty("line.separator"));
        }
    }

    /**
     * 判断路径是否为空
     * 
     * @return true 非空，false 空
     */
    public boolean judgePathIsNoNull() {

        // 如果（excel或者文件夹）路径为空，返回false
        boolean result = ("".equals(jtfExcelPath.getText().trim())) || ("".equals(jtfDirPath.getText().trim()));

        return !result;
    }
}
