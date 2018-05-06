package com.hay.objects;

import javax.swing.ImageIcon;

import com.hay.mariobros.Main;


public class Cloud extends Object{

	public Cloud(int x, int y) {
		super(x, y, 100, 50);
<<<<<<< HEAD
		String str = "/images/cloud_1.png";
		if (Main.scene.rand.nextInt(1) == 1) 
			str = "/images/cloud_2.png";
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_2.png"));
=======
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_1.png"));
>>>>>>> a13b119fbf4d5a53f8e55b1ec31982f06e66b901
		super.imgObjects = this.icoObjects.getImage();

	}

}
