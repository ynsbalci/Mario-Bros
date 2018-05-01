package com.hay.mariobros;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Herhangi bir tuþa basýldýðý zaman tuþlarýn iþlevlerine  göre gerekli iþlemlerin atanmasý
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			if (Main.scene.getxPos() == -1) {
				Main.scene.setDx(1);
				Main.scene.setxPos(0); //düzenlencek
				Main.scene.setxBg1(0); //düzenck
				Main.scene.setxBg2(0); ////düzenlþencek
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
		//tuþa basýlý olduðu müddetçee çalýþan olaydýr
		
	}
	
	

}
