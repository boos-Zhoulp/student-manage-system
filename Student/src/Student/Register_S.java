package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register_S {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	//static String id_s,sex_s,name_s,password_s,address_s,birth_s,class_s,department_s;
	
	public Register_S(){
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("ѧ��ע��ϵͳ");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JLabel jlb1 = new JLabel("ѧ��    ��");
		jpanel.add(jlb1);
		jlb1.setBounds(200, 60, 70, 50);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		//jtf1.addFocusListener(new JTextFieldHintListener(jtf1,"������10λѧ��"));
		jtf1.setBounds(250, 75, 120, 25);

		JLabel jlb2 = new JLabel("����    ��");
		jpanel.add(jlb2);
		jlb2.setVisible(true);
		jlb2.setBounds(200, 95, 100, 50);
		JPasswordField jpf = new JPasswordField(10);
		jpanel.add(jpf);
		jpf.setEchoChar('*');
		jpf.setBounds(250, 110, 120, 25);
		
		JLabel jlb3 = new JLabel("����    ��");
		jpanel.add(jlb3);
		jlb3.setBounds(200, 130, 70, 50);
		JTextField jtf3 = new JTextField(10);
		jpanel.add(jtf3);
		//jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"����������"));
		jtf3.setBounds(250, 145, 120, 25);
		
		JLabel jlb4 = new JLabel("�Ա�    ��");
		jpanel.add(jlb4);
		jlb4.setBounds(200, 165, 70, 50);
		JTextField jtf4 = new JTextField(10);
		jpanel.add(jtf4);
		//jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"�л�Ů"));
		jtf4.setBounds(250, 180, 120, 25);
		
		JLabel jlb7 = new JLabel("����    ��");
		jpanel.add(jlb7);
		jlb7.setBounds(200, 200, 70, 50);
		JTextField jtf7 = new JTextField(10);
		jpanel.add(jtf7);
		//jtf7.addFocusListener(new JTextFieldHintListener(jtf7,"�����뼮��"));
		jtf7.setBounds(250, 215, 120, 25);
		
		JLabel jlb5 = new JLabel("�༶����  ��");
		jpanel.add(jlb5);
		jlb5.setBounds(200, 270, 80, 50);
		String[] level2 ={"���һ��","�������","�������","�����ݿ�ѧ�뼼��һ��","�����ݿ�ѧ�뼼������","�����ݿ�ѧ�뼼������","�������ѧ�뼼��һ��","�������ѧ�뼼������","�������ѧ�뼼������","�������ѧ�뼼���İ�","�������ѧ�뼼�����","�Ӿ�����������һ��","����һ��","��ѧ������ѧһ��","��������ѧһ��","������һ��","��Ϣ��ȫһ��","����������","��Ϣ��ȫ����","��Ϣ��ȫ����",};
		JComboBox<String> jcb2 = new JComboBox<String>(level2);
		jpanel.add(jcb2);
		jcb2.setBounds(265, 283, 105, 25);
		
		JLabel jlb6 = new JLabel("����    ��");
		jpanel.add(jlb6);
		jlb6.setBounds(200, 235, 70, 50);
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
		mon1.setBounds(265, 250, 40, 25);
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
		day1.setBounds(305, 250, 40, 25);
		day1.setBorder(null);// �����ޱ߿�
		day1.setEditable(true);// ����������ɱ༭
		jpanel.add(day1);
		
		
		JLabel jlb8 = new JLabel("ѧԺ����  ��");
		jpanel.add(jlb8);
		jlb8.setBounds(200, 305, 80, 50);
		String[] level1 ={"�������ѧ�빤��ѧԺ","��ľ����ѧԺ","�����ѧԺ","��Դ�����밲ȫ����ѧԺ","���繤��ѧԺ","��Ϣ���������ѧԺ","��ѧ����ѧԺ","��ѧ������ѧѧԺ","������ѧѧԺ","��������ӿ�ѧѧԺ","�������������ѧԺ","����ѧԺ","���˼����ѧԺ","����ѧԺ","��ѧԺ","����ѧԺ","����ѧԺ","��ѧ�빫������ѧԺ","���Ͽ�ѧ�빤��ѧԺ","����ѧԺ"};
		JComboBox<String> jcb1 = new JComboBox<String>(level1);
		jpanel.add(jcb1);
		jcb1.setBounds(265, 318, 105, 25);
		
		JButton btn1 = new JButton("ע��");
		jpanel.add(btn1);
		btn1.setBounds(180, 365, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = true;
				// TODO Auto-generated method stub
				String id_s = jtf1.getText().trim();
				String name_s = jtf3.getText().trim();
				String password_s = jpf.getText().trim();
				String sex_s = jtf4.getText().trim();
				String class_s = jcb2.getSelectedItem().toString();
				String department_s = jcb1.getSelectedItem().toString();
				String address_s = jtf7.getText().trim();
				String birth_s = mon1.getSelectedItem().toString()+"��"+day1.getSelectedItem().toString()+"��";
				
				if(id_s.length() != 10){
					JOptionPane.showMessageDialog(null,"������ʮλ���֣�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(id_s.length() == 10){
					for(int i = 0;i < id_s.length(); i++){
						if(id_s.charAt(i) < '0' || id_s.charAt(i) > '9'){
							b = false;
							JOptionPane.showMessageDialog(null,"ѧ�ſ����������֣�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				if(password_s.length()>10 || password_s.length()<6){
					b = false;
					JOptionPane.showMessageDialog(null,"���벻�ܳ���ʮλ������������λ��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(name_s.length() > 30 || name_s.length() <= 0){
					JOptionPane.showMessageDialog(null,"���������֣����ܳ���30λ��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(!(sex_s.equals("��") || sex_s.equals("Ů"))){
					JOptionPane.showMessageDialog(null,"�������л�Ů��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				else if(address_s.length() > 30 || address_s.length() < 1){
					JOptionPane.showMessageDialog(null,"������סַ�����ܳ���30λ��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					b = false;
				}
				
				if(b){
					boolean flag = new ConnectDB().studentRegister(id_s, name_s, password_s, sex_s, class_s, department_s, address_s, birth_s);
					
					if(flag){
						JOptionPane.showMessageDialog(null,"ע��ɹ������½��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						frame.dispose();
						Welcome.music_Register.stop();
						new Welcome().start();
					}else{
						JOptionPane.showMessageDialog(null,"ϵͳ����","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JButton btn2 = new JButton("����");
		jpanel.add(btn2);
		btn2.setBounds(260, 365, 60, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtf1.setText("");
				jpf.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf7.setText("");
				
			}
		});
		
		JButton btn3 = new JButton("����");
		jpanel.add(btn3);
		btn3.setBounds(340, 365, 60, 30);
		btn3.setFocusPainted(false);
		btn3.addActionListener(new ActionListener() { // ���÷��ص�½ϵͳ�İ�ť����
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Welcome.music_Register.stop();
				new Welcome().start();
			}
		});
	}
}