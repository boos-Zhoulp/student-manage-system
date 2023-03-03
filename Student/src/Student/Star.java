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
	public static final int FRAME_WIDTH=600;    //������Ⱥ͸߶�
	public static final int FRAME_LENGTH=450;
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	int screenwidth=screenSize.width;     
	int screenheight=screenSize.height;
	
	int[] x=new int[60];
	int[] y=new int[60];

	Image screenImage=null;
	MenuBar jmb=null;//�����̨���˵����Ӳ˵�
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
		Font font = new Font("����",Font.BOLD, 30);
		screenImage=this.createImage(FRAME_WIDTH, FRAME_LENGTH);
		Graphics gps=screenImage.getGraphics();//����
		gps.setColor(Color.orange);  //���û�����ɫ
		gps.setFont(font);
		gps.drawString("��ӭʹ��ѧ����Ϣ����ϵͳ��", 90, 200);
		gps.setColor(Color.black);
		gps.fillOval(30, 70, 100, 100);
		gps.setColor(Color.black);
		gps.fillOval(10, 50, 100, 100);
		
		for(int i=0;i<60;i++){
			int R=(int)(Math.random()*255);  //���������ɫ
			int G=(int)(Math.random()*255);
			int B=(int)(Math.random()*255);
			gps.setFont(new Font("",Font.BOLD,12));
			gps.setColor(new Color(R,G,B));
			gps.drawString("��", x[i], y[i]);    //������
		}
		g.drawImage(screenImage, 0, 0, null);
	}

	public Star(){
		jmb =new MenuBar();
		jm =new Menu("����/����/��ͣ");
		jm1 = new Menu("�ӿ�/����");
		
		enter = new MenuItem("����");
		enter.setFont(new Font("",Font.BOLD,12));
		enter.addActionListener(this);
		enter.setActionCommand("enter");
		
		jmi1=new MenuItem("��ͣ");
		jmi1.setFont(new Font("",Font.BOLD,12));
		jmi1.addActionListener(this);
		jmi1.setActionCommand("stop");		
		jmi2=new MenuItem("����");
		jmi2.setFont(new Font("",Font.BOLD,12));
		jmi2.addActionListener(this);
		jmi2.setActionCommand("continue");
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(enter);
		jm1 =new Menu("����/����");
		jmi3=new MenuItem("����");
		jmi3.setFont(new Font("",Font.BOLD,12));
		jmi3.addActionListener(this);
		jmi3.setActionCommand("fast");
		jmi4=new MenuItem("����");
		jmi4.setFont(new Font("",Font.BOLD,12));
		jmi4.addActionListener(this);
		jmi4.setActionCommand("slow");
		jmb.add(jm1);
		jm1.add(jmi3);
		jm1.add(jmi4);
		//��ʼ�����ǵ�������Ϣ
		Random rand=new Random();
		for(int i=0;i<x.length;i++){
			x[i]=rand.nextInt(600);
			y[i]=(int)(Math.random()*450);//int x=(int)(Math.random()*450);
		}
		
		this.setMenuBar(jmb);
		this.setBackground(Color.black);
		this.setTitle("ѧ����Ϣ����ϵͳ");
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(FRAME_WIDTH,FRAME_LENGTH);	
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});//window������
		this.setLocation(350, 100);//������ʾthis.setLocation(1920/2-400, 1080/2-300);//1920*1080
		//repaint();//�Զ�����update����			
		new Thread(new PaintThread()).start();//�����µ��߳�Thread
	}		
	//�߳�
	private class PaintThread implements Runnable{
		public void run(){
			while(m){
				for(int i=0;i<x.length;i++){
					if(x[i]>FRAME_WIDTH) x[i]=0;
					if(y[i]>FRAME_LENGTH) y[i]=0;
					x[i]++;
					y[i]++;		
				}
				repaint();//�������ǰ������ɾȥ
				//�ж��Ƿ����쳣�������ٳ��쳣
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
	@Override//����������
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
		else if(e.getActionCommand().equals("continue")){//m��ǰ����false
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
		File file = new File("src/������.mp3");
		try{
			Player player = new Player(new FileInputStream(file));
			player.play();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}