package rythem_game_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image noteBasicImage = (new ImageIcon(Main.class.getResource("../images/noteBasic.png"))).getImage();
	private Image noteRouteLineImage = (new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))).getImage();
	private Image judgementLineImage = (new ImageIcon(Main.class.getResource("../images/judgementLine.png"))).getImage();
	private Image gameInfoImage = (new ImageIcon(Main.class.getResource("../images/gameInfo.png"))).getImage();
	private Image noteRouteSImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteDImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteFImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteSpace1Image = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteSpace2Image = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteJImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteKImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image noteRouteLImage = (new ImageIcon(Main.class.getResource("../images/noteRoute.png"))).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadDImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadFImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadSpace1Image = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadSpace2Image = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadJImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadKImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();
	private Image keyPadLImage = (new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))).getImage();

	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i=0; i<noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/missJudge.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 370, 370, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		

		

	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum1.mp3", false).start();	
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum2.mp3", false).start();	
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressF() {
		judge("F");
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum3.mp3", false).start();	
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum4.mp3", false).start();	
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum5.mp3", false).start();	
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum6.mp3", false).start();	
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drum7.mp3", false).start();	
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes();
		
	}

	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
		Beat[] beats = {
				new Beat(1000, "S"),
				new Beat(2000, "D"),
				new Beat(3000, "F")
		};
		
		if(titleName.equals("Joakim Karud") && difficulty.equals("EASY")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "S"),
			};
		}
		else if(titleName.equals("Joakim Karud") && difficulty.equals("HARD")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "S"),
					new Beat(startTime + gap * 8, "D"),
					new Beat(startTime + gap * 8, "F"),
			};
		}
		else if (titleName.equals("On & On") && difficulty.equals("EASY"))
		{
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("On & On") && difficulty.equals("HARD"))
		{
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("Inspiration") && difficulty.equals("EASY"))
		{
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("Inspiration") && difficulty.equals("HARD"))
		{
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void judge(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("MISS")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/missJudge.png")).getImage();
		}
		else if(judge.equals("LATE")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/lateJudge.png")).getImage();
		}
		else if(judge.equals("GOOD")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/goodJudge.png")).getImage();
		}
		else if(judge.equals("GREAT")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/greatJudge.png")).getImage();
		}
		else if(judge.equals("PERFECT")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfectJudge.png")).getImage();
		}
		else if(judge.equals("EARLY")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/earlyJudge.png")).getImage();
		}

	}
}
