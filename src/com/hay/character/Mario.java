package com.hay.character;

import java.awt.Image;
import javax.swing.ImageIcon;

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

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}
	
	public Image jumping() {
		ImageIcon iconn;
		Image img;
		String str = null;
		
		this.jump_counter++;
		if(this.jump_counter<=35) {
				if(this.getY()>Main.scene.getHeight())
				{
					this.setY(this.getY()-4);
				}
				else {
				this.jump_counter=36;
				}
				if(this.isStarboard()==true) {
					str="dsfds";//doldurulacak...
				}else {
					str="fsfds";//doldurulacak...
				}
		}
		iconn=new ImageIcon(getClass().getResource(str));
		img=iconn.getImage();
		return img;
	}
	
}
