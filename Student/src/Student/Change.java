package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Change {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Change(){
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
		
		JLabel title = new JLabel("ѧ��״̬����");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("�����п�", Font.BOLD, 40));
		jpanel.add(title);
		
		JTextArea jtf = new JTextArea("�����˶Ժ�ѧ��ѧ��״̬��������Ϊ��ѧ���ҵ����ǰ��ѧ����Ϣ����˵����������Ϣ��ɾ����");
		jpanel.add(jtf);
		jtf.setFont(new Font("����",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.red);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 100);
		
		JLabel jb1 = new JLabel("ѧ��         ��");
		jpanel.add(jb1);
		jb1.setBounds(50, 80, 80, 30);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		jtf1.setBounds(140, 80, 80, 25);
		
		JLabel jb3 = new JLabel("ѧ��״̬��");
		jb3.setBounds(50, 130, 80, 30);
		jpanel.add(jb3);
		String[] level ={"��ѧ","תϵ","��ѧ","��ҵ","��ѧ","��У"};
		JComboBox<String> jcb = new JComboBox<String>(level);
		jpanel.add(jcb);
		jcb.setBounds(140, 130, 80, 25);
		
		JButton btn1 = new JButton("�ύ");
		jpanel.add(btn1);
		btn1.setBounds(200, 290, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id_s = jtf1.getText().trim();
				String statement_s = jcb.getSelectedItem().toString();
				if (new ConnectDB().Query_id(id_s)) {
					String sql = "UPDATE STUDENT SET statement_s = '"+statement_s+"' WHERE id_s = '"+id_s+"'";
					if (new ConnectDB().change(sql)) {
						JOptionPane.showMessageDialog(null, "�ύ�ɹ���", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "ϵͳ����", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "�ύʧ�ܣ�û�����ѧ����", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
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