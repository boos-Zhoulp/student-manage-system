package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register_S {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	//static String id_s,sex_s,name_s,password_s,address_s,birth_s,class_s,department_s;
	
	public Register_S(){
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
		
		JLabel title = new JLabel("学生注册系统");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JLabel jlb1 = new JLabel("学号    ：");
		jpanel.add(jlb1);
		jlb1.setBounds(200, 60, 70, 50);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		//jtf1.addFocusListener(new JTextFieldHintListener(jtf1,"请输入10位学号"));
		jtf1.setBounds(250, 75, 120, 25);

		JLabel jlb2 = new JLabel("密码    ：");
		jpanel.add(jlb2);
		jlb2.setVisible(true);
		jlb2.setBounds(200, 95, 100, 50);
		JPasswordField jpf = new JPasswordField(10);
		jpanel.add(jpf);
		jpf.setEchoChar('*');
		jpf.setBounds(250, 110, 120, 25);
		
		JLabel jlb3 = new JLabel("姓名    ：");
		jpanel.add(jlb3);
		jlb3.setBounds(200, 130, 70, 50);
		JTextField jtf3 = new JTextField(10);
		jpanel.add(jtf3);
		//jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"请输入姓名"));
		jtf3.setBounds(250, 145, 120, 25);
		
		JLabel jlb4 = new JLabel("性别    ：");
		jpanel.add(jlb4);
		jlb4.setBounds(200, 165, 70, 50);
		JTextField jtf4 = new JTextField(10);
		jpanel.add(jtf4);
		//jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"男或女"));
		jtf4.setBounds(250, 180, 120, 25);
		
		JLabel jlb7 = new JLabel("籍贯    ：");
		jpanel.add(jlb7);
		jlb7.setBounds(200, 200, 70, 50);
		JTextField jtf7 = new JTextField(10);
		jpanel.add(jtf7);
		//jtf7.addFocusListener(new JTextFieldHintListener(jtf7,"请输入籍贯"));
		jtf7.setBounds(250, 215, 120, 25);
		
		JLabel jlb5 = new JLabel("班级名称  ：");
		jpanel.add(jlb5);
		jlb5.setBounds(200, 270, 80, 50);
		String[] level2 ={"软件一班","软件二班","软件三班","大数据科学与技术一班","大数据科学与技术二班","大数据科学与技术三班","计算机科学与技术一班","计算机科学与技术二班","计算机科学与技术三班","计算机科学与技术四班","计算机科学与技术五班","视觉传达与艺术一班","音乐一班","数学与计算科学一班","汉语言文学一班","物联网一班","信息安全一班","物联网二班","信息安全二班","信息安全三班",};
		JComboBox<String> jcb2 = new JComboBox<String>(level2);
		jpanel.add(jcb2);
		jcb2.setBounds(265, 283, 105, 25);
		
		JLabel jlb6 = new JLabel("生日    ：");
		jpanel.add(jlb6);
		jlb6.setBounds(200, 235, 70, 50);
		/* 月下拉框 */
		Vector<String> mm = new Vector<String>();
		for (int i = 1; i <= 12; i++) {
			String s1 = "";
			if (i < 10) {
				s1 = '0' + Integer.toString(i);
			} else {
				s1 = Integer.toString(i);
			}
			mm.add(s1);
		}
		JComboBox mon1 = new JComboBox(mm);
		mon1.setBounds(265, 250, 40, 25);
		mon1.setBorder(null);// 设置无边框
		mon1.setEditable(true);// 设置下拉框可编辑
		jpanel.add(mon1);
		/*****************/
	 
		/* 日下拉框 */
		Vector<String> dd = new Vector<String>();
		for (int i = 1; i <= 31; i++) {
			String s1 = "";
			if (i < 10) {
				s1 = '0' + Integer.toString(i);
			} else {
				s1 = Integer.toString(i);
			}
			dd.add(s1);
		}
		JComboBox day1 = new JComboBox(dd);
		day1.setBounds(305, 250, 40, 25);
		day1.setBorder(null);// 设置无边框
		day1.setEditable(true);// 设置下拉框可编辑
		jpanel.add(day1);
		
		
		JLabel jlb8 = new JLabel("学院名称  ：");
		jpanel.add(jlb8);
		jlb8.setBounds(200, 305, 80, 50);
		String[] level1 ={"计算机科学与工程学院","土木工程学院","外国语学院","资源环境与安全工程学院","机电工程学院","信息与电气工程学院","化学化工学院","数学与计算科学学院","生命科学学院","物理与电子科学学院","建筑与艺术设计学院","人文学院","马克思主义学院","教育学院","商学院","艺术学院","体育学院","法学与公共管理学院","材料科学与工程学院","潇湘学院"};
		JComboBox<String> jcb1 = new JComboBox<String>(level1);
		jpanel.add(jcb1);
		jcb1.setBounds(265, 318, 105, 25);
		
		JButton btn1 = new JButton("注册");
		jpanel.add(btn1);
		btn1.setBounds(180, 365, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = true;
				// TODO Auto-generated method stub
				String id_s = jtf1.getText().trim();
				String name_s = jtf3.getText().trim();
				String password_s = jpf.getText().trim();
				String sex_s = jtf4.getText().trim();
				String class_s = jcb2.getSelectedItem().toString();
				String department_s = jcb1.getSelectedItem().toString();
				String address_s = jtf7.getText().trim();
				String birth_s = mon1.getSelectedItem().toString()+"月"+day1.getSelectedItem().toString()+"日";
				
				if(id_s.length() != 10){
					JOptionPane.showMessageDialog(null,"请输入十位数字！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(id_s.length() == 10){
					for(int i = 0;i < id_s.length(); i++){
						if(id_s.charAt(i) < '0' || id_s.charAt(i) > '9'){
							b = false;
							JOptionPane.showMessageDialog(null,"学号框请输入数字！","通知",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				if(password_s.length()>10 || password_s.length()<6){
					b = false;
					JOptionPane.showMessageDialog(null,"密码不能超过十位！不能少于六位！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(name_s.length() > 30 || name_s.length() <= 0){
					JOptionPane.showMessageDialog(null,"请输入名字，不能超过30位！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(!(sex_s.equals("男") || sex_s.equals("女"))){
					JOptionPane.showMessageDialog(null,"请输入男或女！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(address_s.length() > 30 || address_s.length() < 1){
					JOptionPane.showMessageDialog(null,"请输入住址，不能超过30位！","通知",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				
				if(b){
					boolean flag = new ConnectDB().studentRegister(id_s, name_s, password_s, sex_s, class_s, department_s, address_s, birth_s);
					
					if(flag){
						JOptionPane.showMessageDialog(null,"注册成功！请登陆！","通知",JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						frame.dispose();
						Welcome.music_Register.stop();
						new Welcome().start();
					}else{
						JOptionPane.showMessageDialog(null,"系统出错！","通知",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JButton btn2 = new JButton("重置");
		jpanel.add(btn2);
		btn2.setBounds(260, 365, 60, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtf1.setText("");
				jpf.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf7.setText("");
				
			}
		});
		
		JButton btn3 = new JButton("返回");
		jpanel.add(btn3);
		btn3.setBounds(340, 365, 60, 30);
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