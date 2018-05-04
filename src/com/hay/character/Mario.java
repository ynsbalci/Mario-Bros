package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.objects.Object;

import com.hay.mariobros.Main;

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
	public Image jumping() {
		
		ImageIcon icon;
		Image img;
		String str = null;
		
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
	
}
