//ȭ�� �ߴ� �� Ȯ��
package test02;

import javax.swing.*;
import java.awt.*;

public class game extends JFrame{

	int f_width = 800;
	int f_height = 600;
	 
	Toolkit tk = Toolkit.getDefaultToolkit();
	       //�̹����� �ҷ����� ���� ��Ŷ
	Image me_img = tk.getImage("img/bird.jpg"); 
	public game(){

		init();
		start();
		  
		setTitle("���� ���� �����2");
		setSize(f_width, f_height);
		  
		Dimension screen = tk.getScreenSize();
		
		int f_xpos = (int)(screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}
	 
	public void init(){
	}
	public void start(){
	  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//������ ������ ���� X��ư�� �������� 
	      //���α׷��� ���������� �����ϰ� ����� �ݴϴ�.
	  
	}
	public void paint(Graphics g){
	
		g.clearRect(0, 0, f_width, f_height);
		// 0,0 ���� ������ ���� �ػ� ũ�⸸ŭ ȭ���� ����ϴ�.
		g.drawImage(me_img, 100, 100, this);
		//�����ӿ� me_img�� ����� f15k.png �̹����� 
		             //x=100, y=100 ��ǥ�� �׷��ֽ��ϴ�.
	
	}
}

