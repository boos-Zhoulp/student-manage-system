package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javazoom.jl.player.Player;

public class Welcome extends Thread{
	private JFrame frame = new JFrame("学生信息管理系统");
	private static JPanel jpanel  = null;
	private ImageIcon background;
	
	public static String name_m, password_m, id_m, sname, spassword;
	public static String name_s,id_s,password_s,sex_s,address_s,department_s,birth_s,class_s;
	public static Music_Register music_Register = null;
	
	public static ChangeColor test = null;

	public void run (){
		music_welcome = new Music();   //启动音乐线程
		music_welcome.start();
		background = new ImageIcon(this.getClass().getResource("/images/image1.gif"));// 背景图片

		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// 把标签的大小位置设置为图片刚好填充整个面板
		jpanel = (JPanel) frame.getContentPane(); // 把内容窗格转化为JPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
		
		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);

		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //设置关闭按钮
		frame.setVisible(true);
		
		jpanel.add(test);
		test.setBounds(85, 20, 400, 80);
		test.setLayout(null);
		test.setOpaque(false);
		
		Font font1 = new Font("宋体",Font.BOLD,12);
		
//		JLabel version = new JLabel("版权所有：@刘晨阳");   
//		jpanel.add(version);
//		version.setFont(font1);
//		version.setBounds(233, 350, 150, 30);
//		version.setVisible(true);
//		JLabel version1 = new JLabel("湖南科技大学计算机科学与工程学院");
//		jpanel.add(version1);
//		version1.setFont(font1);
//		version1.setBounds(183, 370, 240, 30);
//		version1.setVisible(true);
		
		JLabel jlb1 = new JLabel("学/工号：");
		jpanel.add(jlb1);
		jlb1.setFont(font1);
		jlb1.setBounds(180, 100, 100, 50);
		JTextField jtf = new JTextField(10);
		jpanel.add(jtf);
		jtf.setBounds(250, 115, 120, 25);

		JLabel jlb2 = new JLabel("密码   ：");
		jpanel.add(jlb2);
		jlb2.setFont(font1);
		jlb2.setVisible(true);
		jlb2.setBounds(180, 135, 100, 50);
		JPasswordField jpf = new JPasswordField(10);
		jpanel.add(jpf);
		jpf.setBounds(250, 150, 120, 25);

		JLabel jlb3 = new JLabel("用户类型：");
		jpanel.add(jlb3);
		jlb3.setFont(font1);
		jlb3.setBounds(185, 200, 80, 30);

