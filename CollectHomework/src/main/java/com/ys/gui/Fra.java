/**  
 * @Title ER.java
 * @Package gui.basic
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 11:37:23
 * @version v1.0
 */
package com.ys.gui;

import java.awt.Button;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 11:37:23
 * @version v1.0 
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Fra implements MouseMotionListener, MouseListener {
	private JFrame f;
	Button button;
	Button button1;

	public static void main(String args[]) {
		Fra ff = new Fra();
		ff.go();
	}

	public void go() {
		f = new JFrame("click");
		f.addMouseMotionListener(this);
//		f.addMouseListener(this);
		
//		button = new Button("按钮");
//		button1 = new Button("按钮2");
//		f.add(button);
//		f.add(button1);
		
		f.setSize(710, 710);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("拖拽了");
	}

	public void mouseMoved(MouseEvent e) {
		System.out.println("移动了");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("进入了");
	}

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("单击了");
	}

	public void mouseExited(MouseEvent arg0) {
		System.out.println("离开了");
	}

	public void mousePressed(MouseEvent arg0) {
		System.out.println("按下了");
	}

	public void mouseReleased(MouseEvent arg0) {
		System.out.println("松开了");
	}
}