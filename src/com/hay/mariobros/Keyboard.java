package com.hay.mariobros;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Herhangi bir tuþa basýldýðý zaman tuþlarýn iþlevlerine  göre gerekli iþlemlerin atanmasý
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			if (Main.scene.getxPos() == -1) {
				Main.scene.setxPos(0);
			}
			//Main.mario.set;
			Main.scene.setDx(1);
			
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if (Main.scene.getxPos() == 401) {
				Main.scene.setxPos(400);
			}
			//Main.mario.set;
			Main.scene.setDx(-1);
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			//Main.scene.mario.setJump(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//elimizi tustan cektigimiz anda calisan olaydir
		//Main.scene.mario.setMovement(false);
		Main.scene.setDx(0);	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//tuþa basýlý olduðu müddetçee çalýþan olaydýr
		
	}
	
	

}
