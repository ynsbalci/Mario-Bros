package com.hay.objects;

import javax.swing.ImageIcon;

public class Coin extends Object{

	//***** CONSTRUCTER *****//
	public Coin(int x, int y) {	
		super(x, y, 25, 25);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/coin.png"));
		super.imgObjects = this.icoObjects.getImage();
	}

}
