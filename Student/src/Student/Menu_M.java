package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu_M {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public static Reward_S reward_s= null;
	
	public Menu_M(){
		background = new ImageIcon(this.getClass().getResource("/images/bg2.jpg"));// 背景图片

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

		JLabel title = new JLabel("教务处学生信息系统");
		title.setBounds(115, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("修改学生信息");
		jpanel.add(jb1);
		jb1.setBounds(240, 270, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Change_Student();
				frame.dispose();
			}
			
		});

		JButton jb2 = new JButton("奖励信息查询");
		jpanel.add(jb2);
		jb2.setBounds(240, 110, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reward_s = new Reward_S();
				reward_s.start();
				frame.dispose();
			}
			
		});

		JButton jb3 = new JButton("处分信息查询");
		jpanel.add(jb3);
		jb3.setBounds(240, 150, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Punish_S();
				frame.dispose();
			}
			
		});

		JButton jb4 = new JButton("学生信息查询");
		jpanel.add(jb4);
		jb4.setBounds(240, 70, 120, 30);
		jb4.setFocusPainted(false);
		jb4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Teacher_Query();
				frame.dispose();
			}
		});
		
		JButton jb5 = new JButton("修改个人信息");
		jpanel.add(jb5);
		jb5.setBounds(240, 310, 120, 30);
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Change_M();
				frame.dispose();
			}
		});
		
		JButton jb6 = new JButton("学院信息查询");
		jpanel.add(jb6);
		jb6.setBounds(240, 230, 120, 30);
		jb6.setFocusPainted(false);
		jb6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Department_Query();
				frame.dispose();
			}
		});
		
		JButton jb7 = new JButton("班级信息查询");
		jpanel.add(jb7);
		jb7.setBounds(240, 190, 120, 30);
		jb7.setFocusPainted(false);
		jb7.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Class_Query();
				frame.dispose();
			}
			
		});
		
		JButton jb8 = new JButton("退出系统");
		jpanel.add(jb8);
		jb8.setBounds(240, 350, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener() { // 设置退出按钮的监听，退出系统
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}