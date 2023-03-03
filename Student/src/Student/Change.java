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
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public Change(){
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
		
		JLabel title = new JLabel("学籍状态更改");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JTextArea jtf = new JTextArea("请您核对好学生学籍状态，若更改为退学或毕业，请前往学生信息变更菜单进行相关信息的删除！");
		jpanel.add(jtf);
		jtf.setFont(new Font("隶书",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.red);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 100);
		
		JLabel jb1 = new JLabel("学号         ：");
		jpanel.add(jb1);
		jb1.setBounds(50, 80, 80, 30);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		jtf1.setBounds(140, 80, 80, 25);
		
		JLabel jb3 = new JLabel("学籍状态：");
		jb3.setBounds(50, 130, 80, 30);
		jpanel.add(jb3);
		String[] level ={"休学","转系","复学","毕业","退学","在校"};
		JComboBox<String> jcb = new JComboBox<String>(level);
		jpanel.add(jcb);
		jcb.setBounds(140, 130, 80, 25);
		
		JButton btn1 = new JButton("提交");
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
						JOptionPane.showMessageDialog(null, "提交成功！", "通知", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "系统错误！", "通知", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "提交失败！没有这个学生！", "通知", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		JButton btn2 = new JButton("返回");
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