package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hay.audio.Audio;
import com.hay.character.Mario;
import com.hay.character.Pacman;
import com.hay.character.Rapunzel;
import com.hay.character.Sonic;
import com.hay.objects.Block;
import com.hay.objects.Cloud;
import com.hay.objects.Coin;
import com.hay.objects.Floor;
import com.hay.objects.Mountain;
import com.hay.objects.Tube;
import com.hay.panel.CountDown;
import com.hay.panel.Score;

import java.awt.Font;


@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	//*****VARIABLES*****//
	private ImageIcon icoBackground;
	private Image imgBackground;
	private ImageIcon icoCastleStart;
	private Image imgCastleStart;
	private ImageIcon icoStart;
	private Image imgStart;
	private ImageIcon icoCastleFinish;
	private Image imgCastleFinish;
	private ImageIcon icoFinish;
	private Image imgFinish;
	private ImageIcon icoFlag;
	private Image imgFlag;
	
	private int xBackground;
	private int dx;
	private int xPos;
	private int ySol;
    private int ceilingheater=0;
    
    public Random rand =new Random();
    int a = rand.nextInt(10);//0-10
    
    //Characters
	public Mario mario;
	public Rapunzel rapunzel;
	private ArrayList<Pacman> pacmans;
	private ArrayList<Sonic> sonics;
	
	private ArrayList<Mountain> mountains;
	private ArrayList<Cloud> clouds;
	
	private ArrayList<Block> blocks;
	private ArrayList<Coin> coins;
	private ArrayList<Floor> floors;
	private ArrayList<Tube> tubes;
	
	//
	private Score score;
	private java.awt.Font font;
	private CountDown countDown;
	
	
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xBackground = -50;
		this.dx = 0;
		this.xPos = 0;
		
		//
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
		
		//Characters
		mario = new Mario(370, 300);
		rapunzel = new Rapunzel(0, 0);
		
		pacmans = new ArrayList<Pacman>();
		sonics = new ArrayList<Sonic>();
		
		mountains = new ArrayList<Mountain>();
		clouds = new ArrayList<Cloud>();
		
		blocks = new ArrayList<Block>();
		coins = new ArrayList<Coin>();
		floors = new ArrayList<Floor>();
		tubes = new ArrayList<Tube>();
		
		
		for (int i = 0; i < rand.nextInt(10); i++) {
			Pacman pacman = new Pacman(i * 50 + i, 0);
			pacmans.add(pacman);
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Sonic sonic = new Sonic(i * 50 + i, 0);
			sonics.add(sonic);
		}
		
		//Objects
		for (int i = 0; i < rand.nextInt(10); i++) {
			Block block = new Block(i * 50 + i, 0);
			blocks.add(block);//rand yapılcak
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Cloud cloud = new Cloud(i * 100 + i, 0);
			clouds.add(cloud);//rand yapılck y = 250 - 0
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Coin coin = new Coin(i * 200 + i, 100);
			coins.add(coin);//rand yapılcak y = 420 - 100
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Floor floor = new Floor(i * 200 + i, 450);
			floors.add(floor);//rand yapılcak
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Mountain mountain = new Mountain(i * 300 + i, 250);
			mountains.add(mountain);//rand yapılcak
		}
		for (int i = 0; i < rand.nextInt(10); i++) {
			Tube tube = new Tube(i * 75 + i, 300);
			tubes.add(tube);//rand yapılcak y = 300 - 400
		}
		
		
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
	public int getCeilingheater() {return ceilingheater;}

	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	public void setxPos(int xPos) {this.xPos = xPos;}
	public void setySol(int ySol) {this.ySol = ySol;}
	public void setCeilingheater(int ceilingheater) {this.ceilingheater = ceilingheater;}
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
			/*if (this.ok) {
				Audio.playSound("/audios/wim.waw");
				this.ok = false;
			}*/
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
		
		//objects
		for (int i = 0; i < blocks.size(); i++) {
			if (this.mario.near(this.blocks.get(i))) {
				this.mario.contact(this.blocks.get(i));
			}
			for (int j = 0; j < pacmans.size(); j++) {
				if (this.pacmans.get(j).near(this.blocks.get(i))) {
					this.pacmans.get(j).contact(this.blocks.get(i));
				}
			}
			for (int j = 0; j < sonics.size(); j++) {
				if (this.sonics.get(j).near(this.blocks.get(i))) {
					this.sonics.get(j).contact(this.blocks.get(i));
				}
			}
		}
		for (int i = 0; i < floors.size(); i++) {
			if (this.mario.near(this.floors.get(i))) {
				this.mario.contact(this.floors.get(i));
			}
			for (int j = 0; j < pacmans.size(); j++) {
				if (this.pacmans.get(j).near(this.floors.get(i))) {
					this.pacmans.get(j).contact(this.floors.get(i));
				}
			}
			for (int j = 0; j < sonics.size(); j++) {
				if (this.sonics.get(j).near(this.floors.get(i))) {
					this.sonics.get(j).contact(this.floors.get(i));
				}
			}
		}
		for (int i = 0; i < tubes.size(); i++) {
			if (this.mario.near(this.tubes.get(i))) {
				this.mario.contact(this.tubes.get(i));
			}
			for (int j = 0; j < pacmans.size(); j++) {
				if (this.pacmans.get(j).near(this.tubes.get(i))) {
					this.pacmans.get(j).contact(this.tubes.get(i));
				}
			}
			for (int j = 0; j < sonics.size(); j++) {
				if (this.sonics.get(j).near(this.tubes.get(i))) {
					this.sonics.get(j).contact(this.tubes.get(i));
				}
			}
		}
		
		//
		for (int i = 0; i < pacmans.size(); i++) {
			for (int j = 0; j < pacmans.size(); j++) {
				if (j != i) {
					if (this.pacmans.get(j).near(this.pacmans.get(i))) {
						this.pacmans.get(j).contact(this.pacmans.get(i));
					}
				}
			}
			for (int j = 0; j < sonics.size(); j++) {
				if (this.sonics.get(j).near(this.pacmans.get(i))) {
					this.sonics.get(j).contact(this.pacmans.get(i));
				}
			}
		}
		for (int i = 0; i < sonics.size(); i++) {
			for (int j = 0; j < sonics.size(); j++) {
				if (j != i) {
					if (this.sonics.get(j).near(this.sonics.get(i))) {
						this.sonics.get(j).contact(this.sonics.get(i));
					}
				}
			}
			for (int j = 0; j < pacmans.size(); j++) {
				if (this.pacmans.get(j).near(this.sonics.get(i))) {
					this.pacmans.get(j).contact(this.sonics.get(i));
				}
			}
		}
		
		//coins
		for (int i = 0; i < coins.size(); i++) {
			if (this.mario.near(this.coins.get(i))) {
				if (this.mario.coinContact(this.coins.get(i))) {
					Audio.playSound("/audios/coin.waw");
					this.coins.remove(i);
					this.score.setNbreCoins(this.score.getNbreCoins() + 1);
				}
			}
		}
		
		//mario vs enemys
		for (int i = 0; i < pacmans.size(); i++) {
			if (this.mario.near(this.pacmans.get(i)) && this.pacmans.get(i).isLife()) {
				//
				this.mario.contact(this.pacmans.get(i));
				if (!this.pacmans.get(i).isLife()) {
					Audio.playSound("/audios/crush.waw");
				}
			}
		}
		for (int i = 0; i < sonics.size(); i++) {
			if (this.mario.near(this.sonics.get(i)) && this.sonics.get(i).isLife()) {
				//
				this.mario.contact(this.sonics.get(i));
				if (!this.sonics.get(i).isLife()) {
					Audio.playSound("/audios/crush.waw");
				}
			}
		}
		
		//fixed
		this.displacementBackground();
		
		if (this.xPos >= 0 && this.xPos <= 4000) {
			//charcaters
			for (int i = 0; i < pacmans.size(); i++) {
				this.pacmans.get(i).displacement();
			}
			for (int i = 0; i < sonics.size(); i++) {
				this.sonics.get(i).displacement();
			}
			//objects
			for (int i = 0; i < blocks.size(); i++) {
				this.blocks.get(i).displacement();
			}
			for (int i = 0; i < clouds.size(); i++) {
				this.clouds.get(i).displacement();
			}
			for (int i = 0; i < coins.size(); i++) {
				this.coins.get(i).displacement();
			}
			for (int i = 0; i < floors.size(); i++) {
				this.floors.get(i).displacement();
			}
			for (int i = 0; i < mountains.size(); i++) {
				this.mountains.get(i).displacement();
			}
			for (int i = 0; i < tubes.size(); i++) {
				this.tubes.get(i).displacement();
			}
		}
		
		//update
		//background 
		g2.drawImage(this.imgBackground, 0, 0, null); //arka plan sabit
		
		g2.drawImage(this.imgCastleStart,  25 - this.xPos, 50, null); 
		g2.drawImage(this.imgStart,  10 - this.xPos, 0, null); 
		
		g2.drawImage(this.imgCastleFinish,  4475 - this.xPos, 50, null);
		g2.drawImage(this.imgFinish,  750 - this.xPos, 0, null); 
		
		
		for (int i = 0; i < blocks.size(); i++) {
			g2.drawImage(this.blocks.get(i).getImgObject(), this.blocks.get(i).getX() - this.xPos, this.blocks.get(i).getY(), null);
		}
		for (int i = 0; i < clouds.size(); i++) {
			g2.drawImage(this.clouds.get(i).getImgObject(), this.clouds.get(i).getX() - this.xPos, this.clouds.get(i).getY(), null);
		}
		for (int i = 0; i < coins.size(); i++) {
			g2.drawImage(this.coins.get(i).getImgObject(), this.coins.get(i).getX() - this.xPos, this.coins.get(i).getY(), null);
		}
		for (int i = 0; i < floors.size(); i++) {
			g2.drawImage(this.floors.get(i).getImgObject(), this.floors.get(i).getX() - this.xPos, this.floors.get(i).getY(), null);
		}
		for (int i = 0; i < mountains.size(); i++) {
			g2.drawImage(this.mountains.get(i).getImgObject(), this.mountains.get(i).getX() - this.xPos, this.mountains.get(i).getY(), null);
		}
		for (int i = 0; i < tubes.size(); i++) {
			g2.drawImage(this.tubes.get(i).getImgObject(), this.tubes.get(i).getX() - this.xPos, this.tubes.get(i).getY(), null);
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
		
		//pacmans
		for (int i = 0; i < pacmans.size(); i++) {
			
			if (this.pacmans.get(i).isLife()) {

				g2.drawImage(this.pacmans.get(i).move("pacman", 25), this.pacmans.get(i).getX(), this.pacmans.get(i).getY(), null);

			}
			else {
				g2.drawImage(this.pacmans.get(i).Die(), this.pacmans.get(i).getX(), this.pacmans.get(i).getY(), null);
			}
		}
		
		//sonics
		for (int i = 0; i < sonics.size(); i++) {
			
			if (this.sonics.get(i).isLife()) {

				g2.drawImage(this.sonics.get(i).move("pacman", 25), this.sonics.get(i).getX(), this.sonics.get(i).getY(), null);

			}
			else {
				g2.drawImage(this.sonics.get(i).Die(), this.sonics.get(i).getX(), this.sonics.get(i).getY(), null);
			}
		}
		
		g2.setFont(font);
		g2.drawString(this.score.getNbreCoins() + " / " + this.score.getNBRE_TOTAL_COINS(), 100, 100);
		
		g2.drawString(this.countDown.getStr(), 5, 25);
		
		if (this.isGameOver()) {
			//bitti
		}
	}

}
