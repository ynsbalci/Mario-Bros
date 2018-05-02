package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Mario extends Character{
	private Image imgMario;
	private ImageIcon iconMario;
	
	public Mario(int x,int y) { 
		super(x, y, 60, 100);
		this.iconMario=new ImageIcon("/images/mario.png");// karakter için mevcut resim alýnýyor
		this.imgMario=iconMario.getImage();//Mario'ya atanýyor
	}
	
	//**** GETTERS ****//
	public Image getImgMario() {return imgMario;}
	
}
