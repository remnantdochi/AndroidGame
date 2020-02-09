package test02;
//20200202

public class Main {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	
	public static void main(String[] args) {
		//thread를 어디에 두는게 좋을까
		Thread t = new Thread(new Shoot());
		t.start();
	}
}

