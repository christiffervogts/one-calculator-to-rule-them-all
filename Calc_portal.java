package main;

import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Calc_portal implements ActionListener{

	
	JButton[] Types = new JButton[3];
	String Name;
	int x;
	int y;
	int sizex;
	int sizey;

	public Calc_portal() {
	}
	public void Start() {
		Main.window.setSize(350, 350);
		Main.window.setTitle("Calculator Portal");
		Main.window.setIconImage(new ImageIcon("icon/icon/Calc_logo.png").getImage());
		Main.window.repaint();
		Main.window.revalidate();
		for (int i = 0; i < 2; i++) {
			
			switch(i){
			
			case 0:
				Name = "Bignumb";
				x = 10;
				y = 10;
				sizex = 100;
				sizey = 100;
			break;
			case 1:
				Name = "Scientific";
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
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Types[0]) {
			Calc_home ch = new Calc_home();
			Main.window.setSize(300, 400);
			for (int i = 0; i < Types.length; i++) {
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
			for (int i = 0; i < Types.length; i++) {
			Main.window.remove(Types[i]);
			}
			Main.window.setTitle("Scientific");
			Main.window.repaint();
			Main.window.revalidate();
			
			cs.start();
		}

		
	}
}
