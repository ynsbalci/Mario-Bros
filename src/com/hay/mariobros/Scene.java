package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hay.character.Mario;
import com.hay.objects.Block;
import com.hay.objects.Cloud;
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
    
    
	public Mario mario;
	
	//Blocks
	public Block block0;
	public Block block1;
	public Block block2;
	public Block block3;
	public Block block4;
	
	//Clouds
	public Cloud cloud0;
	public Cloud cloud1;
	public Cloud cloud2;
	public Cloud cloud3;
	public Cloud cloud4;
	
	//Mountains
	public Mountain mountain0;
	public Mountain mountain1;
	public Mountain mountain2;
	public Mountain mountain3;
	public Mountain mountain4;
	
	//Tubes
	public Tube tube0;
	public Tube tube1;
	public Tube tube2;
	public Tube tube3;
	public Tube tube4;
	
	private ArrayList<Object> objects;
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xBackground = -50;
		this.dx = 0;
		this.xPos = -1;
		
		//
		icoBackground = new ImageIcon(getClass().getResource("/images/background.png")); //arkaplan resmi
		this.imgBackground = this.icoBackground.getImage();
		icoCastleStart = new ImageIcon(getClass().getResource("/images/castle_start.png")); //başlangıçtaki kule
		this.imgCastleStart = this.icoCastleStart.getImage();	
		icoStart = new ImageIcon(getClass().getResource("/images/start.png")); //ok işareti
		this.imgStart = this.icoStart.getImage();
		icoCastleFinish = new ImageIcon(getClass().getResource("/images/castle_finish.png")); //başlangıçtaki kule
		this.imgCastleFinish = this.icoCastleFinish.getImage();
		icoFinish = new ImageIcon(getClass().getResource("/images/finish.png")); //ok işareti
		this.imgFinish = this.icoFinish.getImage();
		
		//mario = new Mario(300, 100);

		//Blocks
		block0 = new Block(0, 0);
		block1 = new Block(0, 0);
		block2 = new Block(0, 0);
		block3 = new Block(0, 0);
		block4 = new Block(0, 0);
		
		//Clouds
		cloud0 = new Cloud(0, 0);
		cloud1 = new Cloud(0, 0);
		cloud2 = new Cloud(0, 0);
		cloud3 = new Cloud(0, 0);
		cloud4 = new Cloud(0, 0);
		
		//Mountains
		mountain0 = new Mountain(0, 0);
		mountain1 = new Mountain(0, 0);
		mountain2 = new Mountain(0, 0);
		mountain3 = new Mountain(0, 0);
		mountain4 = new Mountain(0, 0);
		
		//Tubes
		tube0 = new Tube(0, 0);
		tube1 = new Tube(0, 0);
		tube2 = new Tube(0, 0);
		tube3 = new Tube(0, 0);
		tube4 = new Tube(0, 0);
		
		objects = new ArrayList<Object>();
		
		//Blocks
		this.objects.add(block0);
		this.objects.add(block1);
		this.objects.add(block2);
		this.objects.add(block3);
		this.objects.add(block4);
		//Clouds
		this.objects.add(cloud0);
		this.objects.add(cloud1);
		this.objects.add(cloud2);
		this.objects.add(cloud3);
		this.objects.add(cloud4);
		//Mountains
		this.objects.add(mountain0);
		this.objects.add(mountain1);
		this.objects.add(mountain2);
		this.objects.add(mountain3);
		this.objects.add(mountain4);
		//Tubes
		this.objects.add(tube0);
		this.objects.add(tube1);
		this.objects.add(tube2);
		this.objects.add(tube3);
		this.objects.add(tube4);
		
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
