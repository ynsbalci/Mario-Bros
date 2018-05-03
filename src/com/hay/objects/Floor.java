package com.hay.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Floor extends Object {
	
	private Image imgFloor;
	private ImageIcon icoFloor;
	
	public Floor(int x, int y) {	
		//içine girdiði tüpler kýrmýzýlar 
		super(x, y, 43, 65);
		this.icoFloor = new ImageIcon(getClass().getResource("/images/floor.png"));
		this.imgFloor = this.icoFloor.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgFloor() {return imgFloor;}

}
