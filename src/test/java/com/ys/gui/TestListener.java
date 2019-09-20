package com.ys.gui;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 测试如何设置事件监听
 * 
 * @author yansheng
 * @date 2019/06/23
 */
public class TestListener {

    public static void main(String[] args) {
        JFram win = new JFram();
        win.setBounds(400, 200, 1100, 600);
        win.setTitle("按钮");
    }

}

class JFram extends JFrame {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    JTextField jtfFileNo;
    JLabel jlExcel;
    JTextArea jTextArea;
    Button button;

    public JFram() {
        init();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {

        Container container = this.getContentPane();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        container.setLayout(flowLayout);

        jlExcel = new JLabel("请输入表格路径：");
        jlExcel.setFont(new Font("宋体", Font.BOLD, 25));

        jtfFileNo = new JTextField(4);
        jtfFileNo.setFont(new Font("宋体", Font.BOLD, 23));

        container.add(jlExcel);
        container.add(jtfFileNo);

        jTextArea = new JTextArea(4, 10);
        jTextArea.setFont(new Font("宋体", Font.BOLD, 23));
        container.add(jTextArea);

        button = new Button("nihao");
        button.setFont(new Font("宋体", Font.BOLD, 23));
        // WinListener winListener = new WinListener();
        // winListener.setJtfFileNo(jtfFileNo);
        // button.addActionListener(winListener);

        container.add(button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String string = e.getActionCommand();
                System.out.println("e.getActionCommand():" + string);
                System.out.println("jtfFileNo:" + jtfFileNo.getText());
                JOptionPane.showMessageDialog(container, (Object)"你好", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //
        jtfFileNo.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                // 有焦点变成无焦点
                System.out.println("\n\n有焦点变成无焦点");
                System.out.println("e:" + e);
                System.out.println("内容为：" + jtfFileNo.getText());
                String returnString = jtfFileNo.getText();
                if (returnString != null) {
                    System.out.println("returnString非空");
                }
                if ("".equals(returnString)) {
                    System.out.println("returnString为空字符串");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                // 无焦点变成有焦点
                System.out.println("\n\n无焦点变成有焦点");
                System.out.println("e:" + e);
                System.out.println("内容为：" + jtfFileNo.getText());
                String returnString = jtfFileNo.getText();
                if (returnString != null) {
                    System.out.println("returnString非空");
                }
                if ("".equals(returnString)) {
                    System.out.println("returnString为空字符串");
                }
            }
        });

        jtfFileNo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 无焦点变成有焦点
                System.out.println("\n\nActionListener");
                System.out.println("e:" + e);
                System.out.println("内容为：" + jtfFileNo.getText());
                String returnString = jtfFileNo.getText();
                if (returnString != null) {
                    System.out.println("returnString非空");
                }
                if ("".equals(returnString)) {
                    System.out.println("returnString为空字符串");
                }

            }
        });

    }

}
