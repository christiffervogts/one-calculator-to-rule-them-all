package main;

import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Calc_portal implements ActionListener{

	
	JButton[] Types = new JButton[3];
	String Name;
	int x;
	int y;
	int sizex;
	int sizey;

	public void Start() { // This is the starting point for the portal. everything starts here and moves out to the other calculator types
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.window.setVisible(true);
		Main.window.setLayout(null);
		Main.window.setSize(350, 350);
		Main.window.setTitle("Calculator Portal");
		Main.window.setIconImage(new ImageIcon("icon/icon/Calc_logo.png").getImage());
		Main.window.setLocationRelativeTo(null);
		Main.window.repaint();
		Main.window.revalidate();
		for (int i = 0; i < 2; i++) { 
			// Although it seams like over kill for just two types the idea is that this is an easier way of 
			// implementing more types later on.
			
			switch(i){
			
			case 0:
				Name = "Bignumb"; 	// Bignumb is a Large number calculator; this has been abreviated for space; only four functions but
				x = 10;				// "limitless" calculations
				y = 10;
				sizex = 100;
				sizey = 100;
			break;
			case 1:
				Name = "Scientific"; 	//this is a standered scientific calculator with all functinos you'd expect on a ti-30xs
				x = 120;
				y = 10;
				sizex = 100;
				sizey = 100;
			break;			
			}
			
			Types[i] = new JButton(Name);
			Types[i].setSize(sizex, sizey);
			Types[i].setLocation(x, y);
			Main.window.add(Types[i]);
			Types[i].addActionListener(this);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {//logic for the buttons; each button follows the same pattern; 
		//dealte everything -> send user to correct place

		if (e.getSource() == Types[0]) {
			Calc_home ch = new Calc_home();
			Main.window.setSize(300, 400);
			for (int i = 0; i < Types.length-1; i++) {
			Main.window.remove(Types[i]);
			}
			Main.window.setTitle("Large Numbers");
			Main.window.repaint();
			Main.window.revalidate();
			
			ch.reset();
		}
		if (e.getSource() == Types[1]) {
			Calc_Scientific cs = new Calc_Scientific();
			Main.window.setSize(600, 600);
			for (int i = 0; i < Types.length-1; i++) {
			Main.window.remove(Types[i]);
			}
			Main.window.setTitle("Scientific");
			Main.window.repaint();
			Main.window.revalidate();
			
			cs.start();
		}

		
	}
}
