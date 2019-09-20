package com.ys.gui;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author yansheng
 * @date 2019/07/01
 */
public class TestMouseEvent implements MouseMotionListener, MouseListener {
    private JFrame jFrame;
    JButton jButton;
    int i;

    public static void main(String args[]) {
        TestMouseEvent testMouseEvent = new TestMouseEvent();
        testMouseEvent.init();
    }

    public void init() {
        jFrame = new JFrame("click");
        // 设置布局
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        jButton = new JButton("会走的按钮");
        jButton.setBounds(30, 30, 60, 60);
        // jButton.addMouseListener(l);
        jButton.addMouseMotionListener(this);
        jFrame.add(jButton);

        // jFrame.addMouseMotionListener(this);
        // f.addMouseListener(this);

        // button = new Button("按钮");
        // button1 = new Button("按钮2");
        // f.add(button);
        // f.add(button1);

        // jFrame.setSize(710, 710);
        jFrame.setBounds(400, 400, 400, 400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("拖拽了");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("移动了");
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        double jfWidth = jFrame.getBounds().getWidth();
        double jfHeight = jFrame.getBounds().getHeight();
        double btWidth = jButton.getBounds().getWidth();
        double btHeight = jButton.getBounds().getHeight();
        double btX = jButton.getBounds().getCenterX();
        double btY = jButton.getBounds().getCenterY();

        for (i = 0; i < 100; i++) {
            if (btWidth + btX > jfWidth) {
                i = 0;
            }
            jButton.setBounds(40 + i, 40 + i, 40 + i, 40 + i);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("进入了");
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("单击了");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        System.out.println("离开了");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        System.out.println("按下了");
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        System.out.println("松开了");
    }
}