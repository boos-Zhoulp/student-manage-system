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

public class Punish_S {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Punish_S(){
		background = new ImageIcon(this.getClass().getResource("/images/bg3.jpg"));// 背景图片

		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());// 把标签的大小位置设置为图片刚好填充整个面板
		jpanel = (JPanel) frame.getContentPane(); // 把内容窗格转化为JPanel
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

		jpanel.setOpaque(false);
		jpanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);
		
		frame.setBounds(350, 100, 600, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("学生处分统计表");
		title.setBounds(180, 5, 300, 30);
		title.setFont(new Font("隶书", Font.BOLD, 30));
		jpanel.add(title);
		title.setVisible(true);
		
		DefaultTableModel table = new DefaultTableModel();
		table.setColumnIdentifiers(new Object[]{"学号","姓名","班级","学院","处分名称","级别","时间"});
		
		new ConnectDB().punish_Query(table);
		
		JTable jt = new JTable(table);
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(10,40,565,220);
		jpanel.add(jsp);
		
		JButton btn1 = new JButton("返回主菜单");
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