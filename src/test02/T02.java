package test02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;


public class T02 extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;
	
	public T02() { //생성자
		//여기는 초기화
		setTitle("test01");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBackground = new ImageIcon("img/backimage.jpg").getImage(); // project > properties > java build path > img 폴더 추가
		//introBackground = new ImageIcon("D:\\Study\\backimage.jpg").getImage(); //오호 경로에 있는 \ >> \\로 해야 작동
	}
	
	//왜 paint와 draw를 분리했을까? 에 또 이게 더블버퍼링??
	//paint를 어디서 불러오는데 이게 작동함....?
	//paint라는 함수는 JFrame이 생성되면서 가장 먼저 화면에 그려지는 기본 함수
	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground,0,0,null);
		this.repaint();
	}
}