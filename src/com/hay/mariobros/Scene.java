package com.hay.mariobros;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hay.audio.Audio;
import com.hay.character.Mario;
import com.hay.character.Pacman;
import com.hay.character.Sonic;
import com.hay.objects.Object;
import com.hay.objects.Block;
import com.hay.objects.Coin;
import com.hay.objects.Tube;
import com.hay.panel.CountDown;
import com.hay.panel.Score;

public class Scene extends JPanel{
	
	//var
	private ImageIcon icoBackground;
	private Image imgBackground;
	
	private ImageIcon icoCastleStart;
	private Image imgCastleStart;
	private ImageIcon icoStart;
	private Image imgStart;
	
	private int xBackground;
	private int dx;
	int xPos;
	int ySol;
	int ceilingHeight; //tavan yükekliði
	boolean ok;
	public Mario mario;
	
	public Tube tube0;
	public Tube tube1;
	public Tube tube2;
	
	public Block block0;
	public Block block1;
	public Block block2;
	
	
	public Coin coin0;
	public Coin coin1;
	public Coin coin2;
	
	public Pacman pacman0;
	public Pacman pacman1;
	public Pacman pacman2;
	
	
	public Sonic sonic0;
	public Sonic sonic1;
	public Sonic sonic2;
	
	
	private ImageIcon icoCastleFinish;
	private Image imgCastleFinish;
	private ImageIcon icoFinish;
	private Image imgFinish;
	
	private ArrayList<Object> allObjects;
	private ArrayList<Coin> allCoins;
	private ArrayList<Pacman> allPacmans;
	private ArrayList<Sonic> allSonic;
	
	private Score score;
	private Font font;
	private CountDown countDown;
	
	public Scene() {
		super();
		xBackground = 0;
		dx = 0;
		xPos = -1;
		ySol = 293; //buraya bakýlcak
		ceilingHeight = 0;
		ok = true;
		
		icoBackground = new ImageIcon(getClass().getResource("/images/background.png"));
		this.imgBackground = this.icoBackground.getImage();
		icoCastleStart = new ImageIcon(getClass().getResource("/images/castle_start.png"));
		this.imgCastleStart = this.icoCastleStart.getImage();	
		icoStart = new ImageIcon(getClass().getResource("/images/start.png"));
		this.imgStart = this.icoStart.getImage();
		icoCastleFinish = new ImageIcon(getClass().getResource("/images/castle_finish.png"));
		this.imgCastleFinish = this.icoCastleFinish.getImage();
		icoFinish = new ImageIcon(getClass().getResource("/images/finish.png"));
		this.imgFinish = this.icoFinish.getImage();
		
		mario = new Mario(300, 245);
		
		tube0 = new Tube(600, 230);
		tube1 = new Tube(600, 230);
		tube2 = new Tube(600, 230);
		
		block0 = new Block(400, 180);
		block1 = new Block(800, 180);
		block2 = new Block(1200, 180);
		
		coin0 = new Coin(410, 145);
		coin1 = new Coin(850, 145);
		coin2 = new Coin(100, 145);
		
		pacman0 = new Pacman(800, 250);
		pacman1 = new Pacman(1000, 250);
		pacman2 = new Pacman(1500, 250);
		
		
		sonic0 = new Sonic(900, 250);
		sonic1 = new Sonic(1100, 250);
		sonic2 = new Sonic(1600, 250);
		
		allObjects = new ArrayList<Object>();
		
		allObjects.add(tube0);
		allObjects.add(tube1);
		allObjects.add(tube2);
		allObjects.add(block0);
		allObjects.add(block1);
		allObjects.add(block2);
		
		allCoins = new ArrayList<Coin>();
		allCoins.add(coin0);
		allCoins.add(coin1);
		allCoins.add(coin2);
		
		allPacmans = new ArrayList<Pacman>();
		allPacmans.add(pacman0);
		allPacmans.add(pacman1);
		allPacmans.add(pacman2);
		
		allSonic = new ArrayList<Sonic>();
		allSonic.add(sonic0);
		allSonic.add(sonic1);
		allSonic.add(sonic2);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		
		score = new Score();
		font = new Font("Arial", Font.PLAIN, 18);
		countDown = new CountDown();
		
		Thread timerScreen = new Thread(new Timer());
		timerScreen.start();
	
	}
	
	

	//**** GETTERS ****//
	public int getDx() {return dx;}
	public int getxPos() {return xPos;}
	public int getySol() {return ySol;}
	public int getCeilingHeight() {return ceilingHeight;}

	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	public void setxPos(int xPos) {this.xPos = xPos;}
	public void setySol(int ySol) {this.ySol = ySol;}
	public void setCeilingHeight(int ceilingHeight) {this.ceilingHeight = ceilingHeight;}
	public void setxBackground(int xBackground) {this.xBackground = xBackground;}


