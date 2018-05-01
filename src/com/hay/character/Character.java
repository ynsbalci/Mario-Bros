package com.hay.character;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hay.mariobros.Main;

public class Character {
	int width,height;
	int x,y;
	boolean movement;
	boolean starboard;
	int counter;
	
	public Character(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		counter=0;
		movement=false;
		starboard=true;;
	}

	//**** GETTERS ****//
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public boolean isMovement() {return movement;}
	public boolean isStarboard() {return starboard;}
	public int getCounter() {return counter;}
	
	//**** SETTERS ****//
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setWidth(int width) {this.width = width;}
	public void setHeight(int height) {this.height = height;}
	public void setMovement(boolean movement) {this.movement = movement;}
	public void setStarboard(boolean starboard) {this.starboard = starboard;}
	public void setCounter(int counter) {this.counter = counter;}
	
	//**** FUNCTIONS ****//
	public Image move(String num, int frequence) {
		String str;
		ImageIcon ico;
		Image img;
		
		//hareket ediyormu diye baktý 
		//ona göre spritlar aarýnsan uygun olaný döndürdük
		if (this.movement == false || Main.scene.getxPos() <= 0) {
			if(this.starboard == true) {str = "/images/" + num + "Right.png"; }
			else {str = "/images/" + num + "Left.png"; }
		}
		else {
			this.counter++;
			if(this.counter / frequence == 0) {
				if(this.starboard == true) {str = "/images/" + num + "Right.png"; }
				else {str = "/images/" + num + "Left.png"; }
			}
			else {
				if(this.starboard == true) {str = "/images/" + num + "MoveRight.png"; }
				else {str = "/images/" + num + "MoveLeft.png"; }
			}
			if(this.counter == 2 * frequence) {this.counter = 0;}
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public boolean Test(Object object) {
		//yazýlack
		return false;
	} 
	
}
