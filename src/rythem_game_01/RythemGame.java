package rythem_game_01;

import javax.swing.JFrame;

public class RythemGame extends JFrame {
	
	public RythemGame() {
		setTitle("RythemGame");
		setSize(Main.SCREEN_HEIGHT, Main.SCREEN_WIDTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
