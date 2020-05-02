package com.moqi.qq;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register extends JFrame{
	public static void main(String arg[]){
		new Register();
	}
	JLabel yhm=new JLabel("用户名:");
	JTextField t_yhm=new JTextField(18);
	JLabel mm=new JLabel("密	         码:");
	JTextField t_mm=new JTextField(18);
	JLabel qrmm=new JLabel("确认密码:");
	JTextField t_qrmm=new JTextField(18);
	JLabel xx=new JLabel("性别           :");
	JRadioButton r1=new JRadioButton("男");
	JRadioButton r2=new JRadioButton("女");
	JLabel lxfs=new JLabel("联系方式ʽ:");
	JTextField t_lxfs=new JTextField(18);
	JLabel xk=new JLabel("选修课程");
	JCheckBox c1=new JCheckBox("C语音");
	JCheckBox c2=new JCheckBox("Java");
	JCheckBox c3=new JCheckBox("Android");
	JButton b1=new JButton("注册");
	JButton b2=new JButton("重置");
	RegisterController rc = new RegisterController(this);
	Register()
	{
		b1.addActionListener(rc);
		this.setTitle("注册");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane=this.getContentPane();
		pane.setLayout(new GridLayout(7,1));
		//����û���
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));	
		p1.add(yhm);p1.add(t_yhm);
		//����
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));	
		p2.add(mm);p2.add(t_mm);
		//ȷ������
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));	
		p3.add(qrmm);p3.add(t_qrmm);
		//�Ա�
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));	
		ButtonGroup g=new ButtonGroup();
		g.add(r1);g.add(r2);
		p4.add(xx);p4.add(r1);p4.add(r2);
		//��ϵ��ʽ
		JPanel p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));	
		p5.add(lxfs);p5.add(t_lxfs);
		//ѡ��
		JPanel p6=new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));	
		p6.add(xk);p6.add(c1);p6.add(c2);p6.add(c3);
		//��ť
		JPanel p7=new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));	
		p7.add(b1);p7.add(b2);
		pane.add(p1);
		pane.add(p2);
		pane.add(p3);
		pane.add(p4);
		pane.add(p5);
		pane.add(p6);
		pane.add(p7);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}


}
