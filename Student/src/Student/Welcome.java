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
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private static JPanel jpanel  = null;
	private ImageIcon background;
	
	public static String name_m, password_m, id_m, sname, spassword;
	public static String name_s,id_s,password_s,sex_s,address_s,department_s,birth_s,class_s;
	public static Music_Register music_Register = null;
	
	public static ChangeColor test = null;

	public void run (){
		music_welcome = new Music();   //���������߳�
		music_welcome.start();
		background = new ImageIcon(this.getClass().getResource("/images/image1.gif"));// ����ͼƬ

		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		jpanel = (JPanel) frame.getContentPane(); // �����ݴ���ת��ΪJPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		
		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);

		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���ùرհ�ť
		frame.setVisible(true);
		
		jpanel.add(test);
		test.setBounds(85, 20, 400, 80);
		test.setLayout(null);
		test.setOpaque(false);
		
		Font font1 = new Font("����",Font.BOLD,12);
		
//		JLabel version = new JLabel("��Ȩ���У�@������");   
//		jpanel.add(version);
//		version.setFont(font1);
//		version.setBounds(233, 350, 150, 30);
//		version.setVisible(true);
//		JLabel version1 = new JLabel("���ϿƼ���ѧ�������ѧ�빤��ѧԺ");
//		jpanel.add(version1);
//		version1.setFont(font1);
//		version1.setBounds(183, 370, 240, 30);
//		version1.setVisible(true);
		
		JLabel jlb1 = new JLabel("ѧ/���ţ�");
		jpanel.add(jlb1);
		jlb1.setFont(font1);
		jlb1.setBounds(180, 100, 100, 50);
		JTextField jtf = new JTextField(10);
		jpanel.add(jtf);
		jtf.setBounds(250, 115, 120, 25);

		JLabel jlb2 = new JLabel("����   ��");
		jpanel.add(jlb2);
		jlb2.setFont(font1);
		jlb2.setVisible(true);
		jlb2.setBounds(180, 135, 100, 50);
		JPasswordField jpf = new JPasswordField(10);
		jpanel.add(jpf);
		jpf.setBounds(250, 150, 120, 25);

		JLabel jlb3 = new JLabel("�û����ͣ�");
		jpanel.add(jlb3);
		jlb3.setFont(font1);
		jlb3.setBounds(185, 200, 80, 30);

		JRadioButton jrb1 = new JRadioButton("��ʦ");
		jpanel.add(jrb1);
		jrb1.setFont(font1);
		jrb1.setOpaque(false);         //���ñ�����͸��
		jrb1.setBounds(255, 200, 60, 30);
		JRadioButton jrb2 = new JRadioButton("ѧ��");
		jpanel.add(jrb2);
		jrb2.setFont(font1);
		jrb2.setOpaque(false);          
		jrb2.setBounds(315, 200, 70, 30);
		jrb1.setFocusPainted(false); // ȥ�������ťʱ�ı߿�
		jrb2.setFocusPainted(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrb2.setSelected(true); // Ĭ��ѡ��ѧ��

		JButton jb1 = new JButton("��½");
		jpanel.add(jb1);
		jb1.setFont(font1);
		jb1.setBackground(new Color(246, 246, 246));
//		jb1.setBorder(BorderFactory.createRaisedBevelBorder());
		//jb1.setForeground(Color.BLUE);
		jb1.setBounds(170, 260, 70, 30);
		jb1.setFocusPainted(false);
		// ����ѧ����½��ť�ļ���
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
							b = new ConnectDB().studentLand(id_s, password_s);     //�����ݿ�ƥ�����ѧ����֤
						} catch (Exception a) {
							a.printStackTrace();
						}
					}
					if (b == true) {
					    frame.dispose();
					    music_welcome.stop();
						new Menu_S();                //����ѧ�����������߳�
						new Music_S().start();
					} else {
						JOptionPane.showMessageDialog(null,"�û������������","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					}
				}

				boolean flag = false;
				if (jrb1.isSelected()) {
					if (e.getSource() == jb1) {
						id_m = jtf.getText().trim();         //�õ��ı��������ѧ��/����
						password_m = jpf.getText().trim();     //�õ�����������
						try {
							flag = new ConnectDB().teacherLand(id_m, password_m);   //���е�½��֤�������ݿ����ƥ��
						} catch (Exception t) {
							t.printStackTrace();
						}
					}
					if (flag == true) {
						new Menu_M();
						frame.dispose();
						music_welcome.stop();
						new Music_M().start();    //������ְ�����������߳�
	
					} else {
						JOptionPane.showMessageDialog(null,"�û������������","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});

		JButton jb2 = new JButton("ע��");    //ע�ᰴť
		jpanel.add(jb2);
		jb2.setFont(font1);
		//jb2.setForeground(Color.BLUE);
		jb2.setBackground(new Color(246, 246, 246));
		jb2.setBounds(250, 260, 70, 30);
		jb2.setFocusPainted(false);
		//����ע�ᰴť�ļ����¼�
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrb1.isSelected()) {
					if (e.getSource() == jb2) {
						new Register_M();    //������ְ������
					}
				}
				
				if(jrb2.isSelected()) {
					if(e.getSource() == jb2) {
						new Register_S();      //����ѧ������
					}
				}
				music_welcome.stop();
				music_Register = new Music_Register();
				music_Register.start();      //����ע����������߳�
				frame.dispose();
			}
		});
		
		//�˳���ť�ļ���
		JButton jb3 = new JButton("�˳�");
		jpanel.add(jb3);
		jb3.setFont(font1);
	//	jb3.setForeground(Color.BLUE);
		jb3.setBackground(new Color(246, 246, 246));
		jb3.setBounds(330, 260, 70, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener() { // �����˳���ť�ļ������˳�ϵͳ
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	static Music music_welcome;
}

class Music extends Thread{            //���߳����������̣߳������û�����
	public void run(){
		File file = new File("src/��������ѩ.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}

//�����걳�������߳�
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

//��ְ�����ֱ���
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

//ѧ�����汳�������߳�
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


//��½����ʵ�����ֽ���
class ChangeColor extends JPanel implements Runnable{    //�̳�Runnable�ӿ�ʵ�ֶ��߳�

	private static final long serialVersionUID = 1L;

	Color color = new Color(0,0,255);
	public void paint(Graphics g){      //java GUI����2Dͼ�κͽ���
		Graphics2D gp = (Graphics2D) g;  //��ȡһ��Graphics����
		String title = "ѧ����Ϣ����ϵͳ";     //�������
		int x = 40;
		int y = 40;
		Font font = new Font("�����п�", Font.PLAIN, 40);   //���ñ�������
		gp.setFont(font);            
		gp.setColor(color);
		gp.drawString(title, x, y);       //�ڻ����ϻ��Ʊ���
	}

	private static int a,b,c,flag = 1;
	@Override
	public void run() {   //��дrun����
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
			repaint();          //���֮ǰ�Ļ����ػ�
			try{
				Thread.sleep(50);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}