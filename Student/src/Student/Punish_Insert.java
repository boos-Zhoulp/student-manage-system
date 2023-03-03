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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Punish_Insert {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	private static int record_s = 0;
	
	public Punish_Insert(){
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
		
		JLabel title = new JLabel("处分信息录入");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JTextArea jtf = new JTextArea("请您认真对待学生处分信息，记录将跟随学生进入档案，请认真填写，对学生和学校负责，在确认无误后点击提交按钮！");
		jpanel.add(jtf);
		jtf.setFont(new Font("宋体",Font.PLAIN,16));
		jtf.setLineWrap(true);
		jtf.setOpaque(false);
		jtf.setForeground(Color.red);
		jtf.setWrapStyleWord(true);
		jtf.setEditable(false);
		jtf.setBounds(320, 100, 200, 100);
		
		JLabel jb1 = new JLabel("学号 ");
		jpanel.add(jb1);
		jb1.setBounds(50, 80, 60, 30);
		JTextField jtf1 = new JTextField(10);
		jpanel.add(jtf1);
		jtf1.setBounds(140, 80, 80, 25);
		
		JLabel jb2 = new JLabel("处分名称");
		jpanel.add(jb2);
		jb2.setBounds(50, 130, 60, 30);
		String[] level1 ={"警告","严重警告","记过","记大过","开除"};
		JComboBox<String> jcb1 = new JComboBox<String>(level1);
		jpanel.add(jcb1);
		jcb1.setBounds(140, 130, 80, 25);
		
//		JLabel jb3 = new JLabel("处分时间");
//		jpanel.add(jb3);
//		jb3.setBounds(50, 180, 60, 30);
//		JTextField jtf3 = new JTextField();
//		jpanel.add(jtf3);
//		jtf3.setBounds(140, 180, 80, 25);
		
		JLabel jb3 = new JLabel("处分时间");
		jb3.setBounds(50, 180, 60, 30);
		jpanel.add(jb3);
		/* 年下拉框 */
		Vector<String> yy = new Vector<String>();
		for (int i = 2010; i <= 2021; i++) {
			yy.add(Integer.toString(i));
		}
		JComboBox year1 = new JComboBox(yy);
		year1.setBounds(120, 183, 51, 20);
		year1.setBorder(null);// 设置无边框
		year1.setEditable(true);// 设置下拉框可编辑
		jpanel.add(year1);
		/*******************/
		/* 月下拉框 */
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
		mon1.setBorder(null);// 设置无边框
		mon1.setEditable(true);// 设置下拉框可编辑
		jpanel.add(mon1);
		/*****************/
	 
		/* 日下拉框 */
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
		day1.setBorder(null);// 设置无边框
		day1.setEditable(true);// 设置下拉框可编辑
		jpanel.add(day1);

		
		JLabel jb4 = new JLabel("处分级别");
		jpanel.add(jb4);
		jb4.setBounds(50, 230, 60, 30);
		String[] level2 ={"院级","校级","违反法律"};
		JComboBox<String> jcb2 = new JComboBox<String>(level2);
		jpanel.add(jcb2);
		jcb2.setBounds(140, 230, 80, 25);
		
		JButton btn1 = new JButton("提交");
		jpanel.add(btn1);
		btn1.setBounds(200, 290, 60, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id_s = jtf1.getText().trim();
				String description_s = jcb1.getSelectedItem().toString();
				String time_s = year1.getSelectedItem().toString()+"年"+mon1.getSelectedItem().toString()+"月"+day1.getSelectedItem().toString()+"日";
				String level_s = jcb2.getSelectedItem().toString();
				
				if(new ConnectDB().Query_id(id_s)){
					record_s = new ConnectDB().count_P()+1;
				
					String sql = "INSERT INTO PUNISH (record_s,id_s,description_s,time_s,level_s) VALUES ('" +record_s+"','"+id_s+"','"+ description_s + "','"+time_s+"','"+level_s+"');";
					if(new ConnectDB().punish_Insert(sql)){
						JOptionPane.showMessageDialog(null,"提交成功！","通知",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"提交失败！","通知",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"提交失败！没有这个学生！","通知",JOptionPane.INFORMATION_MESSAGE);
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