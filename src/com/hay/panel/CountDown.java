package com.hay.panel;

public class CountDown implements Runnable {
	
	private final int PAUSE = 1000;
	private int timeCounter;
	private String str;
	
	public CountDown(){
		
		this.timeCounter = 100;
		this.str = " ";
		
		Thread countDown = new Thread(this);
		countDown.start();
	}
	
	//GETTERS
	public int getTimeCounter(){return timeCounter;}
	public String getStr(){return str;}
	
	//SETTERS
	
	//METHODES
	@Override
	public void run() {
		while(true){
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			this.timeCounter--;
			this.str = "Kalan zaman : " + this.timeCounter;
		}
		
	}
	
}
