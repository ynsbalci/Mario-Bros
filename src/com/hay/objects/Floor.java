package com.hay.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Floor extends Object {
	
	private Image imgFloor;
	private ImageIcon icoFloor;
	
	public Floor(int x, int y) {	
		//i�ine girdi�i t�pler k�rm�z�lar 
		super(x, y, 43, 65);
		this.icoFloor = new ImageIcon(getClass().getResource("/images/floor.png"));
		this.imgFloor = this.icoFloor.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgFloor() {return imgFloor;}

}
