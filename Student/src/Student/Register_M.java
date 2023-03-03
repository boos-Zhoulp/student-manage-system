package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register_M {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Register_M(){
		background = new ImageIcon(this.getClass().getResource("/images/bg3.jpg"));// 背景图片

		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// 把标签的大小位置设置为图片刚好填充整个面板
		jpanel = (JPanel) frame.getContentPane(); // 把内容窗格转化为JPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);

		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("教师注册系统");
		title.setBounds(170, 30, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JLabel jlb1 = new JLabel("工号    ：");
		jpanel.add(jlb1);
		jlb1.setBounds(200, 100, 70, 50);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		//jtf1.addFocusListener(new JTextFieldHintListener(jtf1,"请输入10位工号"));
		jtf1.setBounds(250, 115, 120, 25);

		JLabel jlb2 = new JLabel("密码    ：");
		jpanel.add(jlb2);
		jlb2.setVisible(true);
		jlb2.setBounds(200, 135, 100, 50);
		JPasswordField jpf = new JPasswordField(10);
		jpanel.add(jpf);
		//jpf.addFocusListener(new JTextFieldHintListener(jpf,"请输入10位以内密码"));
		jpf.setBounds(250, 150, 120, 25);
		
		JLabel jlb3 = new JLabel("姓名    ：");
		jpanel.add(jlb3);
		jlb3.setBounds(200, 170, 70, 50);
		JTextField jtf3 = new JTextField();
		jpanel.add(jtf3);
		//jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"请输入姓名"));
		jtf3.setBounds(250, 185, 120, 25);
		
		JLabel jlb4 = new JLabel("性别    ：");
		jpanel.add(jlb4);
		jlb4.setBounds(200, 205, 70, 50);
		JTextField jtf4 = new JTextField(10);
		jpanel.add(jtf4);
		//jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"男或女"));
		jtf4.setBounds(250, 220, 120, 25);
		
		JButton btn1 = new JButton("注册");
		jpanel.add(btn1);
		btn1.setBounds(180, 310, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean b = true;
				
				String name_m = jtf3.getText().toString().trim();
				String id_m = jtf1.getText().trim();
				String sex_m = jtf4.getText().trim();
				String password_m = jpf.getText().trim();

				if(id_m.length() != 10){
					JOptionPane.showMessageDialog(null,"请输入十位数字！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(id_m.length() == 10){
					for(int i = 0;i < id_m.length(); i++){
						if(id_m.charAt(i) < '0' || id_m.charAt(i) > '9'){
							b = false;
							JOptionPane.showMessageDialog(null,"学号框请输入数字！","通知",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				if(password_m.length()>10 || password_m.length()<6){
					b = false;
					JOptionPane.showMessageDialog(null,"密码不能超过十位！不能少于六位！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(name_m.length() > 30 || name_m.length() <= 0){
					JOptionPane.showMessageDialog(null,"请输入名字，不能超过30位！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(!(sex_m.equals("男") || sex_m.equals("女"))){
					JOptionPane.showMessageDialog(null,"请输入男或女！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				if(b){
					boolean flag = new ConnectDB().teacherRegister(name_m, password_m, id_m, sex_m);
					
					if(!flag){
						JOptionPane.showMessageDialog(null,"输入格式错误，请检查！","通知",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"注册成功，请登陆！","通知",JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Welcome.music_Register.stop();
						new Welcome().start();
					}
				}
			}
		});
		
		JButton btn2 = new JButton("重置");
		jpanel.add(btn2);
		btn2.setBounds(260, 310, 60, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtf1.setText("");
				jpf.setText("");
				jtf3.setText("");
				jtf4.setText("");
				
			}
		});
		
		JButton btn3 = new JButton("返回");
		jpanel.add(btn3);
		btn3.setBounds(340, 310, 60, 30);
		btn3.setFocusPainted(false);
		btn3.addActionListener(new ActionListener() { // 设置返回登陆系统的按钮监听
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Welcome.music_Register.stop();
				new Welcome().start();
			}
		});
		
	}
}

class JTextFieldHintListener implements FocusListener{

	private String hintText;
	private JTextField textField;
	
	public JTextFieldHintListener(JTextField jtf,String hintText){
		this.textField = jtf;
		this.hintText = hintText;
		jtf.setText(hintText);
		jtf.setForeground(Color.gray);
	}
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		String temp = textField.getText();
		if(temp.equals(hintText)){
			textField.setText("");
			textField.setForeground(Color.black);
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		String temp = textField.getText();
		if(temp.equals("")){
			textField.setForeground(Color.gray);
			textField.setText(hintText);
		}
	}
	
}