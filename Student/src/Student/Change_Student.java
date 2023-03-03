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

public class Change_Student {
	private JFrame frame = new JFrame("学生信息管理系统");
	private JPanel jpanel;
	private ImageIcon background;
	
	public static String id_s =null;
	
	public Change_Student(){
		background = new ImageIcon(this.getClass().getResource("/images/bg2.jpg"));// 背景图片

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
		
		JLabel title = new JLabel("学生信息变更");
		title.setBounds(160, 10, 400, 50);
		title.setFont(new Font("华文行楷", Font.BOLD, 40));
		jpanel.add(title);
		
		JButton btn1 = new JButton("奖励信息录入");
		jpanel.add(btn1);
		btn1.setBounds(230, 80, 120, 30);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reward_Insert();
				frame.dispose();
			}
			
		});
		
		JButton btn2 = new JButton("处分信息录入");
		jpanel.add(btn2);
		btn2.setBounds(230, 130, 120, 30);
		btn2.setFocusPainted(false);
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Punish_Insert();
				frame.dispose();
			}
			
		});
		
		JButton btn3 = new JButton("退学信息处理");
		jpanel.add(btn3);
		btn3.setBounds(230, 180, 120, 30);
		btn3.setFocusPainted(false);
		btn3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str = null;
				int flag = -1;
				str = JOptionPane.showInputDialog(jpanel, "请输入要删除的学生的学号", "删除学生信息", JOptionPane.PLAIN_MESSAGE);
				if(str!=null){
					flag = new ConnectDB().delete_S(str);
				}
				if(flag == 1){
					JOptionPane.showMessageDialog(null,"删除成功！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
				else if (flag == 0){
					JOptionPane.showMessageDialog(null,"删除失败！没有这个学生！","通知",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		
		JButton btn4 = new JButton("学生信息修改");
		jpanel.add(btn4);
		btn4.setBounds(230, 230, 120, 30);
		btn4.setFocusPainted(false);
		btn4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean b = true;
				id_s = JOptionPane.showInputDialog(jpanel,"请输入要修改的学生的学号：\n","修改学生信息",JOptionPane.PLAIN_MESSAGE);
				if(id_s!=null){
					if(id_s.length() != 10){
						JOptionPane.showMessageDialog(null,"请输入十位数字！","通知",JOptionPane.INFORMATION_MESSAGE);
						b = false;
					}
					else if(id_s.length() == 10){
						for(int i = 0;i < id_s.length(); i++){
							if(id_s.charAt(i) < '0' || id_s.charAt(i) > '9'){
								b = false;
								JOptionPane.showMessageDialog(null,"学号框请输入数字！","通知",JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}
					}
					
					boolean t = new ConnectDB().Query_id(id_s);
					if(!t){
						JOptionPane.showMessageDialog(null,"没有这个学生！","通知",JOptionPane.INFORMATION_MESSAGE);
					}
					if(b && t){
						frame.dispose();
						new Change_Student_M();
					}
				}
			}
			
		});
		
		JButton btn5 = new JButton("学籍信息变更");
		jpanel.add(btn5);
		btn5.setBounds(230, 280, 120, 30);
		btn5.setFocusPainted(false);
		btn5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Change();
				frame.dispose();
			}
		});
		
		JButton btn6 = new JButton("返回主菜单");
		jpanel.add(btn6);
		btn6.setBounds(230, 330, 120, 30);
		btn6.setFocusPainted(false);
		btn6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new Menu_M();
				frame.dispose();
			}
		});
	}
}