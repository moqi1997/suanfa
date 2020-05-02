package com.moqi.qq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JOptionPane;

public class LoginController implements ActionListener {
	MyFrame f;
	LoginController(MyFrame f){
		this.f = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==f.b2) {
			f.dispose();
			new Register();
		}
		if(e.getSource()==f.b) {
			String name = f.t.getText();
			String pass = f.pass.getText();
			if(read(name,pass)) {
				JOptionPane.showMessageDialog(f, "注册成功");
				f.dispose();
				new Main(); 
			}
			else {
				JOptionPane.showMessageDialog(f, "注册失败");
			}
		}
	}
	public boolean read(String name,String pass) {
		File  f = new File("user.txt");
		FileReader fr=null;
		BufferedReader br =null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				String userInfo[]= line.split("#");
				if(name.equals(userInfo[0])&&pass.equals(userInfo[1])) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
		
	}
}
