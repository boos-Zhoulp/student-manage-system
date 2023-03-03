package Student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import javazoom.jl.player.Player;

public class Star extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH=600;    //画布宽度和高度
	public static final int FRAME_LENGTH=450;
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	int screenwidth=screenSize.width;     
	int screenheight=screenSize.height;
	
	int[] x=new int[60];
	int[] y=new int[60];

	Image screenImage=null;
	MenuBar jmb=null;//定义吧台、菜单和子菜单
	Menu jm=null;
	MenuItem jmi1,jmi2,enter;
	Menu jm1=null;
	MenuItem jmi3,jmi4;
	
	boolean m=true;
	int n=50;
	
	public static Cool cool = null;
	public static void main(String[] args) {
		new Star();
		cool = new Cool();
		cool.start();
	}
	
	public void update(Graphics g){
		Font font = new Font("隶书",Font.BOLD, 30);
		screenImage=this.createImage(FRAME_WIDTH, FRAME_LENGTH);
		Graphics gps=screenImage.getGraphics();//画布
		gps.setColor(Color.orange);  //设置画笔颜色
		gps.setFont(font);
		gps.drawString("欢迎使用学生信息管理系统！", 90, 200);
		gps.setColor(Color.black);
		gps.fillOval(30, 70, 100, 100);
		gps.setColor(Color.black);
		gps.fillOval(10, 50, 100, 100);
		
		for(int i=0;i<60;i++){
			int R=(int)(Math.random()*255);  //生成随机颜色
			int G=(int)(Math.random()*255);
			int B=(int)(Math.random()*255);
			gps.setFont(new Font("",Font.BOLD,12));
			gps.setColor(new Color(R,G,B));
			gps.drawString("★", x[i], y[i]);    //画星星
		}
		g.drawImage(screenImage, 0, 0, null);
	}

	public Star(){
		jmb =new MenuBar();
		jm =new Menu("进入/继续/暂停");
		jm1 = new Menu("加快/减速");
		
		enter = new MenuItem("进入");
		enter.setFont(new Font("",Font.BOLD,12));
		enter.addActionListener(this);
		enter.setActionCommand("enter");
		
		jmi1=new MenuItem("暂停");
		jmi1.setFont(new Font("",Font.BOLD,12));
		jmi1.addActionListener(this);
		jmi1.setActionCommand("stop");		
		jmi2=new MenuItem("继续");
		jmi2.setFont(new Font("",Font.BOLD,12));
		jmi2.addActionListener(this);
		jmi2.setActionCommand("continue");
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(enter);
		jm1 =new Menu("加速/减速");
		jmi3=new MenuItem("加速");
		jmi3.setFont(new Font("",Font.BOLD,12));
		jmi3.addActionListener(this);
		jmi3.setActionCommand("fast");
		jmi4=new MenuItem("减速");
		jmi4.setFont(new Font("",Font.BOLD,12));
		jmi4.addActionListener(this);
		jmi4.setActionCommand("slow");
		jmb.add(jm1);
		jm1.add(jmi3);
		jm1.add(jmi4);
		//初始化星星的坐标信息
		Random rand=new Random();
		for(int i=0;i<x.length;i++){
			x[i]=rand.nextInt(600);
			y[i]=(int)(Math.random()*450);//int x=(int)(Math.random()*450);
		}
		
		this.setMenuBar(jmb);
		this.setBackground(Color.black);
		this.setTitle("学生信息管理系统");
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(FRAME_WIDTH,FRAME_LENGTH);	
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});//window监听器
		this.setLocation(350, 100);//居中显示this.setLocation(1920/2-400, 1080/2-300);//1920*1080
		//repaint();//自动调用update方法			
		new Thread(new PaintThread()).start();//调用新的线程Thread
	}		
	//线程
	private class PaintThread implements Runnable{
		public void run(){
			while(m){
				for(int i=0;i<x.length;i++){
					if(x[i]>FRAME_WIDTH) x[i]=0;
					if(y[i]>FRAME_LENGTH) y[i]=0;
					x[i]++;
					y[i]++;		
				}
				repaint();//将面板以前的内容删去
				//判断是否有异常，有则刨出异常
				try{
					Thread.sleep(n);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override//按键监听器
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("enter")){
			//System.out.println("123");
			cool.stop();
			new Welcome().start();
			Welcome.test = new ChangeColor();
			Thread thread = new Thread(Welcome.test);
			thread.start();
			this.dispose();
		}
		// TODO Auto-generated method stub
		else if(e.getActionCommand().equals("stop")){
			m=false;
			//System.out.println("stop");
		}
		else if(e.getActionCommand().equals("continue")){//m当前处于false
			if(!m){
				m=true;
				new Thread(new PaintThread()).start();
			}
			//System.out.println("continue");
		}
		else if(e.getActionCommand().equals("fast")){
			n=n-10;
			if(n>=1){
				int temp=n;
				n=temp;
			}
			else n=1;
		}
		else if(e.getActionCommand().equals("slow")){
			n=n+10;
		}
	}
}

class Cool extends Thread{
	public void run(){
		File file = new File("src/流星雨.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}