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
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public static Reward_S reward_s= null;
	
	public Menu_M(){
		background = new ImageIcon(this.getClass().getResource("/images/bg2.jpg"));// ����ͼƬ

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

		JLabel title = new JLabel("����ѧ����Ϣϵͳ");
		title.setBounds(115, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("�޸�ѧ����Ϣ");
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

		JButton jb2 = new JButton("������Ϣ��ѯ");
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

		JButton jb3 = new JButton("������Ϣ��ѯ");
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

		JButton jb4 = new JButton("ѧ����Ϣ��ѯ");
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
		
		JButton jb5 = new JButton("�޸ĸ�����Ϣ");
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
		
		JButton jb6 = new JButton("ѧԺ��Ϣ��ѯ");
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
		
		JButton jb7 = new JButton("�༶��Ϣ��ѯ");
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
		
		JButton jb8 = new JButton("�˳�ϵͳ");
		jpanel.add(jb8);
		jb8.setBounds(240, 350, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener() { // �����˳���ť�ļ������˳�ϵͳ
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}