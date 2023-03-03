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

public class Change_M {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Change_M(){
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
		
		JLabel title = new JLabel("教职工信息修改");
		title.setBounds(150, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("修改工号");
		jpanel.add(jb1);
		jb1.setBounds(240, 90, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override     //设置动作监听修改工号
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				boolean b = true;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新工号：\n","修改工号",JOptionPane.PLAIN_MESSAGE);
			    //进行输入格式的判断，防止恶意输入
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
				    		String sql = "UPDATE MANAGER SET id_m = "+str+"WHERE id_m ="+Welcome.id_m;
				    		flag = new ConnectDB().change_M(sql);
				    	}
				    	if(flag == 1){
				    		JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
				    		Welcome.id_m = str;
				    	}
				    	else if(flag == 0){
				    		JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				    	}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"工号格式错误！","通知",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
			
		});
		
		JButton jb2 = new JButton("修改名字");
		jpanel.add(jb2);
		jb2.setBounds(240, 150, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){
			@Override      //监听修改名字
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新名字：\n","修改名字",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE MANAGER SET name_m = '"+str+"'WHERE id_m = '"+Welcome.id_m+"'";
					flag = new ConnectDB().change_M(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb3 = new JButton("修改密码");
		jpanel.add(jb3);
		jb3.setBounds(240, 210, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){
			@Override       //监听修改密码
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"新密码：\n","修改密码",JOptionPane.PLAIN_MESSAGE);
			    if(str!=null){
				    if(str.trim().length() > 5 && str.trim().length() < 10){
				    	if(str!=null){
				    		String sql = "UPDATE MANAGER SET password_m = "+str+"WHERE id_m ="+Welcome.id_m;
				    		flag = new ConnectDB().change_M(sql);
				    	}
				    	if(flag == 1){
				    		JOptionPane.showMessageDialog(null,"修改成功！","通知",JOptionPane.INFORMATION_MESSAGE);
				    		Welcome.password_m = str;
				    	}
				    	else if(flag == 0){
				    		JOptionPane.showMessageDialog(null,"修改失败！","通知",JOptionPane.INFORMATION_MESSAGE);
				    	}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"修改失败！密码不能少于6位，多于十位！","通知",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
		});
		
		JButton jb8 = new JButton("返回主菜单");
		jpanel.add(jb8);
		jb8.setBounds(240, 280, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new Menu_M();
			}
		});
	}
}