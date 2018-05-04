package com.hay.objects;

import javax.swing.ImageIcon;

public class Floor extends Object {
	
	//***** CONSTRUCTER *****//
	public Floor(int x, int y) {	
		super(x, y, 200, 50);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/floor.png"));
		super.imgObjects = this.icoObjects.getImage();
	}

}
