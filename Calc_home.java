package main;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
import java.util.Arrays;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class Calc_home implements ActionListener, KeyListener { // this is cald calc home as a vestige from when this was just a small 
	//calculator project. but this is the Large number calculator, it is only a for fuction calculator, if I get borad I'll comeback and add more
	Calc_portal cp = new Calc_portal();
	
	JButton[] numb = new JButton[10];
	JButton[] func = new JButton[8];
	JTextArea screen = new JTextArea();
	
	String[] name = new String[10];
	String text_area_string = "";
	String last_addition_to_string = "";

	int x;
	int y;
	int sizex;
	int sizey;
	int tracker;
	int place_tracker;
	int number_number_tracker = 0;
	int op_tracker = 0;
	int result_tracker = 0;
	int result_tracker_length;
	int current_number;
	int result_number;
	int left;
	int right;
	int computed;
	int[] number_number = new int[999];
	int[] result = new int[999];
	int[] op = new int[999];
	int number_of_times_devided;
	boolean more_than_one = true;
	boolean last_one_current_number = true;
	public Calc_home() {
		buttons();
	}
	public void reset() {
	    Main.window.getContentPane().removeAll();
	    buttons(); 
	    Main.window.repaint();
	    Main.window.revalidate();
	}
	public void buttons() {
		for (int i = 0; i < numb.length; i++) {
			if(i == 0) {
				x = 110;
				y = 300;
			}
			if (0 < i && i < 4)  {
				
				x = 55*i;
				y = 245;
				
			}
			if (3 < i && i < 7)  {
				
				x = 55*(i-3);
				y = 190;
				
			}	
			if (6 < i) {
				x = 55*(i-6);
				y = 135;
			}
			
			numb[i] = new JButton(""+i);
			numb[i].setSize(50, 50);
			numb[i].setLocation(x, y);
			numb[i].addActionListener(this);
			Main.window.add(numb[i]);

		}
		for (int i = 0; i < func.length; i++) {
			
			switch(i) {
				case 0:
					x = 220;
					y = 300;
					sizex = 50;
					sizey = 50;
					name[i] = "+";
				break;
				case 1:
					x = 220;
					y = 245;
					sizex = 50;
					sizey = 50;
					name[i] = "-";
				break;
				case 2:
					x = 220;
					y = 190;
					sizex = 50;
					sizey = 50;
					name[i] = "X";
				break;
				case 3:
					x = 220;
					y = 135;
					sizex = 50;
					sizey = 50;
					name[i] = "\u00F7";
				break;
				case 4:
					x = 165;
					y = 300;
					name[i] = "=";
				break;
				case 5:
					x = 55;
					y = 300;
					sizex = 50;
					sizey = 50;
					name[i] = "C";
				break;
				case 6:
					x = 55;
					y = 80;
					sizex = 105;
					sizey = 50;
					name[i] = "Portal";
				break;
				case 7:
					x = 165;
					y = 80;
					sizex = 105;
					sizey = 50;
					name[i] = "Ask God";
				break;

			}

			func[i] = new JButton(name[i]);
			func[i].setSize(sizex, sizey);
			func[i].setLocation(x, y);
			func[i].addActionListener(this);
			Main.window.add(func[i]);

		}
		screen();
		Main.window.repaint();
		Main.window.revalidate();


	}
	public void world_counter(String source, int i) {

		
		if (source.contains("number_maker") && more_than_one) {
		    text_area_string = Integer.toString(current_number);
			screen.setText(text_area_string);  
		    System.out.println(current_number);
		}
		if (source.contains("number_maker") && !more_than_one) {
			System.out.println(text_area_string);
			text_area_string = text_area_string.replaceAll(last_addition_to_string, Integer.toString(current_number));
			last_addition_to_string = Integer.toString(current_number);
			screen.setText(text_area_string);  
			System.out.println(text_area_string);

		}		
		if (source.contains("number_changer") &&( i != 4 || i != 5 ) ) { 
			text_area_string = number_number[number_number_tracker-1]  +" " +" "+ name[(int) op[op_tracker]];
			screen.setText(text_area_string);  
		}		
		if (source.contains("number_changer") && i == 4) {
			text_area_string = ""+result_number;
			screen.setText(text_area_string);  
			System.out.println("result!");
		}
	}
	public void screen() {
		
		screen = new JTextArea();
		
		screen.setSize(225, 50);
		screen.setLocation(50,25);
		screen.setVisible(true);
		screen.setEditable(false);
		screen.setBackground(Color.gray);
		Main.window.add(screen);
	}
	
	public void number_maker(int i) { // this is where the numbers get made. since when we type in numbers we type them in 1 -> 13 -> 135
		// all that we are acutlly doing is is saying add 1 -> multiply by 10 the add 3 -> multiply by 10 and add 5 so that is what this does
		current_number = (int) ( i + current_number*10);
		place_tracker++; // this tells us the largest place value
		
		if(place_tracker > 15) { //since java has a limit to how bid a double can be if it gets to larger then 15 digits
			//then it will be devided by 10^15 
			current_number =  (current_number/ (int)(Math.pow(10, 14)));
			
			number_of_times_devided++;
			place_tracker = 1;
		}
		
		more_than_one = false;// bool for screen
		System.out.println("current_number "+current_number);
		world_counter("number_maker", 10);
	}

	public void number_changer(int i) {
			/* everything gets stored in arrays. so say I am trying to add 22+14 this goes by 
			* first you write 22 then it comes down here and you press the "+" button and that gives us i = 0. 
			* Then current number = 22 will change to the array for number position 0 = 22 which is 
			* written as number_number[number_number_tracker] = current number, where number_number is the array for the numbers and 
			* number_number_tracker is the variable used to travle arcross the array. it is called number_number_tracker because 
			* it tracks the possition of the array number_number_tracker. the operation gets stored into op; short for operation.
			* then we go on and type the next number, 14. Once we press the = button the entire number_number array and the op array 
			* come into focuse. the first two numbers in the number_number array are take and assind left and right. Then left and right are
			* preformed whatever operation is needed and put into the result array. then once right > number_number_tracker whatever
			* operation that is needed will be preformed on the result array to give us the result. 
			*/
		if(i <= 3) { // after the number is decided you give it an operation 
			
			more_than_one = false;
			op[op_tracker] = i; 
			number_number[number_number_tracker] = current_number;
			number_number_tracker++;
			op_tracker++;
			current_number = 0;
			world_counter("number_changer", 0);
			
		}

		if (i == 4) {// splits the number_number array into left and right and find the result
		    
			number_number[number_number_tracker] = current_number; 
			number_number_tracker++; 
			current_number = 0;
			tracker = number_number_tracker;

			@SuppressWarnings("unchecked")
			BiFunction<Integer, Integer, Integer>[] operations = new BiFunction[4];
			operations[0] = (a, b) -> a + b;
			operations[1] = (a, b) -> a - b;
			operations[2] = (a, b) -> a * b;
			operations[3] = (a, b) -> b != 0 ? a / b : null;

			int n = 0;
			for (int x = 0; x < number_number_tracker; x += 2) {

			    left  = number_number[x];
			    right = number_number[x + 1];
			    
			    if (n !=0) {
				    if (op[n] == 1) {
				    	left = -number_number[x];
				    }
			    }
			    System.out.println("operands=[" + left + ", " + right + "]");
			    BiFunction<Integer, Integer, Integer> fn = operations[(int) op[n]];
			    result[result_tracker++] = fn.apply(left, right);
			    
			    if (number_of_times_devided != 0) {
			        computed *= number_of_times_devided;
			        System.out.println("BIG NUMBER");
			    }
			    n += 1;
			}        
						
			System.out.println(Arrays.toString(number_number));
			System.out.println(Arrays.toString(op));
			System.out.println(Arrays.toString(result));
			
		for (int t = 0; t < result_tracker; t++) {
			
			result_number += result[t];

		}
		
		System.out.println("OUTPUT:   "+result_number +"  Number number tracker: " + result_tracker_length);

			Arrays.fill(number_number, 0);
			number_number_tracker = 1;
			op_tracker = 0;
			number_number[0] = result[1];
			world_counter("number_changer", i);
			
		}
		if (i == 5) {//this is the clear button and sets all values back to zero
			tracker = 0;
			number_number_tracker = 0;
			op_tracker = 0;
			result_tracker = 0;
			Arrays.fill(number_number, 0);
			Arrays.fill(result, 0);
			Arrays.fill(op, 0);
			left = 0;
			right = 0;
			computed = 0;
			number_of_times_devided = 0;
		}
		if (i == 6) {//this sets us back to the portal
			for (int n = 0; n <func.length; n++) {
			Main.window.remove(func[n]);
			}
			for (int n = 0; n <numb.length; n++) {
			Main.window.remove(numb[n]);
			}
			Main.window.remove(screen);
			cp.Start();
		}
		if (i == 7) {//this is just a basic random number genrator
			result_number = (int) (Math.random() * 101); 

			System.out.println("OUTPUT:   "+result_number +"  Number number tracker: " + result_tracker_length);

		}
	}
	public void actionPerformed(ActionEvent e) {// when a button is pressed the next step gets decided
		for(int i = 0; i < numb.length; i++) {
			if (e.getSource() == numb[i]) {//sends it down to make it into a number
				number_maker(i);
			}
		}
		for(int i = 0; i < func.length; i++) {
			if (e.getSource() == func[i]) {//tells us it is an operation
				number_changer(i);
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
