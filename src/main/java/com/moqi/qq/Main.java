package com.moqi.qq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {
	public static void main(String[] args) {
		new Main();
	}
	JMenuBar bar = new JMenuBar();
	JMenu m1 = new JMenu("文件");
	JMenuItem i1 = new JMenuItem("新建");
	JMenuItem i2 = new JMenuItem("删除");
	JMenuItem i3 = new JMenuItem("打开");
	JMenuItem i4 = new JMenuItem("退出");

	Main(){

		this.setJMenuBar(bar);
		bar.add(m1);
		m1.add(i1);m1.add(i2);m1.add(i3);m1.addSeparator();m1.add(i4);
		this.setTitle("登录");
		this.setVisible(true);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);  //���ô��ڵ����λ��
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
