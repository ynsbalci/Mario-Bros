package com.hay.mariobros;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Herhangi bir tu�a bas�ld��� zaman tu�lar�n i�levlerine  g�re gerekli i�lemlerin atanmas�
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			if (Main.scene.getxPos() == -1) {
				Main.scene.setDx(1);
				Main.scene.setxPos(0); //d�zenlencek
				Main.scene.setxBg1(0); //d�zenck
				Main.scene.setxBg2(0); ////d�zenl�encek
			}
			Main.scene.mario.setMovement(true); //hareket edebilir 
			//Main.scene.mario.
			Main.scene.setDx(1);
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			Main.scene.mario.setMovement(true); //hareket edebilir
			//Main.scene.mario.
			Main.scene.setDx(-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//elimizi tustan cektigimiz anda calisan olaydir
		Main.scene.setDx(0);	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//tu�a bas�l� oldu�u m�ddet�ee �al��an olayd�r
		
	}
	
	

}
