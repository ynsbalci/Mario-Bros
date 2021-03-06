package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.audio.Audio;
import com.hay.objects.Object;
import com.hay.mariobros.Main;


public class Mario extends Character{
	private Image imgMario;
	private ImageIcon iconMario;
	private boolean jump;
	private int jump_counter;
	private int death_counter;
	
	public Mario(int x,int y) { 
		super(x, y, 28, 50);
		super.setRight(true);
		super.setMovement(false);
		this.iconMario=new ImageIcon("/images/marioMoveRight.png");
		this.imgMario=iconMario.getImage();
		this.jump=false;
		this.jump_counter=0;
		this.death_counter=0;
	}
	
	//**** GETTERS ****//
	public Image getImgMario() {return imgMario;}
	
	public boolean isJump() {return jump;}
	
	//**** SETTERS ****//
	public void setJump(boolean jump) {this.jump = jump;}
	
	//**** METHODES ****//
	public Image jumping() {
		
		ImageIcon icon;
		Image img;
		String str = "";
		
		this.jump_counter++;
		if(this.jump_counter<=40) {
			if(this.getY() > Main.scene.getCeilingHeight()){this.setY(this.getY()-4);}
			else {this.jump_counter = 41; }
			if(this.isRight()==true) {str="/images/marioJumpRight.png";}
			else {str="/images/marioJumpLeft.png";}
		
		}else if(this.getY() + this.getHeight() < Main.scene.getySol()){
				this.setY(this.getY() + 1);
			if(this.isRight() == true){str = "/images/marioJumpRight.png";}
			else{str = "/images/marioJumpLeft.png";}
			
		}else{
			if(this.isRight() == true){str = "/images/marioRight.png";}
			else{str = "/images/marioLeft.png";}
			this.jump = false;
			this.jump_counter = 0;
		}
		
		icon=new ImageIcon(getClass().getResource(str));
		img=icon.getImage();
		return img;
	}
	
	public void contact(Object object){
		
<<<<<<< HEAD
		System.out.println("cont " + object);
		
=======
>>>>>>> 6f10bedfd229e1b8946a25f3662f49e4be3d76cb
		if((super.firstContact(object) == true && this.isRight() == true) ||
		(super.backContact(object) == true && this.isRight() == false)){
			Main.scene.setDx(0);
			this.setMovement(false);
		}
		if(super.downContact(object) == true && this.jump == true){
			Main.scene.setySol(object.getY());
		}
		else if(super.downContact(object) == false){
			Main.scene.setySol(293);
			if(this.jump == false){this.setY(243);}
		}
		if(super.upContact(object) == true){
			Main.scene.setCeilingHeight(object.getY() + object.getHeight());
		}
		else if(super.upContact(object) == false && this.jump == false){
			Main.scene.setCeilingHeight(0);
		}
	}
	
	public boolean coinContact(Object coin){
		if (this.backContact(coin) == true || this.firstContact(coin) == true ||
			this.downContact(coin) == true || this.upContact(coin) == true){
			return true;
		}else{return false;}
	}
	
	public void contact(Character character){
		if((super.firstContact(character) == true) ||
		(super.backContact(character) == true)){
			this.setMovement(false);
			this.setLife(false);
		}
		else if(super.downContact(character) == true){
			character.setMovement(false);
			character.setLife(false);
		}
	}
	
	public Image Die(){
		String str = "";
		ImageIcon ico;
		Image img;
		
		str = "/images/bang.png";
		if(this.death_counter == 0){Audio.playSound("/audios/bang.wav");}
		if(this.death_counter == 100){Audio.playSound("/audios/lost.wav");}
		this.death_counter++;
		if(this.death_counter > 100){
			str = "/images/marioDie.png";
			this.setY(this.getY() - 1);
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
