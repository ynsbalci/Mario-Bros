package com.hay.mariobros;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Mario extends Character{
	Image imgMario;
	ImageIcon iconMario;
	
	public Mario(int x,int y) { 
		super(x,y,28,50);
		this.iconMario=new ImageIcon("karakter resmi gelecek");// karakter için mevcut resim alýnýyor
		this.imgMario=iconMario.getImage();//Mario'ya atanýyor
	}

	public Image getImgMario() {
		return imgMario;
	}
	

}