	//**** FUNCTIONS ****//
	public void displacementBackground() {
		//
		if (this.xPos >= 0 && this.xPos <= 4000) {
			this.xPos = this.xPos + this.dx;
			this.xBackground = this.xBackground - this.dx;
		}
		
	}
	private boolean isWin() {
		if (this.countDown.getTimeCounter() > 0 && this.mario.isLife() && this.score.getNbreCoins() == 10 && this.xPos > 4000) {
			if (this.ok) {
				Audio.playSound("/audios/wim.wav");
				this.ok = false;
			}
			return true;
		}
		else {return false;}
	}
	private boolean isLost() {
		if (!this.mario.isLife() || this.countDown.getTimeCounter() <= 0) {
			return true;
		}
		else {return false;}
	}
	public boolean isGameOver() {
		if (this.isWin() || this.isLost()) {
			return true;
		}
		else {return false;}
	}
	
	public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Graphics g2 = (Graphics2D)g;
			
			for (int i = 0; i < this.allObjects.size(); i++) {
				//maio
				if (this.mario.near(this.allObjects.get(i))) {
					this.mario.contact(this.allObjects.get(i));
				}
				for (int j = 0; j < this.allPacmans.size(); j++) {
					if (this.allPacmans.get(j).near(this.allObjects.get(i))) {
						this.allPacmans.get(j).contact(this.allObjects.get(i));
					}
				}
				for (int j = 0; j < this.allSonic.size(); j++) {
					if (this.allSonic.get(j).near(this.allObjects.get(i))) {
						this.allSonic.get(j).contact(this.allObjects.get(i));
					}
				}
			}
			
			
			for (int j = 0; j < this.allCoins.size(); j++) {
				if (this.mario.near(this.allCoins.get(j))) {
					if(this.mario.coinContact(this.allCoins.get(j))) {
						Audio.playSound("/audios/coin.wav");
						this.allCoins.remove(j);
						this.score.setNbreCoins(this.score.getNbreCoins() + 1);
					}
				}
			}
			
			//pacamn mario
			
			//sonic mario
			
			//19 - 07
			
			//pacman öldüð
			
			//soniz öldü
			
			//19 - 08
			
			this.displacementBackground();
			
			
			if (this.xPos >= 0 & this.xPos <= 4000) {
				for (int i = 0; i < this.allObjects.size(); i++) {
					this.allObjects.get(i).displacement();
				}
				for (int i = 0; i < this.allCoins.size(); i++) {
					this.allCoins.get(i).displacement();
				}
				for (int i = 0; i < this.allPacmans.size(); i++) {
					this.allPacmans.get(i).displacement();
				}
				for (int i = 0; i < this.allSonic.size(); i++) {
					this.allSonic.get(i).displacement();
				}
			}
			
			g2.drawImage(this.imgBackground, 0, 0, null); //arka plan sabit
			
			g2.drawImage(this.imgCastleStart,  25 - this.xPos, 50, null); 
			g2.drawImage(this.imgStart,  10 - this.xPos, 0, null); 
			
			g2.drawImage(this.imgCastleFinish,  4475 - this.xPos, 50, null);
			g2.drawImage(this.imgFinish,  750 - this.xPos, 0, null); 
			
			
			for (int i = 0; i < allObjects.size(); i++) {
				g2.drawImage(this.allObjects.get(i).getImgObject(), this.allObjects.get(i).getX() - this.xPos, this.allObjects.get(i).getY(), null);
			}
			for (int i = 0; i < allCoins.size(); i++) {
				g2.drawImage(this.allCoins.get(i).getImgObject(), this.allCoins.get(i).getX() - this.xPos, this.allCoins.get(i).getY(), null);
			}
			
			//mario
			if (this.mario.isLife()) {
				//
				if (this.mario.isJump()) {
					g2.drawImage(this.mario.jumping(), this.mario.getX(), this.mario.getY(), null);

				} else {
					g2.drawImage(this.mario.move("mario", 25), this.mario.getX(), this.mario.getY(), null);
				}
			}
			else {
				g2.drawImage(this.mario.Die(), this.mario.getX(), this.mario.getY(), null);
			}
			
			
			//image pamcn
			
			//image sonic
			
			g2.setFont(font);
			g2.drawString(this.score.getNbreCoins() + " / " + this.score.getNBRE_TOTAL_COINS(), 100, 100);
			g2.drawString(this.countDown.getStr(), 5, 25);
			
			if (this.isGameOver()) {
				//bitti
			}
			
	}
	
	
	
	
	
	
}
