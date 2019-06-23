/**  
 * @Title WinListener.java
 * @Package com.ys.gui
 * @Description TODO
 * @author yansheng
 * @date 2019-06-23 21:41:16
 * @version v1.0
 */
package com.ys.gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-23 21:41:16
 * @version v1.0 
 */
public class WinListener implements ActionListener {

	JTextField jtfFileNo;
	JLabel jlExcel;
	JTextArea jTextArea;
	Button button;

	public JTextField getJtfFileNo() {
		return jtfFileNo;
	}

	public void setJtfFileNo(JTextField jtfFileNo) {
		this.jtfFileNo = jtfFileNo;
	}

	public JLabel getJlExcel() {
		return jlExcel;
	}

	public void setJlExcel(JLabel jlExcel) {
		this.jlExcel = jlExcel;
	}

	public JTextArea getjTextArea() {
		return jTextArea;
	}

	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	/**
	 * <p>Title: actionPerformed</p>
	 * <p>Description: </p>
	 * @param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String string = e.getActionCommand();
		System.out.println("e.getActionCommand():" + string);
		System.out.println("jtfFileNo:"+jtfFileNo.getText());
		
		
	}

}
