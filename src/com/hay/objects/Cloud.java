package com.hay.objects;

import javax.swing.ImageIcon;


public class Cloud extends Object{

	public Cloud(int x, int y, int width, int height) {
		super(x, y, width, height);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_1.png"));
		super.imgObjects = this.icoObjects.getImage();

	}

}
