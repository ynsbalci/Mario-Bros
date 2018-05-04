package com.hay.panel;

public class Score {
	private final int NBRE_TOTAL_COINS = 10;
	private int nbreCoins;
	
	public Score(){
		this.nbreCoins = 0;
	}
	
	//GETTERS
	public int getNbreCoins(){return nbreCoins;}
	public int getNBRE_TOTAL_COINS(){return NBRE_TOTAL_COINS;}
	
	//SETTERS
	public void setNbreCoins(int nbreCoins){this.nbreCoins = nbreCoins;}
}
