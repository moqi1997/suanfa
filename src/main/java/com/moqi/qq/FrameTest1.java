package com.moqi.qq;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameTest1 {

	public static void main(String[] args) {
		new MyFrame();   //??????????????
	}

}
class MyFrame extends JFrame {
	String username;   //?????
	String userpass;	//????
	ImageIcon ii = new ImageIcon("D:\\project\\suanfa\\src\\main\\resources\\IMG\\活动图.jpeg");
	ImageIcon ii1 = new ImageIcon("D:\\project\\suanfa\\src\\main\\resources\\IMG\\999.png");
	ImageIcon ii2 = new ImageIcon("D:\\project\\suanfa\\src\\main\\resources\\IMG\\图片6.png");
	ImageIcon logo = new ImageIcon("D:\\project\\suanfa\\src\\main\\resources\\IMG\\logo.jpg");
	JCheckBox cb1 = new JCheckBox("自动登录");
	JCheckBox cb2 = new JCheckBox("记住密码");
	JButton b = new JButton("登录");
	JButton b2 = new JButton("注册");
	JLabel l = new JLabel(ii);
	JPanel p = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();
	JLabel l1 = new JLabel(ii1);
	JLabel l2 = new JLabel(ii2);
	JTextField t = new JTextField(10);
	JPasswordField pass = new JPasswordField(10);

	LoginController C = new LoginController(this);
	MyFrame(){
		this("123456","123456");
	}
	MyFrame(String name,String pass){
		username = name;
		userpass = pass;
		b.addActionListener(C);
		b2.addActionListener(C);
		b.setPreferredSize(new Dimension(150,25));
		this.setIconImage(logo.getImage());
		this.setTitle("QQ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(429,330);
		this.setResizable(false);
		this.setLayout(new GridLayout(2,1));
		p.setLayout(new GridLayout(4,1));
	
		p11.add(l1); p11.add(t);

		p12.add(l2); p12.add(this.pass);
		
	
		JPanel p13 = new JPanel();
		p13.add(b);

		JPanel p14 = new JPanel();
		p14.add(cb1);p14.add(cb2);p14.add(b2);
		p.add(p11);
		p.add(p11);
		p.add(p12);
		p.add(p13);
		p.add(p14);
		this.add(l);
		this.add(p);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		
	}
	
}

