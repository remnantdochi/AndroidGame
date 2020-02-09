package test02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movewithbuffer extends JFrame implements KeyListener, Runnable {

	private int f_width = 1600;
	private int f_height = 800;
	 
	private int x, y; // 캐릭터의 좌표 변수
	 
	private boolean KeyUp = false; //키보드 입력 처리를 위한 변수
	private boolean KeyDown = false;
	private boolean KeyLeft = false;
	private boolean KeyRight = false;
	 
	Thread th; // 스레드 생성 
	 
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image me_img = tk.getImage("img/test.png");
	
	private Image buffImage; //더블 버퍼링용
	private Graphics buffg;
 
	public Movewithbuffer(){
		init();
		start();
		  
		setTitle("슈팅 게임 만들기");
		setSize(f_width, f_height);
		  
		Dimension screen = tk.getScreenSize();
		
		int f_xpos = (int)(screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}
	
	public void init(){
		x = 100; //캐릭터의 최초 좌표.
		y = 100;
	}
	public void start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this); //키보드 이벤트 실행
		th = new Thread(this);  // 스레드 생성
		th.start();  // 스레드 실행
	}
	
	public void run(){ // 스레드가 무한 루프될 부분
		try{ // 예외옵션 설정으로 에러 방지
		while(true){ // while 문으로 무한 루프 시키기
		KeyProcess(); // 키보드 입력처리를 하여 x,y 갱신
		repaint(); // 갱신된 x,y값으로 이미지 새로 그리기
		Thread.sleep(20); // 20 milli sec 로 스레드 돌리기 
		}
		}catch (Exception e){}
	}
	
	public void paint(Graphics g){
		buffImage = createImage(f_width, f_height);
		//더블 버퍼링 버퍼크기를 화면 크기와 같게 설정
		buffg = buffImage.getGraphics(); //버퍼의 그래픽 객체를 얻기
		
		//원래코드 아래 두줄 없고 update(g)
		//밑에 두줄로 대체하는건 왜 안될까 //null을this로 바꾸니까 되네
		screenDraw(buffg);
		g.drawImage(buffImage,x,y,this);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(me_img,x,y,this);
		this.repaint();
	}
	
	public void update(Graphics g) {
		Draw_Char();
		g.drawImage(buffImage,0,0,this);
	}
	
	public void Draw_Char() {
		buffg.clearRect(0,0,f_width,f_height);
		buffg.drawImage(me_img,x,y,this);
	}
	
	public void keyPressed(KeyEvent e){
	// 키보드가 눌러졌을때 이벤트 처리하는 곳 
	  
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
	// 키보드가 눌러졌다가 때어졌을때 이벤트 처리하는 곳
	  
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
	// 키보드가 타이핑 될때 이벤트 처리하는 곳
	 
	public void KeyProcess(){
		//실제로 캐릭터 움직임 실현을 위해
		//위에서 받아들인 키값을 바탕으로
		//키 입력시마다 5만큼의 이동을 시킨다.
		
		if(KeyUp == true)  y -= 5;
		if(KeyDown == true) y += 5;
		if(KeyLeft == true)  x -= 5;
		if(KeyRight == true) x += 5;
		   
	}
	
}