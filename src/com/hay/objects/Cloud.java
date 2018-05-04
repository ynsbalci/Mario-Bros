package com.hay.objects;

<<<<<<< HEAD
public class Cloud extends Object{

	public Cloud(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
=======
import javax.swing.ImageIcon;

public class Cloud extends Object {
	
	//***** CONSTRUCTER *****//
	public Cloud(int x, int y) {	
		super(x, y, 100, 50);
		super.icoObjects = new ImageIcon(getClass().getResource("/images/cloud_1.png"));
		super.imgObjects = this.icoObjects.getImage();
>>>>>>> 3062574405faa82a2fee37c0fb648ffec3d2c681
	}

}
