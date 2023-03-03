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

public class Change_M {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Change_M(){
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
		
		JLabel title = new JLabel("��ְ����Ϣ�޸�");
		title.setBounds(150, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton jb1 = new JButton("�޸Ĺ���");
		jpanel.add(jb1);
		jb1.setBounds(240, 90, 120, 30);
		jb1.setFocusPainted(false);
		jb1.addActionListener(new ActionListener(){

			@Override     //���ö��������޸Ĺ���
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				boolean b = true;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�¹��ţ�\n","�޸Ĺ���",JOptionPane.PLAIN_MESSAGE);
			    //���������ʽ���жϣ���ֹ��������
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
				    		String sql = "UPDATE MANAGER SET id_m = "+str+"WHERE id_m ="+Welcome.id_m;
				    		flag = new ConnectDB().change_M(sql);
				    	}
				    	if(flag == 1){
				    		JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    		Welcome.id_m = str;
				    	}
				    	else if(flag == 0){
				    		JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    	}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"���Ÿ�ʽ����","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
			
		});
		
		JButton jb2 = new JButton("�޸�����");
		jpanel.add(jb2);
		jb2.setBounds(240, 150, 120, 30);
		jb2.setFocusPainted(false);
		jb2.addActionListener(new ActionListener(){
			@Override      //�����޸�����
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�����֣�\n","�޸�����",JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					String sql = "UPDATE MANAGER SET name_m = '"+str+"'WHERE id_m = '"+Welcome.id_m+"'";
					flag = new ConnectDB().change_M(sql);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(flag == 0){
					JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton jb3 = new JButton("�޸�����");
		jpanel.add(jb3);
		jb3.setBounds(240, 210, 120, 30);
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener(){
			@Override       //�����޸�����
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
			    str = JOptionPane.showInputDialog(null,"�����룺\n","�޸�����",JOptionPane.PLAIN_MESSAGE);
			    if(str!=null){
				    if(str.trim().length() > 5 && str.trim().length() < 10){
				    	if(str!=null){
				    		String sql = "UPDATE MANAGER SET password_m = "+str+"WHERE id_m ="+Welcome.id_m;
				    		flag = new ConnectDB().change_M(sql);
				    	}
				    	if(flag == 1){
				    		JOptionPane.showMessageDialog(null,"�޸ĳɹ���","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    		Welcome.password_m = str;
				    	}
				    	else if(flag == 0){
				    		JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    	}
				    }
				    else{
				    	JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ����벻������6λ������ʮλ��","֪ͨ",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			}
		});
		
		JButton jb8 = new JButton("�������˵�");
		jpanel.add(jb8);
		jb8.setBounds(240, 280, 120, 30);
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new Menu_M();
			}
		});
	}
}