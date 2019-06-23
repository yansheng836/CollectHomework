/**  
 * @Title SimpleTest2.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 17:54:20
 * @version v1.0
 */
package com.ys.gui;

/**
 * <p>Title: </p>
 * <p>Description: ModifiedFlowLayout</p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 17:54:20
 * @version v1.0 
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
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

class ModifiedFlowLayout extends FlowLayout {
	public ModifiedFlowLayout() {
		super();
	}

	public ModifiedFlowLayout(int align) {
		super(align);
	}

	public ModifiedFlowLayout(int align, int hgap, int vgap) {
		super(align, hgap, vgap);
	}

	public Dimension minimumLayoutSize(Container target) {
		return computeSize(target, false);
	}

	public Dimension preferredLayoutSize(Container target) {
		return computeSize(target, true);
	}

	private Dimension computeSize(Container target, boolean minimum) {
		synchronized (target.getTreeLock()) {
			int hgap = getHgap();
			int vgap = getVgap();
			int w = target.getWidth();
			if (w == 0) {
				w = Integer.MAX_VALUE;
			}
			Insets insets = target.getInsets();
			if (insets == null) {
				insets = new Insets(0, 0, 0, 0);
			}
			int reqdWidth = 0;
			int maxwidth = w - (insets.left + insets.right + hgap * 2);
			int n = target.getComponentCount();
			int x = 0;
			int y = insets.top;
			int rowHeight = 0;
			for (int i = 0; i < n; i++) {
				Component c = target.getComponent(i);
				if (c.isVisible()) {
					Dimension d = minimum ? c.getMinimumSize() : c.getPreferredSize();
					if ((x == 0) || ((x + d.width) <= maxwidth)) {
						if (x > 0) {
							x += hgap;
						}
						x += d.width;
						rowHeight = Math.max(rowHeight, d.height);
					} else {
						x = d.width;
						y += vgap + rowHeight;
						rowHeight = d.height;
					}
					reqdWidth = Math.max(reqdWidth, x);
				}
			}
			y += rowHeight;
			return new Dimension(reqdWidth + insets.left + insets.right, y);
		}
	}
}

public class SimpleTest2 extends JFrame {
	private ImageIcon image;
	private JLabel label;
	private JButton button;
	private JPanel buttonPanel, imagePanel;
	private JScrollPane scrollPane;

	public SimpleTest2(int xPixels, int yPixels) {
		super("Add Image");
		button = new JButton("Add Image");
		button.setPreferredSize(new Dimension(80, 25));
		button.setMargin(new Insets(0, 5, 0, 5));
		image = new ImageIcon("C:\\Users\\yansheng\\Pictures\\Saved Pictures\\huge.jpg");
		imagePanel = new JPanel(new ModifiedFlowLayout(FlowLayout.LEFT, 5, 5));
		scrollPane = new JScrollPane(imagePanel);

		imagePanel.setPreferredSize(new Dimension(xPixels, yPixels));
		// 这是关键的2句 //
		scrollPane.setPreferredSize(new Dimension(xPixels, yPixels));
		button.addActionListener(new ActionListener() {
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
		new SimpleTest2(320, 400);
	}
}
