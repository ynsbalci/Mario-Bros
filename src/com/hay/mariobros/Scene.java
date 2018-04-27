package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	private ImageIcon icoBg;
	private Image imgBg1;
	
	private ImageIcon icoMario; //*gecici kod
	private Image imgMario; //* gecici kod
	
	private int xBg1;
	private int dx;
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xBg1 = -50;
		this.dx = 0;
		
<<<<<<< HEAD
		icoFon = new ImageIcon(getClass().getResource(""));
		this.imgFon1 = this.icoFon.getImage();
		icoMario = new ImageIcon(getClass().getResource(""));
=======
		icoBg = new ImageIcon(getClass().getResource("/images/bgScreen.png"));
		this.imgBg1 = this.icoBg.getImage();
		icoMario = new ImageIcon(getClass().getResource("/images/marioWalkRight.png"));
>>>>>>> cc217f5e9a4f47c3715d6b158122c26beb99e0e8
		this.imgMario = this.icoMario.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		//this.addKeyListener(new Keyboard());
		
		Thread timerScreen = new Thread(new Timer());
		timerScreen.start();
	}
	//**** GETTERS ****//
	public int getDx() {return dx;}
	
	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	//**** FUNCTIONS ****//
	public void displacementBg() {this.xBg1 = this.xBg1 - this.dx;}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		this.displacementBg();
		g2.drawImage(this.imgBg1, this.xBg1, 0, null); // Arkaplan resminin cizimi
		g2.drawImage(imgMario, 300, 245, null); //*** gecici kod
	}
}
