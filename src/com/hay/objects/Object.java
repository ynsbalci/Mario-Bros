package com.hay.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

import com.hay.mariobros.Main;

public class Object {
	
	private int width, height;
	private int x, y;
	
	protected Image imgObjects;
	protected ImageIcon icoObjects;
	
	//**** CONSTRUCTER ****//
	public Object(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//**** GETTERS ****//
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public Image getImgObject() {return imgObjects;}
	
	//***** SETTERS *****//
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setWidth(int width) {this.width = width;}
	public void setHeight(int height) {this.height = height;}
	
	//**** FUNCTIONS ****//
	public void displacement(){
		if(Main.scene.getxPos() >= 0){
			this.x = this.x - Main.scene.getDx();
		}
	}
	
}
