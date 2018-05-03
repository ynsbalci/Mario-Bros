package com.hay.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Cloud extends Object {
	
	private Image imgCloud;
	private ImageIcon icoCloud;
	
	public Cloud(int x, int y) {	
		//arka pplan bulutklarý
		super(x, y, 43, 65);
		this.icoCloud = new ImageIcon(getClass().getResource("/images/cloud.png"));
		this.imgCloud = this.icoCloud.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgCloud() {return imgCloud;}


}
