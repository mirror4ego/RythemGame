package rythem_game_02;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class RythemGame extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public RythemGame() {
		setTitle("RythemGame");
		setSize(Main.SCREEN_HEIGHT, Main.SCREEN_WIDTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBackground = (new ImageIcon(Main.class.getResource("../images/introBackground.jpg"))).getImage();
		// ImageIcon에서 Image로 형변환 하는 getImage 메소드 사용
		// getResource 메소드는 인자로 스트링을 사용하는데 작동방식은 해당 슬래쉬가 없으면 해당 패키지에서 검색을 하며 슬래쉬로 경로를 정해주면 해당 패키지에서 검색
		// 소스 폴더 내에서 검색
	}

	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_HEIGHT, Main.SCREEN_WIDTH);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
	
}
