package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

public class Sonic extends Character implements Runnable{
	
	private Image imgsonic;
	private ImageIcon iconsonic;
	private final int PAUSE=15;
	private int dxsonic;
	
	public Sonic(int x, int y) {
		super(x, y, 27, 30);//with hwight düznle
		super.setStarboard(true);
		super.setMovement(true);
		this.dxsonic=1;
		
		this.iconsonic=new ImageIcon(getClass().getResource("/images/sonic.png"));
		this.imgsonic=this.iconsonic.getImage();
		
		Thread timesonic=new Thread(this);
		timesonic.start();
	}
	
	
	
	//Getters
	public Image getImgcoin() {
		return imgsonic;
	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isStarboard()==true) {
			this.dxsonic=1;
		}else {
			this.dxsonic=-1;
		}
		super.setX(super.getX()+this.dxsonic);
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
			this.dxsonic=-1;
		}else if(super.backContact(object)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxsonic=1;	
		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isStarboard()==true) {
			super.setStarboard(false);
			this.dxsonic=-1;
		}else if(super.backContact(character)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxsonic=1;	
		}
		
	}
	public Image pattern(){
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.isStarboard() == true){str = " ";}
		else{str = " ";}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}
