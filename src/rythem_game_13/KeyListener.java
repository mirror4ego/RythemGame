package rythem_game_13;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if(RythemGame.game == null) {
			System.out.println("11");
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			RythemGame.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			RythemGame.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			RythemGame.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			RythemGame.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			RythemGame.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			RythemGame.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			RythemGame.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(RythemGame.game == null) {
			System.out.println("12");
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			RythemGame.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			RythemGame.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			RythemGame.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			RythemGame.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			RythemGame.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			RythemGame.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			RythemGame.game.releaseL();
		}
	}
}
