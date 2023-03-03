package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Student_Query extends Thread{
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public void run(){
		background = new ImageIcon(this.getClass().getResource("/images/bg7.jpg"));// 背景图片

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
		
		JLabel title = new JLabel("我的信息");
		title.setBounds(220, 20, 300, 30);
		title.setFont(new Font("隶书", Font.BOLD, 30));
		jpanel.add(title);
		title.setVisible(true);
		
		String[] str = new String[8];
		new ConnectDB().student_Query(str);
		JLabel jlb1 = new JLabel("学号：");
		jpanel.add(jlb1);
		jlb1.setBounds(50, 80, 80, 30);
		JLabel jlb2 = new JLabel(str[0]);
		jpanel.add(jlb2);
		jlb2.setBounds(90, 80, 140, 30);
		
		JLabel jlb3 = new JLabel("姓名：");
		jpanel.add(jlb3);
		jlb3.setBounds(50, 110, 80, 30);
		JLabel jlb4 = new JLabel(str[1]);
		jpanel.add(jlb4);
		jlb4.setBounds(90, 110, 140, 30);
		
		JLabel jlb5 = new JLabel("密码：");
		jpanel.add(jlb5);
		jlb5.setBounds(50, 140, 80, 30);
		JLabel jlb6 = new JLabel(str[2]);
		jpanel.add(jlb6);
		jlb6.setBounds(90, 140, 140, 30);
		
		JLabel jlb7 = new JLabel("性别：");
		jpanel.add(jlb7);
		jlb7.setBounds(50, 170, 80, 30);
		JLabel jlb8 = new JLabel(str[3]);
		jpanel.add(jlb8);
		jlb8.setBounds(90, 170, 140, 30);
		
		JLabel jlb9 = new JLabel("学院：");
		jpanel.add(jlb9);
		jlb9.setBounds(50, 200, 80, 30);
		JLabel jlb10 = new JLabel(str[4]);
		jpanel.add(jlb10);
		jlb10.setBounds(90, 200, 140, 30);
		
		JLabel jlb11 = new JLabel("住址：");
		jpanel.add(jlb11);
		jlb11.setBounds(50, 230, 80, 30);
		JLabel jlb12 = new JLabel(str[5]);
		jpanel.add(jlb12);
		jlb12.setBounds(90, 230, 160, 30);
		
		JLabel jlb13 = new JLabel("生日：");
		jpanel.add(jlb13);
		jlb13.setBounds(50, 260, 80, 30);
		JLabel jlb14 = new JLabel(str[6]);
		jpanel.add(jlb14);
		jlb14.setBounds(90, 260, 140, 30);
		
		JLabel jlb15 = new JLabel("班级：");
		jpanel.add(jlb15);
		jlb15.setBounds(50, 290, 80, 30);
		JLabel jlb16 = new JLabel(str[7]);
		jpanel.add(jlb16);
		jlb16.setBounds(90, 290, 140, 30);
		
		Random random = new Random();
		int t = random.nextInt(7);
		String[] string = {"错过了昨日的日落，再也不能错过今日的日出，保持平衡的心态，以最美好的心情来对待每一天，每一天都会充满阳光，洋溢着希望。加油哦！\n                 -tips",
				"学会不为过程的缓慢而焦虑，即使暂时未能如你所愿，但只要你在努力，你就在不断成长！                                                   -tips",
				"今天好好学习了吗？加油哦！                                                    -tips",
				"乐学实学，挑战高考;勤勉向上，成就自我。                                                   -tips",
				"乐观一点，用力微笑吧！隐晦的日子总敌不过我们阳光的心态。                                                         -tips ",
				"人生就像一只储蓄罐，你投入的每一分努力，都会在未来的某一天，回馈于你。而我们要做的，就是每天多努力一点点，进步一点点!                    -tips",
				"任何时候你都可以开始做自己想做的事，只要你不用年龄和其他东西去束缚自己，每个人心中都有一片海，自己不扬帆，没人帮你启航，努力，就能遇见更好的自己！                                                           -tips"};
		JTextArea jtf = new JTextArea(string[t]);
		jpanel.add(jtf);
		jtf.setFont(new Font("隶书",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.orange);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 170);
		
		JButton btn1 = new JButton("返回学生菜单");
		jpanel.add(btn1);
		btn1.setBounds(40, 340, 120, 30);
		//btn1.setOpaque(false);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Menu_S();
				frame.dispose();
				Menu_S.student_query.stop();
			}
		});
		
		JButton btn2 = new JButton("修改个人信息");
		jpanel.add(btn2);
		btn2.setBounds(180, 340, 120, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Student_Change();
				frame.dispose();
				Menu_S.student_query.stop();
			}
		});
	}
}