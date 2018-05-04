package com.hay.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hay.character.Character;

public class Coin extends Character implements Runnable {

	private Image imgcoin;
	private ImageIcon iconcoin;
	private final int PAUSE=15;
	private int dxcoin;
	
	
	public Coin(int x,int y) {
		super(x, y, 27, 30);
		super.setStarboard(true);
		super.setMovement(true);
		this.dxcoin=1;
		
		this.iconcoin=new ImageIcon(getClass().getResource("hhjjhjhj"));
		this.imgcoin=this.iconcoin.getImage();
		
		Thread timecoin=new Thread(this);
		timecoin.start();
	}
	
	//Getters
	public Image getImgcoin() {
		return imgcoin;
	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isStarboard()==true) {
			this.dxcoin=1;
		}else {
			this.dxcoin=-1;
		}
		super.setX(super.getX()+this.dxcoin);
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
			this.dxcoin=-1;
		}else if(super.backContact(object)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxcoin=1;	
		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isStarboard()==true) {
			super.setStarboard(false);
			this.dxcoin=-1;
		}else if(super.backContact(character)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxcoin=1;	
		}
		
	}

}
