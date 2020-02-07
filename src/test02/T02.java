package test02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;


public class T02 extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;
	
	public T02() { //������
		//����� �ʱ�ȭ
		setTitle("test01");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBackground = new ImageIcon("img/backimage.jpg").getImage(); // project > properties > java build path > img ���� �߰�
		//introBackground = new ImageIcon("D:\\Study\\backimage.jpg").getImage(); //��ȣ ��ο� �ִ� \ >> \\�� �ؾ� �۵�
	}
	
	//�� paint�� draw�� �и�������? �� �� �̰� ������۸�??
	//paint�� ��� �ҷ����µ� �̰� �۵���....?
	//paint��� �Լ��� JFrame�� �����Ǹ鼭 ���� ���� ȭ�鿡 �׷����� �⺻ �Լ�
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