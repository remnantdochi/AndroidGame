package test02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Move extends JFrame implements KeyListener, Runnable{ 
	 // ������ ������ ���� JFrame ���
	 //Ű���� �̺�Ʈ ó���� ���� KeyListener�� ���
	 //�����带 ������ ���� Runnable ���
	 
	int f_width = 800;
	int f_height = 600;
	 
	int x, y; // ĳ������ ��ǥ ����
	 
	boolean KeyUp = false; //Ű���� �Է� ó���� ���� ����
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	 
	Thread th; // ������ ����
	 
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image me_img = tk.getImage("img/bird.jpg"); 
	 
	public Move(){
	 init();
	 start();
	  
	 setTitle("���� ���� �����");
	 setSize(f_width, f_height);
	  
	 Dimension screen = tk.getScreenSize();

	 int f_xpos = (int)(screen.getWidth() / 2 - f_width / 2);
	 int f_ypos = (int)(screen.getHeight() / 2 - f_height / 2);

	 setLocation(f_xpos, f_ypos);
	 setResizable(false);
	 setVisible(true);
	}
	public void init(){
	x = 100; //ĳ������ ���� ��ǥ.
	y = 100;
	}
	public void start(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	addKeyListener(this); //Ű���� �̺�Ʈ ����
	th = new Thread(this);  // ������ ����
	th.start();  // ������ ����

	}

	public void run(){ // �����尡 ���� ������ �κ�
	try{ // ���ܿɼ� �������� ���� ����
	while(true){ // while ������ ���� ���� ��Ű��
	KeyProcess(); // Ű���� �Է�ó���� �Ͽ� x,y ����
	repaint(); // ���ŵ� x,y������ �̹��� ���� �׸���
	Thread.sleep(20); // 20 milli sec �� ������ ������ 
	}
	}catch (Exception e){}
	}

	public void paint(Graphics g){
	g.clearRect(0, 0, f_width, f_height);
	g.drawImage(me_img, x, y, this);
	//����Ǵ� ��ǥ�� ���� �̹����� ���� �׷����� �ϱ�.
	}
	public void keyPressed(KeyEvent e){
	// Ű���尡 ���������� �̺�Ʈ ó���ϴ� �� 
	  
	switch(e.getKeyCode()){
	case KeyEvent.VK_UP :
	KeyUp = true;
	break;
	case KeyEvent.VK_DOWN :
	KeyDown = true;
	break;
	case KeyEvent.VK_LEFT :
	KeyLeft = true;
	break;
	case KeyEvent.VK_RIGHT :
	KeyRight = true;
	break;
	}
	}
	public void keyReleased(KeyEvent e){
	// Ű���尡 �������ٰ� ���������� �̺�Ʈ ó���ϴ� ��
	  
	switch(e.getKeyCode()){
	case KeyEvent.VK_UP :
	KeyUp = false;
	break;
	case KeyEvent.VK_DOWN :
	KeyDown = false;
	break;
	case KeyEvent.VK_LEFT :
	KeyLeft = false;
	break;
	case KeyEvent.VK_RIGHT :
	KeyRight = false;
	break;
	}
	}
	public void keyTyped(KeyEvent e){}
	// Ű���尡 Ÿ���� �ɶ� �̺�Ʈ ó���ϴ� ��
	 
	public void KeyProcess(){
	//������ ĳ���� ������ ������ ����
	//������ �޾Ƶ��� Ű���� ��������
	//Ű �Է½ø��� 5��ŭ�� �̵��� ��Ų��.

	if(KeyUp == true)  y -= 5;
	if(KeyDown == true) y += 5;
	if(KeyLeft == true)  x -= 5;
	if(KeyRight == true) x += 5;
	   
	}
}