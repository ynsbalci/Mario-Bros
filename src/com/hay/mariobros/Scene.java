package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hay.character.Mario;
import com.hay.objects.Block;
import com.hay.objects.Tube;


@SuppressWarnings("serial")
public class Scene extends JPanel{
	//*****VARIABLES*****//
	private ImageIcon icoBg;
	private Image imgBg1;
	private Image imgBg2;
	private ImageIcon icoCastleStart;
	private Image imgCastleStart;
	private ImageIcon icoStart;
	private Image imgStart;
	private int xBg1;
	private int xBg2;
	private int dx;
	private int xPos;
	private int ysol;
    private int ceilingheater=0;
    	
	public Mario mario;
	public Tube tube;
	public Block block;
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xBg1 = -50;
		this.xBg2 = 750;
		this.dx = 0;
		this.xPos = -1;
		
		icoBg = new ImageIcon(getClass().getResource("/images/background.png")); //arkaplan resmi
		this.imgBg1 = this.icoBg.getImage();
		this.imgBg2 = this.icoBg.getImage();
		
		icoCastleStart = new ImageIcon(getClass().getResource("/images/castle_start.png")); //başlangıçtaki kule
		this.imgCastleStart = this.icoCastleStart.getImage();
		
		icoStart = new ImageIcon(getClass().getResource("/images/start.png")); //ok işareti
		this.imgStart = this.icoStart.getImage();

		mario = new Mario(300, 100);
		tube = new Tube(200, 300);
		block = new Block(300, 250);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		
		Thread timerScreen = new Thread(new Timer());
		timerScreen.start();
	}
	
	//**** GETTERS ****//
	public int getDx() {return dx;}
	public int getxPos() {return xPos;}
	public int getYsol() {return ysol;}
	public int getCeilingheater() {return ceilingheater;}

	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	public void setxPos(int xPos) {this.xPos = xPos;}
	public void setxBg1(int xBg1) {this.xBg1 = xBg1;}
	public void setxBg2(int xBg2) {this.xBg2 = xBg2;}


	//**** FUNCTIONS ****//
	public void displacementBg() {
		//
		if (this.xPos >= 0) {
			this.xPos = this.xPos + this.dx;
			this.xBg1 = this.xBg1 - this.dx;
			this.xBg2 = this.xBg2 - this.dx;
		}
		if (this.xBg1 == -800) {this.xBg1 = 800;}
		else if (this.xBg2 == -800) {this.xBg1 = 800;}
		else if (this.xBg1 == 800) {this.xBg1 = -800;}
		else if (this.xBg2 == 800) {this.xBg1 = -800;}
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		this.displacementBg();
		
		if (true) {
			this.mario.setMovement(false);
			this.dx=0;
			//marionun herhangi bir engele çarptı mı diye bakıcaz
			//eğer çarptı ise movemet false olcak
			//dx i sıfırla
		}
		this.displacementBg();
		this.tube.displacement();
		
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
		}
	}

}
