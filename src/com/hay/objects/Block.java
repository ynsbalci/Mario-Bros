package com.hay.objects;

import javax.swing.ImageIcon;

public class Block extends Object {
	
	//***** CONSTRUCTER *****//
	public Block(int x, int y) {
		super(x, y, 30, 30);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/block.png"));
		super.imgObjects = this.icoObjects.getImage();
	}
	
}