		JRadioButton jrb1 = new JRadioButton("教师");
		jpanel.add(jrb1);
		jrb1.setFont(font1);
		jrb1.setOpaque(false);         //设置背景非透明
		jrb1.setBounds(255, 200, 60, 30);
		JRadioButton jrb2 = new JRadioButton("学生");
		jpanel.add(jrb2);
		jrb2.setFont(font1);
		jrb2.setOpaque(false);          
		jrb2.setBounds(315, 200, 70, 30);
		jrb1.setFocusPainted(false); // 去掉点击按钮时的边框
		jrb2.setFocusPainted(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrb2.setSelected(true); // 默认选中学生

		JButton jb1 = new JButton("登陆");
		jpanel.add(jb1);
		jb1.setFont(font1);
		jb1.setBackground(new Color(246, 246, 246));
//		jb1.setBorder(BorderFactory.createRaisedBevelBorder());
		//jb1.setForeground(Color.BLUE);
		jb1.setBounds(170, 260, 70, 30);
		jb1.setFocusPainted(false);
		// 设置学生登陆按钮的监听
		jb1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean b = false;
				if (jrb2.isSelected()) {
					if (e.getSource() == jb1) {
						id_s = jtf.getText();
						password_s = jpf.getText();
						try {
							b = new ConnectDB().studentLand(id_s, password_s);     //与数据库匹配进行学生验证
						} catch (Exception a) {
							a.printStackTrace();
						}
					}
					if (b == true) {
					    frame.dispose();
					    music_welcome.stop();
						new Menu_S();                //启动学生背景音乐线程
						new Music_S().start();
					} else {
						JOptionPane.showMessageDialog(null,"用户名或密码错误","通知",JOptionPane.INFORMATION_MESSAGE);
					}
				}

				boolean flag = false;
				if (jrb1.isSelected()) {
					if (e.getSource() == jb1) {
						id_m = jtf.getText().trim();         //得到文本框输入的学号/工号
						password_m = jpf.getText().trim();     //得到密码框的密码
						try {
							flag = new ConnectDB().teacherLand(id_m, password_m);   //进行登陆验证，与数据库进行匹配
						} catch (Exception t) {
							t.printStackTrace();
						}
					}
					if (flag == true) {
						new Menu_M();
						frame.dispose();
						music_welcome.stop();
						new Music_M().start();    //启动教职工背景音乐线程
	
					} else {
						JOptionPane.showMessageDialog(null,"用户名或密码错误","通知",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});

		JButton jb2 = new JButton("注册");    //注册按钮
		jpanel.add(jb2);
		jb2.setFont(font1);
		//jb2.setForeground(Color.BLUE);
		jb2.setBackground(new Color(246, 246, 246));
		jb2.setBounds(250, 260, 70, 30);
		jb2.setFocusPainted(false);
		//设置注册按钮的监听事件
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrb1.isSelected()) {
					if (e.getSource() == jb2) {
						new Register_M();    //启动教职工界面
					}
				}
				
				if(jrb2.isSelected()) {
					if(e.getSource() == jb2) {
						new Register_S();      //启动学生界面
					}
				}
				music_welcome.stop();
				music_Register = new Music_Register();
				music_Register.start();      //开启注册界面音乐线程
				frame.dispose();
			}
		});
		
		//退出按钮的监听
		JButton jb3 = new JButton("退出");
		jpanel.add(jb3);
		jb3.setFont(font1);
	//	jb3.setForeground(Color.BLUE);
		jb3.setBackground(new Color(246, 246, 246));
		jb3.setBounds(330, 260, 70, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener() { // 设置退出按钮的监听，退出系统
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	static Music music_welcome;
}

class Music extends Thread{            //多线程启动音乐线程，增加用户体验
	public void run(){
		File file = new File("src/爱在四月雪.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}

//流星雨背景音乐线程
class Music_S extends Thread{
	public void run(){
		File file = new File("src/A Little Story.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

//教职工音乐背景
class Music_M extends Thread{
	public void run(){
		File file = new File("src/Sleep Away.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

//学生界面背景音乐线程
class Music_Register extends Thread{
	public void run(){
		File file = new File("src/My Soul.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}


//登陆界面实现文字渐变
class ChangeColor extends JPanel implements Runnable{    //继承Runnable接口实现多线程

	private static final long serialVersionUID = 1L;

	Color color = new Color(0,0,255);
	public void paint(Graphics g){      //java GUI绘制2D图形和界面
		Graphics2D gp = (Graphics2D) g;  //获取一个Graphics对象
		String title = "学生信息管理系统";     //界面标题
		int x = 40;
		int y = 40;
		Font font = new Font("华文行楷", Font.PLAIN, 40);   //设置标题字体
		gp.setFont(font);            
		gp.setColor(color);
		gp.drawString(title, x, y);       //在画板上绘制标题
	}

	private static int a,b,c,flag = 1;
	@Override
	public void run() {   //重写run方法
		a=0;
		b=0;
		c=0;
		while(true){

			if(a<5){
				flag = 1;
			}
			else if(a > 200){
				c += 50;
				flag = 0;
			}
			if(flag == 0){
				a -= 5;
			}
			else{
				a += 5;
			}
			
			if(c > 200){
				c = 0;
			}
			int R = a;
			int G = a;
			int B = c;
			
			color = new Color(R,G,B);
			repaint();          //清除之前的画，重绘
			try{
				Thread.sleep(50);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}