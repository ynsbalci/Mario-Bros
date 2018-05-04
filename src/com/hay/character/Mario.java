package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;
import com.hay.mariobros.Main;
import com.hay.objects.Coin;

public class Mario extends Character{
	private Image imgMario;
	private ImageIcon iconMario;
	private boolean jump;
	private int jump_counter;
	
	public Mario(int x,int y) { 
		super(x, y, 60, 100);
		this.iconMario=new ImageIcon("/images/mario.png");// karakter için mevcut resim alýnýyor
		this.imgMario=iconMario.getImage();//Mario'ya atanýyor
		this.jump=false;
		this.jump_counter=0;
	}
	
	//**** GETTERS ****//
	public Image getImgMario() {return imgMario;}
	public boolean isJump() {return jump;}
	
	//**** SETTERS ****//
	public void setJump(boolean jump) {this.jump = jump;}
	
	//**** METHODES ****//
	public Image movement(String name, int frequency){
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.isMovement() == false || Main.scene.getxPos() <= 0 ||
		Main.scene.getxPos() > 4430){
			if(this.isStarboard() == true){str = "" + name + "";}
			else{str = "" + name + "";}
		}else{
			this.counter++;
			if(this.counter / frequency == 0){
				if(this.isStarboard() == true){str = "" + name + "";}
				else{str = "" + name + "";}
			}else{
				if(this.isStarboard() == true){str = "" + name + "";}
				else{str = "" + name + "";}
			}
			if(this.counter == 2 * frequency) { this.counter = 0;}
		}
		ico = new ImageIcon(str);
		img = ico.getImage();
		return img;
	}
	public Image jumping() {
		
		ImageIcon icon;
		Image img;
		String str;
		
		this.jump_counter++;
		if(this.jump_counter<=40) {
			if(this.getY() > Main.scene.getCeilingheater()){this.setY(this.getY()-4);}
			else {this.jump_counter=41;}
			if(this.isStarboard()==true) {str="dsfds";}
			else {str="fsfds";}
		
		}else if(this.getY() + this.getHeight() < Main.scene.getySol()){
				this.setY(this.getY() + 1);
			if(this.isStarboard() == true){str = "";}
			else{str = "";}
			
		}else{
			if(this.isStarboard() == true){str = "";}
			else{str = "";}
			this.jump = false;
			this.jump_counter = 0;
		}
		
		icon=new ImageIcon(getClass().getResource(str));
		img=icon.getImage();
		return img;
	}
	
	public void contact(Object object){
		
		if((super.firstContact(object) == true && this.isStarboard() == true) ||
		(super.backContact(object) == true && this.isStarboard() == false)){
			Main.scene.setDx(0);
			this.setMovement(false);
		}
		
		if(super.downContact(object) == true && this.jump == true){
			Main.scene.setySol(object.getY());
		}else if(super.downContact(object) == false){
			Main.scene.setySol(293);;
			if(this.jump == false){this.setY(243);}
		}
		if(super.upContact(object) == true){
			Main.scene.setCeilingheater(object.getY() + object.getHeight());
		}else if(super.upContact(object) == false && this.jump == false){
			Main.scene.setCeilingheater(0);
		}
	}
	
	public boolean coinContact(Coin coin){
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
		}else if(super.downContact(character) == true){
			character.setMovement(false);
			character.setLife(false);
		}
	}
}
