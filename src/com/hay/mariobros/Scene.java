package com.hay.mariobros;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	private ImageIcon icoFon;
	private Image imgFon1;
	
	private ImageIcon icoMario; //*gecici kod
	private Image imgMario; //* gecici kod
	
	private int xFon1;
	private int dx;
	
	//**** CONSTRUCTOR ****//
	public Scene(){
		super();
		
		this.xFon1 = -50;
		this.dx = 0;
		
		icoFon = new ImageIcon(getClass().getResource(""));
		this.imgFon1 = this.icoFon.getImage();
		icoMario = new ImageIcon(getClass().getResource(""));
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
	public void displacementFon() {this.xFon1 = this.xFon1 - this.dx;}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		this.displacementFon();
		g2.drawImage(this.imgFon1, this.xFon1, 0, null); // Arkaplan resminin cizimi
		g2.drawImage(imgMario, 300, 245, null); //*** gecici kod
	}
}
