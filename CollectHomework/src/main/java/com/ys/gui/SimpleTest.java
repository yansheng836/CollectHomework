/**  
 * @Title SimpleTest.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 17:45:58
 * @version v1.0
 */
package com.ys.gui;

/**
 * <p>Title: </p>
 * <p>Description: https://blog.csdn.net/iteye_19871/article/details/81766585</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 17:45:58
 * @version v1.0 
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SimpleTest extends JFrame {
	private ImageIcon image;
	private JLabel label;
	private JButton button;
	private JPanel buttonPanel, imagePanel;
	private JScrollPane scrollPane;
	private Container container;

	public SimpleTest(int xPixels, int yPixels) {
		super("Add Image");
		button = new JButton("Add Image");
		image = new ImageIcon("C:\\Users\\yansheng\\Pictures\\Saved Pictures\\huge.jpg");
		imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		scrollPane = new JScrollPane(imagePanel);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label = new JLabel(image);
				imagePanel.add(label);
				validate();
			}
		});
		buttonPanel = new JPanel(new GridLayout(1, 5));
		buttonPanel.add(button);
		container = getContentPane();
		container.setLayout(new GridLayout(2, 1));
		container.add(buttonPanel);
		container.add(scrollPane);
		setSize(xPixels, yPixels);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleTest(400, 400);
	}
}
