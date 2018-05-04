package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

public class Pacman extends Character implements Runnable {

	private Image imgturtle;
	private ImageIcon iconturtle;
	private final int PAUSE=15;
	private int dxturtle;
	
	public Pacman(int x,int y) {
		super(x, y, 27, 30);
		super.setStarboard(true);
		super.setMovement(true);
		this.dxturtle=1;
		
		this.iconturtle=new ImageIcon(getClass().getResource("hhjjhjhj"));
		this.imgturtle=this.iconturtle.getImage();
		
		Thread timeturtle=new Thread(this);
		timeturtle.start();
	}
	
	
	
	//Getters
	public Image getImgturtle() {
		return imgturtle;
	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isStarboard()==true) {
			this.dxturtle=1;
		}else {
			this.dxturtle=-1;
		}
		super.setX(super.getX()+this.dxturtle);
	}
	
	
	



	@Override
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			this.move();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void contact(Object object ) {
		if(super.firstContact(object)==true && this.isStarboard()==true) {
			super.setStarboard(false);
			this.dxturtle=-1;
		}else if(super.backContact(object)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxturtle=1;	
		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isStarboard()==true) {
			super.setStarboard(false);
			this.dxturtle=-1;
		}else if(super.backContact(character)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxturtle=1;	
		}
		
	}
	
	public Image pattern(){
		String str;
		ImageIcon ico;
		Image img;
		
		str = "";
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}
