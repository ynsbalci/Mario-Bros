package com.hay.mariobros;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {//Herhangi bir tu�a bas�ld��� zaman tu�lar�n i�levlerine  g�re gerekli i�lemlerin atanmas�
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {//sa� tu�una bas�ld��� zaman yap�lacaklar
			Main.scene.setDx(1);
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)//sol tu�una bas�ld�� zaman yap�lacaklar
		{
			Main.scene.setDx(-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//elimizi tustan cektigimiz anda calisan olaydir
		
		Main.scene.setDx(0);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {//tu�a bas�l� oldu�u m�ddet�ee �al��an olayd�r
		System.out.print("typed");
	}
	
	

}
