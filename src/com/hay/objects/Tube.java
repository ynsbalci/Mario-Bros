package com.hay.objects;

import javax.swing.ImageIcon;

public class Tube extends Object {
	
	//***** CONSTRUCTER *****//
	public Tube(int x, int y) {	
		super(x, y, 75, 150);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/tube.png"));
		super.imgObjects = this.icoObjects.getImage();
	}
	

}
