/**  
 * @Title BtReadDirListener.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 11:54:51
 * @version v1.0
 */
package com.ys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 11:54:51
 * @version v1.0 
 */
public class BtReadDirListener implements ActionListener {

	// 显示结果
	JTextArea jTextArea;

	public JTextArea getjTextArea() {
		return jTextArea;
	}

	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

	/**
	 * <p>Title: actionPerformed</p>
	 * <p>Description: </p>
	 * @param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		jTextArea.setText("");
		jTextArea.append("here is BtReadDirListener.");
		System.out.println("ActionEvent:"+e);
	}

}
