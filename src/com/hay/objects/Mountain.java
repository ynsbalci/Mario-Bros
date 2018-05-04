package com.hay.objects;

import javax.swing.ImageIcon;

import com.hay.mariobros.Main;

public class Mountain extends Object{

	//***** CONSTRUCTER *****//
	public Mountain(int x, int y) {	
		super(x, y, 300, 200);
		String str = "/images/mountain_1.png";
		if (Main.scene.rand.nextInt(1) == 1) 
			str = "/images/mountain_2.png";
		super.icoObjects = new ImageIcon(getClass().getResource(str));
		super.imgObjects = this.icoObjects.getImage();
	}

}
