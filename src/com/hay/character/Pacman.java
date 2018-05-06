package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

public class Pacman extends Character implements Runnable {

<<<<<<< HEAD
	private Image imgPacman;
	private ImageIcon iconPacman;
	private final int PAUSE=15;
	private int dxPacman;
=======
	private Image imgpacman;
	private ImageIcon iconpacman;
	private final int PAUSE=15;
	private int dxpacman;
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
	
	public Pacman(int x,int y) {
		super(x, y, 27, 30);
		super.setStarboard(true);
		super.setMovement(true);
<<<<<<< HEAD
		this.dxPacman=1;
		
		this.iconPacman=new ImageIcon(getClass().getResource("/images/pacman.png"));
		this.imgPacman=this.iconPacman.getImage();
		
		Thread timePacman=new Thread(this);
		timePacman.start();
=======
		this.dxpacman=1;
		
		this.iconpacman=new ImageIcon(getClass().getResource("hhjjhjhj"));
		this.imgpacman=this.iconpacman.getImage();
		
		Thread timepacman=new Thread(this);
		timepacman.start();
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
	}
	
	
	
	//Getters
<<<<<<< HEAD
	public Image getImgPacman() {
		return imgPacman;
=======
	public Image getImagePacman() {
		return imgpacman;
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
	}

	//Setters

	//Methods
	
	public void move() {
		if(super.isStarboard()==true) {
<<<<<<< HEAD
			this.dxPacman=1;
		}else {
			this.dxPacman=-1;
		}
		super.setX(super.getX()+this.dxPacman);
=======
			this.dxpacman=1;
		}else {
			this.dxpacman=-1;
		}
		super.setX(super.getX()+this.dxpacman);
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
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
<<<<<<< HEAD
			this.dxPacman=-1;
		}else if(super.backContact(object)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxPacman=1;	
=======
			this.dxpacman=-1;
		}else if(super.backContact(object)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxpacman=1;	
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
		}
		
	}
	public void contact(Character character ) {
		if(super.firstContact(character)==true && this.isStarboard()==true) {
			super.setStarboard(false);
<<<<<<< HEAD
			this.dxPacman=-1;
		}else if(super.backContact(character)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxPacman=1;	
=======
			this.dxpacman=-1;
		}else if(super.backContact(character)==true && this.isStarboard()==false) {
			super.setStarboard(true);
			this.dxpacman=1;	
>>>>>>> c9860754088e246539cc41f51c1de4ed279758ca
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
