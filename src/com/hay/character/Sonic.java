package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

public class Sonic extends Character implements Runnable{
	
	private Image imgSonic;
	private ImageIcon iconSonic;
	private final int PAUSE=15;
	private int dxSonic;
	
	public Sonic(int x, int y) {
		super(x, y, 43, 50);//with hwight düznle
		super.setRight(true);
		super.setMovement(true);
		this.dxSonic=1;
		
		this.iconSonic=new ImageIcon(getClass().getResource("/images/sonicRight.png"));
		this.imgSonic=this.iconSonic.getImage();
		
		Thread timesonic=new Thread(this);
		timesonic.start();
	}
	
	
	//Getters
	public Image getImgcoin() {
		return imgSonic;
	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isRight()==true) {
			this.dxSonic=1;
		}else {
			this.dxSonic=-1;
		}
		super.setX(super.getX()+this.dxSonic);
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
		if(super.firstContact(object)==true && this.isRight()==true) {
			super.setRight(false);
			this.dxSonic=-1;
		}else if(super.backContact(object)==true && this.isRight()==false) {
			super.setRight(true);
			this.dxSonic=1;	
		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isRight()==true) {
			super.setRight(false);
			this.dxSonic=-1;
		}else if(super.backContact(character)==true && this.isRight()==false) {
			super.setRight(true);
			this.dxSonic=1;	
		}
		
	}
	
	public Image Die(){
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.isRight() == true){str = "/images/sonicEscape.png";}
		else{str = "/images/sonicDie.png";}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}
