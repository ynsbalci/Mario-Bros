package com.hay.objects;

import javax.swing.ImageIcon;

import com.hay.mariobros.Main;


public class Cloud extends Object{

	public Cloud(int x, int y) {
		super(x, y, 25, 30);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_1.png"));
		super.imgObjects = this.icoObjects.getImage();

	}

}
