package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Student_Change {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Student_Change(){
		background = new ImageIcon(this.getClass().getResource("/images/bg5.jpg"));// 背景图片

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
		
		JLabel title = new JLabel("学生信息修改");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("修改学号");
		jpanel.add(jb1);
		jb1.setBounds(230, 70, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
				boolean b =true;
			    str = JOptionPane.showInputDialog(null,"新学号：\n","修改学号",JOptionPane.PLAIN_MESSAGE);
			    if(str != null){
				    if(str.length() != 10){
						JOptionPane.showMessageDialog(null,"请输入十位数字！","通知",JOptionPane.INFORMATION_MESSAGE);
						b = false;
					}
					else if(str.length() == 10){
						for(int i = 0;i < str.length(); i++){
							if(str.charAt(i) < '0' || str.charAt(i) > '9'){
								b = false;
								JOptionPane.showMessageDialog(null,"学号框请输入数字！","通知",JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}
					}
				    if(b){
						if(str!=null){
							String sql = "UPDATE STUDENT SET id_s = "+str+"WHERE id_s ="+Welcome.id_s;
							flag = new ConnectDB().student_Change(sql);
						}
						if(flag == 1){
							JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
							Welcome.id_s = str;
						}
						else if(flag == 0){
							JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
						}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"修改失败!学号格式错误！","通知",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
			
		});
		
		JButton jb2 = new JButton("修改名字");
		jpanel.add(jb2);
		jb2.setBounds(230, 110, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新名字：\n","修改名字",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET name_s = '"+str+"'WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.name_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb3 = new JButton("修改密码");
		jpanel.add(jb3);
		jb3.setBounds(230, 150, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新密码：\n","修改密码",JOptionPane.PLAIN_MESSAGE);
			    if(str != null){
				    if(str.length() > 5 && str.length() <11){
				    	
						if(str!=null){
							String sql = "UPDATE STUDENT SET password_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"';";
							flag = new ConnectDB().student_Change(sql);
						}
						if(flag == 1){
							JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
							Welcome.password_s = str;
						}
						else if(flag == 0){
							JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
						}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"修改失败！密码格式错误！","通知",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
		});
		
		JButton jb4 = new JButton("修改班级");
		jpanel.add(jb4);
		jb4.setBounds(230, 190, 120, 30);
		jb4.setFocusPainted(false);
		jb4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新班级：\n","修改班级",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET class_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.class_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb5 = new JButton("修改院系");
		jpanel.add(jb5);
		jb5.setBounds(230, 230, 120, 30);
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新院系：\n","修改院系",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET department_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.department_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb6 = new JButton("修改住址");
		jpanel.add(jb6);
		jb6.setBounds(230, 270, 120, 30);
		jb6.setFocusPainted(false);
		jb6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新住址：\n","修改住址",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET address_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.address_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb7 = new JButton("修改生日");
		jpanel.add(jb7);
		jb7.setBounds(230, 310, 120, 30);
		jb7.setFocusPainted(false);
		jb7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新生日：\n","修改生日",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET birth_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.birth_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb8 = new JButton("返回菜单");
		jpanel.add(jb8);
		jb8.setBounds(230, 350, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new Menu_S();
			}
		});
	}
}