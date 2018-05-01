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
		
		this.xBg1 = 0;
		this.dx = 0;
		
		icoBg = new ImageIcon(getClass().getResource("/images/background.png")); //buraya resim kelneck
		this.imgBg1 = this.icoBg.getImage();
		icoMario = new ImageIcon(getClass().getResource("")); //buraya reismekleneck
		this.imgMario = this.icoMario.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		
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
		g2.drawImage(imgMario, 300, 245, null); //*** sayılar düzenlenck
	}
}
