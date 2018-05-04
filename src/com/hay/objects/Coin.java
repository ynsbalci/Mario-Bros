package com.hay.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Coin extends Object implements Runnable{

	private int counter;
	private final int PAUSE=15;

	public Coin(int x, int y) {
		super(x, y, 30, 30);
		// TODO Auto-generated constructor stub
		super.icoObjects=new ImageIcon(getClass().getResource("/images/coin_1.png"));
		super.imgObjects=super.icoObjects.getImage();
	}
	public Image move() {
		String str;
		ImageIcon icon;
		Image img;
		
		this.counter++;
		
		if (this.counter/100==0) {
			str="/images/coin_1.png";
		}else {
			str="/images/coin_2.png";
		}
		if (this.counter==200) {
			this.counter=0;
		}
		
		icon=new ImageIcon(getClass().getResource(str));
		img=icon.getImage();
		
		return img;
	}
	@Override
	public void run() {
		 try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 while (true) {
			this.move();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
