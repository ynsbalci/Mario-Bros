package com.hay.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tube extends Object {
	
	private Image imgTube;
	private ImageIcon icoTube;
	
	public Tube(int x, int y) {	
		//i�ine girdi�i t�pler k�rm�z�lar 
		super(x, y, 43, 65);
		this.icoTube = new ImageIcon(getClass().getResource(""));
		this.imgTube = this.icoTube.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgTube() {return imgTube;}

}
