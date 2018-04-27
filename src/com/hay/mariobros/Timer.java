package com.hay.mariobros;

public class Timer implements Runnable {
	
	private final int PAUSE = 3;
	
	@Override
	public void run() {
		while (true) {
			Main.scene.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}

	
}
