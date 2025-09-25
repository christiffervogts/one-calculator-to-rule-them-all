package main;

import javax.swing.JFrame;

public class Main {
	
	static JFrame window = new JFrame();

	public static void main(String[] args) {
		
		window.setSize(300, 400);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(null);
		
		Calc_portal p = new Calc_portal();
		p.Start();
		
		
	}

}
