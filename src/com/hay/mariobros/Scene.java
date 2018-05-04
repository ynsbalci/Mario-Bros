package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hay.character.Mario;
import com.hay.objects.Block;
import com.hay.objects.Cloud;
import com.hay.objects.Coin;
import com.hay.objects.Floor;
import com.hay.objects.Mountain;
import com.hay.objects.Tube;


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
	
	private int xBackground;
	private int dx;
	private int xPos;
	private int ySol;
    private int ceilingheater=0;
    
    Random rand =new Random();
     int a = rand.nextInt(10);//0-10
    
    //Characters
	public Mario mario;
	
	//Objects
	public Block[] blocks = new Block[1];
	public Cloud[] clouds = new Cloud[1];
	public Coin[] coins = new Coin[1];
	public Floor[] floors = new Floor[1];
	public Mountain[] mountains = new Mountain[1];
	public Tube[] tubes = new Tube[1];

	
	private ArrayList<Object> objects;
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xBackground = -50;
		this.dx = 0;
		this.xPos = -1;
		
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
		mario = new Mario(370, 350);
		
		//Objects
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = new Block(0, 0);
		}
		for (int i = 0; i < clouds.length; i++) {
			//	
		}
		for (int i = 0; i < coins.length; i++) {
			//
		}
		for (int i = 0; i < floors.length; i++) {
			//
			floors[i] = new Floor(0, 450);
		}
		for (int i = 0; i < mountains.length; i++) {
			//
		}
		for (int i = 0; i < tubes.length; i++) {
			//
		}
		
		objects = new ArrayList<Object>();
		
		
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		
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
		if (this.xPos >= 0 && this.xPos <= 400) {
			this.xPos = this.xPos + this.dx;
			this.xBackground = this.xBackground - this.dx;
		}
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		if (true) {
			//this.mario.setMovement(false);
			//this.dx=0;
			//marionun herhangi bir engele çarptı mı diye bakıcaz
			//eğer çarptı ise movemet false olcak
			//dx i sıfırla
		}
		this.displacementBackground();
		
		g2.drawImage(this.imgBackground, 0, 0, null); //arka plan sabit
		g2.drawImage(this.imgCastleStart,  this.xPos, 0, null);
		
		g2.drawImage(this.mario.move("mario", 25), this.mario.getX(), this.mario.getY(), null);
		g2.drawImage(this.floors[0].getImgObject(), floors[0].getX(), floors[0].getY(), null);
		
		/*this.tube.displacement();
		
		g2.drawImage(this.imgBg1, this.xBg1, 0, null);
		g2.drawImage(this.imgBg2, this.xBg2, 0, null);

		g2.drawImage(this.imgCastleStart,  10-this.xPos, 95, null);
		g2.drawImage(this.imgStart, 220-this.xPos, 234, null);
		
		g2.drawImage(this.tube.getImgTube(), this.tube.getX(), this.tube.getY(), null);
		g2.drawImage(this.block.getImgBlock(), this.block.getX() - this.xPos, this.block.getY(), null);
		if(this.mario.isMovement()) {
			//g2.drawImage(this.mario.isMovement(), this.mario.getX(), this.mario.getY(), null);
					
		}else {
			g2.drawImage(this.mario.move("mario", 25), this.mario.getX(), this.mario.getY(), null);
		}*/
	}

}
