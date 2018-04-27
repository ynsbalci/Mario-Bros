package com.hay.mariobros;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {//Herhangi bir tuþa basýldýðý zaman tuþlarýn iþlevlerine  göre gerekli iþlemlerin atanmasý
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {//sað tuþuna basýldýðý zaman yapýlacaklar
			Main.scene.setDx(1);
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)//sol tuþuna basýldðý zaman yapýlacaklar
		{
			Main.scene.setDx(-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//elimizi tustan cektigimiz anda calisan olaydir
		
		Main.scene.setDx(0);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {//tuþa basýlý olduðu müddetçee çalýþan olaydýr
		System.out.print("typed");
	}
	
	

}
