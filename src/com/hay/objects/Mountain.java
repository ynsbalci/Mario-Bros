package com.hay.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mountain extends Object{

	private Image imgMountain;
	private ImageIcon icoMountain;
	
	public Mountain(int x, int y) {	

		super(x, y, 43, 65);
		this.icoMountain = new ImageIcon(getClass().getResource("/images/mountain_1.png"));
		this.imgMountain = this.icoMountain.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgMountain() {return imgMountain;}

}
