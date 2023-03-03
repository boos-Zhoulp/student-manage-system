package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Student_Change {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Student_Change(){
		background = new ImageIcon(this.getClass().getResource("/images/bg5.jpg"));// ����ͼƬ

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
		
		JLabel title = new JLabel("ѧ����Ϣ�޸�");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("�޸�ѧ��");
		jpanel.add(jb1);
		jb1.setBounds(230, 70, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
				boolean b =true;
			    str = JOptionPane.showInputDialog(null,"��ѧ�ţ�\n","�޸�ѧ��",JOptionPane.PLAIN_MESSAGE);
			    if(str != null){
				    if(str.length() != 10){
						JOptionPane.showMessageDialog(null,"������ʮλ���֣�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
						b = false;
					}
					else if(str.length() == 10){
						for(int i = 0;i < str.length(); i++){
							if(str.charAt(i) < '0' || str.charAt(i) > '9'){
								b = false;
								JOptionPane.showMessageDialog(null,"ѧ�ſ����������֣�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}
					}
				    if(b){
						if(str!=null){
							String sql = "UPDATE STUDENT SET id_s = "+str+"WHERE id_s ="+Welcome.id_s;
							flag = new ConnectDB().student_Change(sql);
						}
						if(flag == 1){
							JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
							Welcome.id_s = str;
						}
						else if(flag == 0){
							JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
						}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"�޸�ʧ��!ѧ�Ÿ�ʽ����","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
			
		});
		
		JButton jb2 = new JButton("�޸�����");
		jpanel.add(jb2);
		jb2.setBounds(230, 110, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�����֣�\n","�޸�����",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET name_s = '"+str+"'WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.name_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb3 = new JButton("�޸�����");
		jpanel.add(jb3);
		jb3.setBounds(230, 150, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�����룺\n","�޸�����",JOptionPane.PLAIN_MESSAGE);
			    if(str != null){
				    if(str.length() > 5 && str.length() <11){
				    	
						if(str!=null){
							String sql = "UPDATE STUDENT SET password_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"';";
							flag = new ConnectDB().student_Change(sql);
						}
						if(flag == 1){
							JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
							Welcome.password_s = str;
						}
						else if(flag == 0){
							JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
						}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ������ʽ����","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
		});
		
		JButton jb4 = new JButton("�޸İ༶");
		jpanel.add(jb4);
		jb4.setBounds(230, 190, 120, 30);
		jb4.setFocusPainted(false);
		jb4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�°༶��\n","�޸İ༶",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET class_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.class_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb5 = new JButton("�޸�Ժϵ");
		jpanel.add(jb5);
		jb5.setBounds(230, 230, 120, 30);
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"��Ժϵ��\n","�޸�Ժϵ",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET department_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.department_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb6 = new JButton("�޸�סַ");
		jpanel.add(jb6);
		jb6.setBounds(230, 270, 120, 30);
		jb6.setFocusPainted(false);
		jb6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"��סַ��\n","�޸�סַ",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET address_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.address_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb7 = new JButton("�޸�����");
		jpanel.add(jb7);
		jb7.setBounds(230, 310, 120, 30);
		jb7.setFocusPainted(false);
		jb7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�����գ�\n","�޸�����",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE STUDENT SET birth_s = '"+str+"' WHERE id_s = '"+Welcome.id_s+"'";
					flag = new ConnectDB().student_Change(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
					//Welcome.birth_s = str;
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb8 = new JButton("���ز˵�");
		jpanel.add(jb8);
		jb8.setBounds(230, 350, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new Menu_S();
			}
		});
	}
}