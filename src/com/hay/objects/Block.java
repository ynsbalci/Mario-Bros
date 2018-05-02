package com.hay.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Block extends Object {
	
	private Image imgBlock;
	private ImageIcon icoBlock;
	
	public Block(int x, int y) {
		
		super(x, y, 43, 65);
		this.icoBlock = new ImageIcon(getClass().getResource(""));
		this.imgBlock = this.icoBlock.getImage();
	}
	
	//*****GETTERS*****//
	public Image getImgBlock() {return imgBlock;}
}
