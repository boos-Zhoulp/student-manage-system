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
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;

	public static Student_Query student_query = null;
	
	public Menu_S() {
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

		JLabel title = new JLabel("ѧ����Ϣ��ѯ�޸�");
		title.setBounds(130, 30, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);

		JButton jb1 = new JButton("�ҵĻ�����Ϣ");
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

		JButton jb2 = new JButton("�޸��ҵ���Ϣ");
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

		JButton jb3 = new JButton("�ҵĻ����");
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

		JButton jb4 = new JButton("�ҵĴ������");
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
		
		JButton jb5 = new JButton("�˳�ϵͳ");
		jpanel.add(jb5);
		jb5.setBounds(240, 330, 120, 30);
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener() { // ���÷��ص�½ϵͳ�İ�ť����
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
}