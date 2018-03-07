package rythem_game_09;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {

		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			//해당 파일의 위치를 가져올 수 있게 함
			fis = new FileInputStream(file); // 파일이 이동할 수 있는 통로를 생성
			bis = new BufferedInputStream(fis); // 내부적으로 버퍼를 준비하고 이곳에 일단 저장했다가 작업을 함
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if (player == null)
			return 0; // 플레이어 객체가 널이면 시간 0을 반환
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				 player.play();
				 fis = new FileInputStream(file);
				 bis = new BufferedInputStream(fis);
				 player = new Player(bis);
			}while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	

}
