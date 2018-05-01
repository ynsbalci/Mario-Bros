package com.hay.mariobros;

import javax.swing.JFrame;

public class Main {

	public static Scene scene;
	
	public static void main(String[] args) {
		
		//
		JFrame window = new JFrame("Mario Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(true);
		
		//
		scene = new Scene();
		//
		window.setContentPane(scene);
		window.setVisible(true);
		

	}

}
