package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

public class Pacman extends Character implements Runnable {

	private Image imgPacman;
	private ImageIcon iconPacman;
	private final int PAUSE=15;
	private int dxPacman;

	
	public Pacman(int x,int y) {
		super(x, y, 27, 30);
		super.setRight(true);
		super.setMovement(true);
		this.dxPacman=1;
		
		this.iconPacman=new ImageIcon(getClass().getResource("/images/pacmanRight.png"));
		this.imgPacman=this.iconPacman.getImage();
		
		Thread timePacman=new Thread(this);
		timePacman.start();

	}
	
	
	//Getters
	public Image getImgPacman() {
		return imgPacman;

	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isRight()==true) {
			this.dxPacman=1;
		}else {
			this.dxPacman=-1;
		}
		super.setX(super.getX() + this.dxPacman);

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
			this.dxPacman=-1;
		}else if(super.backContact(object)==true && this.isRight()==false) {
			super.setRight(true);
			this.dxPacman=1;	

		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isRight()==true) {
			super.setRight(false);
			this.dxPacman=-1;
		}else if(super.backContact(character)==true && this.isRight()==false) {
			super.setRight(true);
			this.dxPacman=1;	
		}
		
	}
	
	public Image Die(){
		String str;
		ImageIcon ico;
		Image img;
		
		str = "/images/pacmanDie.png";
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}
