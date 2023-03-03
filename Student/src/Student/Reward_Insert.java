package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Reward_Insert {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	private String time_s, id_s, description_s, level_s;
	
	public static int record_s = 0;
	
	public Reward_Insert(){
		background = new ImageIcon(this.getClass().getResource("/images/bg3.jpg"));// ����ͼƬ

		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		jpanel = (JPanel) frame.getContentPane(); // �����ݴ���ת��ΪJPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);

		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("������Ϣ¼��");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JTextArea jtf = new JTextArea("��������Դ�ѧ��������Ϣ��������д����ѧ����ѧУ������ȷ����������ύ��ť��");
		jpanel.add(jtf);
		jtf.setFont(new Font("����",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.red);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 100);
		
		JLabel jb1 = new JLabel("ѧ��  ��");
		jpanel.add(jb1);
		jb1.setBounds(50, 80, 60, 30);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		jtf1.setBounds(140, 80, 80, 25);
		
		
		JLabel jb2 = new JLabel("��������");
		jpanel.add(jb2);
		jb2.setBounds(50, 130, 60, 30);
		JTextField jtf2 = new JTextField();
		jpanel.add(jtf2);
		jtf2.setBounds(140, 130, 80, 25);
		
		
		JLabel jb3 = new JLabel("����ʱ��");
		jb3.setBounds(50, 180, 60, 30);
		jpanel.add(jb3);
		/* �������� */
		Vector<String> yy = new Vector<String>();
		for (int i = 2010; i <= 2021; i++) {
			yy.add(Integer.toString(i));
		}
		JComboBox year1 = new JComboBox(yy);
		year1.setBounds(120, 183, 51, 20);
		year1.setBorder(null);// �����ޱ߿�
		year1.setEditable(true);// ����������ɱ༭
		jpanel.add(year1);
		/*******************/
		/* �������� */
		Vector<String> mm = new Vector<String>();
		for (int i = 1; i <= 12; i++) {
			String s1 = "";
			if (i < 10) {
				s1 = '0' + Integer.toString(i);
			} else {
				s1 = Integer.toString(i);
			}
			mm.add(s1);
		}
		JComboBox mon1 = new JComboBox(mm);
		mon1.setBounds(171, 183, 40, 20);
		mon1.setBorder(null);// �����ޱ߿�
		mon1.setEditable(true);// ����������ɱ༭
		jpanel.add(mon1);
		/*****************/
	 
		/* �������� */
		Vector<String> dd = new Vector<String>();
		for (int i = 1; i <= 31; i++) {
			String s1 = "";
			if (i < 10) {
				s1 = '0' + Integer.toString(i);
			} else {
				s1 = Integer.toString(i);
			}
			dd.add(s1);
		}
		JComboBox day1 = new JComboBox(dd);
		day1.setBounds(211, 183, 40, 20);
		day1.setBorder(null);// �����ޱ߿�
		day1.setEditable(true);// ����������ɱ༭
		jpanel.add(day1);
		
		JLabel jb4 = new JLabel("����");
		jpanel.add(jb4);
		jb4.setBounds(50, 230, 60, 30);
		String[] level ={"Ժ��","У��","�м�","ʡ��","���Ҽ�"};
		JComboBox jcb = new JComboBox(level);
		jpanel.add(jcb);
		jcb.setBounds(140, 230, 80, 25);
		
		JButton btn1 = new JButton("�ύ");
		jpanel.add(btn1);
		btn1.setBounds(200, 290, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//record_s = Integer.valueOf(jtf1.getText().trim());
				id_s = jtf1.getText().trim();
				description_s = jtf2.getText().trim();
				time_s = year1.getSelectedItem().toString()+"��"+mon1.getSelectedItem().toString()+"��"+day1.getSelectedItem().toString()+"��";
				level_s = jcb.getSelectedItem().toString();
				
				if(new ConnectDB().Query_id(id_s)){
					
					record_s = new ConnectDB().count_R()+1;
				
					String sql = "INSERT INTO REWARD (record_s,id_s,time_s,description_s,level_s) VALUES ('" +record_s+"','"+id_s+"','"+ time_s + "','"+description_s+"','"+level_s+"');";
					if(new ConnectDB().reward_Insert(sql)){
						JOptionPane.showMessageDialog(null,"�ύ�ɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"�ύʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�ύʧ�ܣ�û�����ѧ����","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		JButton btn2 = new JButton("����");
		jpanel.add(btn2);
		btn2.setBounds(340, 290, 60, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Change_Student();
			}
		});
	}
}