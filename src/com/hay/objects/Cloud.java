package com.hay.objects;

import javax.swing.ImageIcon;

public class Cloud extends Object {
	
	//***** CONSTRUCTER *****//
	public Cloud(int x, int y) {	
		super(x, y, 100, 50);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_1.png"));
		super.imgObjects = this.icoObjects.getImage();
	}

}
