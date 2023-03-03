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
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public void run(){
		background = new ImageIcon(this.getClass().getResource("/images/bg7.jpg"));// ����ͼƬ

		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		jpanel = (JPanel) frame.getContentPane(); // �����ݴ���ת��ΪJPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);
		
		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("�ҵ���Ϣ");
		title.setBounds(220, 20, 300, 30);
		title.setFont(new Font("����", Font.BOLD, 30));
		jpanel.add(title);
		title.setVisible(true);
		
		String[] str = new String[8];
		new ConnectDB().student_Query(str);
		JLabel jlb1 = new JLabel("ѧ�ţ�");
		jpanel.add(jlb1);
		jlb1.setBounds(50, 80, 80, 30);
		JLabel jlb2 = new JLabel(str[0]);
		jpanel.add(jlb2);
		jlb2.setBounds(90, 80, 140, 30);
		
		JLabel jlb3 = new JLabel("������");
		jpanel.add(jlb3);
		jlb3.setBounds(50, 110, 80, 30);
		JLabel jlb4 = new JLabel(str[1]);
		jpanel.add(jlb4);
		jlb4.setBounds(90, 110, 140, 30);
		
		JLabel jlb5 = new JLabel("���룺");
		jpanel.add(jlb5);
		jlb5.setBounds(50, 140, 80, 30);
		JLabel jlb6 = new JLabel(str[2]);
		jpanel.add(jlb6);
		jlb6.setBounds(90, 140, 140, 30);
		
		JLabel jlb7 = new JLabel("�Ա�");
		jpanel.add(jlb7);
		jlb7.setBounds(50, 170, 80, 30);
		JLabel jlb8 = new JLabel(str[3]);
		jpanel.add(jlb8);
		jlb8.setBounds(90, 170, 140, 30);
		
		JLabel jlb9 = new JLabel("ѧԺ��");
		jpanel.add(jlb9);
		jlb9.setBounds(50, 200, 80, 30);
		JLabel jlb10 = new JLabel(str[4]);
		jpanel.add(jlb10);
		jlb10.setBounds(90, 200, 140, 30);
		
		JLabel jlb11 = new JLabel("סַ��");
		jpanel.add(jlb11);
		jlb11.setBounds(50, 230, 80, 30);
		JLabel jlb12 = new JLabel(str[5]);
		jpanel.add(jlb12);
		jlb12.setBounds(90, 230, 160, 30);
		
		JLabel jlb13 = new JLabel("���գ�");
		jpanel.add(jlb13);
		jlb13.setBounds(50, 260, 80, 30);
		JLabel jlb14 = new JLabel(str[6]);
		jpanel.add(jlb14);
		jlb14.setBounds(90, 260, 140, 30);
		
		JLabel jlb15 = new JLabel("�༶��");
		jpanel.add(jlb15);
		jlb15.setBounds(50, 290, 80, 30);
		JLabel jlb16 = new JLabel(str[7]);
		jpanel.add(jlb16);
		jlb16.setBounds(90, 290, 140, 30);
		
		Random random = new Random();
		int t = random.nextInt(7);
		String[] string = {"��������յ����䣬��Ҳ���ܴ�����յ��ճ�������ƽ�����̬���������õ��������Դ�ÿһ�죬ÿһ�춼��������⣬������ϣ��������Ŷ��\n                 -tips",
				"ѧ�᲻Ϊ���̵Ļ��������ǣ���ʹ��ʱδ��������Ը����ֻҪ����Ŭ��������ڲ��ϳɳ���                                                   -tips",
				"����ú�ѧϰ���𣿼���Ŷ��                                                    -tips",
				"��ѧʵѧ����ս�߿�;�������ϣ��ɾ����ҡ�                                                   -tips",
				"�ֹ�һ�㣬����΢Ц�ɣ����޵������ܵв��������������̬��                                                         -tips ",
				"��������һֻ����ޣ���Ͷ���ÿһ��Ŭ����������δ����ĳһ�죬�������㡣������Ҫ���ģ�����ÿ���Ŭ��һ��㣬����һ���!                    -tips",
				"�κ�ʱ���㶼���Կ�ʼ���Լ��������£�ֻҪ�㲻���������������ȥ�����Լ���ÿ�������ж���һƬ�����Լ����﷫��û�˰���������Ŭ���������������õ��Լ���                                                           -tips"};
		JTextArea jtf = new JTextArea(string[t]);
		jpanel.add(jtf);
		jtf.setFont(new Font("����",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.orange);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 170);
		
		JButton btn1 = new JButton("����ѧ���˵�");
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
		
		JButton btn2 = new JButton("�޸ĸ�����Ϣ");
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