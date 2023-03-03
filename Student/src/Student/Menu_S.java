package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu_S {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;

	public static Student_Query student_query = null;
	
	public Menu_S() {
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

		JLabel title = new JLabel("学生信息查询修改");
		title.setBounds(130, 30, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);

		JButton jb1 = new JButton("我的基本信息");
		jpanel.add(jb1);
		jb1.setBounds(240, 130, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_query = new Student_Query();
				student_query.start();
				frame.dispose();
			}
		});

		JButton jb2 = new JButton("修改我的信息");
		jpanel.add(jb2);
		jb2.setBounds(240, 180, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Student_Change();
				frame.dispose();
			}
			
		});

		JButton jb3 = new JButton("我的获奖情况");
		jpanel.add(jb3);
		jb3.setBounds(240, 230, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Student_Query_RP();
				frame.dispose();
			}
			
		});

		JButton jb4 = new JButton("我的处分情况");
		jpanel.add(jb4);
		jb4.setBounds(240, 280, 120, 30);
		jb4.setFocusPainted(false);
		jb4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Student_Query_R();
				frame.dispose();
			}
			
		});
		
		JButton jb5 = new JButton("退出系统");
		jpanel.add(jb5);
		jb5.setBounds(240, 330, 120, 30);
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener() { // 设置返回登陆系统的按钮监听
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
}