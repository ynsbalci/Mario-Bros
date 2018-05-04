package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.hay.mariobros.Main;
import com.hay.objects.Object;

public class Character {
	private int width,height;
	private int x,y;
	private boolean movement;
	private boolean starboard;
	public int counter;
	protected boolean life;
	
	public Character(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.counter=0;
		this.movement=false;
		this.starboard=true;;
		this.life = true;
	}

	//**** GETTERS ****//
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public boolean isMovement() {return movement;}
	public boolean isStarboard() {return starboard;}
	public int getCounter() {return counter;}
	public boolean isLife() {return life;}
	
	//**** SETTERS ****//
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setWidth(int width) {this.width = width;}
	public void setHeight(int height) {this.height = height;}
	public void setMovement(boolean movement) {this.movement = movement;}
	public void setStarboard(boolean starboard) {this.starboard = starboard;}
	public void setCounter(int counter) {this.counter = counter;}
	public void setLife(boolean life) {this.life = life;}
	
	//**** FUNCTIONS ****//
	public Image move(String name, int frequence) {
		String str;
		ImageIcon ico;
		Image img;
		
		//hareket ediyormu diye baktý 
		//ona göre spritlar aarýnsan uygun olaný döndürdük
		if (this.movement == false || Main.scene.getxPos() <= 0) {
			if(this.starboard == true) {str = "/images/" + name + "Right.png"; }
			else {str = "/images/" + name + "Left.png"; }
		}
		else {
			this.counter++;
			if(this.counter / frequence == 0) {
				if(this.starboard == true) {str = "/images/" + name + "Right.png"; }
				else {str = "/images/" + name + "Left.png"; }
			}
			else {
				if(this.starboard == true) {str = "/images/" + name + "MoveRight.png"; }
				else {str = "/images/" + name + "MoveLeft.png"; }
			}
			if(this.counter == 2 * frequence) {this.counter = 0;}
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	public void displacement(){
		if(Main.scene.getxPos() >= 0){this.x = this.x - Main.scene.getDx();}
	}
	
	protected boolean firstContact(Object object) {
		if(this.x + this.width < object.getX() || this.x + this.width > object.getX() + 5
			|| this.y + this.height <= object.getY() ||
			this.y >= object.getY() + object.getHeight()){return false;}
		else{return true;}
	}
	
	protected boolean backContact(Object object){
		if(this.x > object.getX() + object.getWidth() ||
			this.x + this.width < object.getX() + object.getWidth() - 5 ||
			this.y + this.height <= object.getY() ||
			this.y >= object.getY() + object.getHeight()){return false;}
		else {return true;}
	}
	
	protected boolean downContact(Object object){
		if(this.x + this.width < object.getX() + 5 ||
			this.x > object.getX() + object.getWidth() - 5 ||
			this.y + this.height < object.getY() || this.y + this.height > object.getY() + 5)
			{return false;}
		else {return true;}
	}
	
	protected boolean upContact(Object object){
		if(this.x + this.width < object.getX() + 5 ||
			this.x > object.getX() + object.getWidth() - 5 ||
			this.y < object.getY() + object.getHeight() ||
			this.y > object.getY() + object.getHeight() + 5){return false;}
		else {return true;}
	}
	
	public boolean near(Object object){
		if((this.x > object.getX() - 10 && this.x < object.getX() + object.getWidth() + 10)
		|| (this.x + this.width > object.getX() - 10 && this.x + this.width < object.getX() +object.getWidth() + 10)){return true;}
		else {return false;}
	}
	
	protected boolean firstContact(Character character){
		if(this.isStarboard() == true){
			if(this.x + this.width < character.getX() ||
			this.x + this.width > character.getX() + 5 ||
			this.y + this.height <= character.getY() ||
			this.y >= character.getY() + character.getHeight()){return false;}
			else{return true;}
		}else{return false;}
	}
	protected boolean backContact(Character character){
		if(this.x > character.getX() + character.getWidth() ||
		this.x + this.width < character.getX() + character.getWidth() - 5 ||
		this.y + this.height <= character.getY() ||
		this.y >= character.getY() + character.getHeight()){return false;}
		else{return true;}
	}
	protected boolean downContact(Character character){
		if(this.x + this.width < character.getX() ||
		this.x > character.getX() + character.getWidth() ||
		this.y + this.height < character.getY() ||
		this.y + this.height > character.getY()){return false;}
		else{return true;}
	}
	public boolean near (Character character){
		if((this.x > character.getX() - 10 &&
			this.x < character.getX() + character.getWidth() + 10) ||
			(this.x + this.width > character.getX() - 10 &&
			this.x + this.width < character.getX() + character.getWidth() + 10)){return true;}
		else{return false;}
	}
	
}
