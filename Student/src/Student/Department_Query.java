package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Department_Query {
	private JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Department_Query(){
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
		
		JLabel title = new JLabel("ѧԺ��Ϣ��");
		title.setBounds(220, 5, 300, 30);
		title.setFont(new Font("����", Font.BOLD, 30));
		jpanel.add(title);
		title.setVisible(true);
		
		DefaultTableModel table = new DefaultTableModel();
		table.setColumnIdentifiers(new Object[]{"���","����","Ժ��","ѧУ"});
		new ConnectDB().department_Query(table);
		
		JTable jt = new JTable(table);
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(10,40,560,220);
		jpanel.add(jsp);
		
		JButton btn1 = new JButton("�������˵�");
		jpanel.add(btn1);
		btn1.setBounds(230, 350, 140, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				frame.dispose();
				new Menu_M();
			}
		});
	}
}