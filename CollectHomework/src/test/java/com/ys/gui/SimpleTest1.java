/**  
 * @Title SimpleTest1.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 17:49:21
 * @version v1.0
 */
package com.ys.gui;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 17:49:21
 * @version v1.0 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SimpleTest1 extends JFrame {
	private ImageIcon image;
	private JLabel label;
	private JButton button;
	private JPanel buttonPanel, imagePanel;
	private JScrollPane scrollPane;

	public SimpleTest1(int xPixels, int yPixels) {
		super("Add Image");
		button = new JButton("Add Image");
		button.setPreferredSize(new Dimension(80, 25));
		button.setMargin(new Insets(0, 5, 0, 5));
		image = new ImageIcon("C:\\Users\\yansheng\\Pictures\\Saved Pictures\\huge.jpg");
		imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		scrollPane = new JScrollPane(imagePanel);
		imagePanel.setPreferredSize(new Dimension(xPixels, yPixels));
		// 这是关键的2句
		scrollPane.setPreferredSize(new Dimension(xPixels, yPixels));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label = new JLabel(image);
				imagePanel.add(label);
				validate();
			}
		});
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		buttonPanel.add(button);
		add(buttonPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		setSize(xPixels, yPixels);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleTest1(320, 400);
	}
}
