package com.moqi.qq;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sun.swing.*;

public class RegisterController implements ActionListener{
	Register r;
	RegisterController(Register r){
		this.r=r;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==r.b1) {
				String username = r.t_yhm.getText();
				String password = r.t_mm.getText();
				
				write(username,password);
				r.dispose();
				new MyFrame();
			}
		if(e.getSource()==r.b2) {
					
			}
	}
	

 public void write(String name, String pass) {
	 File f  = new File("user.txt");
	 try {
		FileWriter fw = new FileWriter(f,true);
		fw.write(name+"#"+pass+"\n");
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
 }
 }