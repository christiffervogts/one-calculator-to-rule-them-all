package main;

import javax.swing.JFrame;

public class Main {
	
	static JFrame window = new JFrame();

	public static void main(String[] args) {
		// this is the main function all it does is tell it to go to the calc-portal
		// later I plan to have the ability to have memory and save where you are
		
		Calc_portal p = new Calc_portal();
		p.Start();
		
		
	}

}
