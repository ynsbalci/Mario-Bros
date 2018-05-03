package com.hay.objects;

import javax.swing.ImageIcon;

public class Mountain extends Object{

	//***** CONSTRUCTER *****//
	public Mountain(int x, int y) {	
		super(x, y, 300, 200);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/mountain_1.png"));
		super.imgObjects = this.icoObjects.getImage();
	}

}
