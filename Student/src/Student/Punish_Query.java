package Student;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Punish_Query {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Punish_Query(){
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
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel title = new JLabel("处分信息查询");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		

		DefaultTableModel table = new DefaultTableModel();
		table.setColumnIdentifiers(new Object[]{"学号","姓名","班级","学院","奖项","级别","时间"});
		
		new ConnectDB().reward_Query(table);
		
		JTable jt = new JTable(table);
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(10,40,560,300);
		jpanel.add(jsp);
	}
}