package main;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculate {

	ArrayList<Double> Inputs;
	ArrayList<Integer> Operations;
	
	public Calculate(ArrayList<Double> Inputs, ArrayList<Integer> Operations) {
		this.Inputs = Inputs;
		this.Operations = Operations;
	}
	
	public double run_calculation() {
		double result = 0;

		for(int i = 0; i < Inputs.size(); i++) {
			double a = Inputs.get(i);
			
			System.out.println("Pre Math");
			System.out.println("a = " + a);
			System.out.println("op = " + Operations.get(i));
			System.out.println("result = " + result);

			
			
			switch(Operations.get(i)) {
			case 0:
				result = add(result, a);
				break;
			case 1: 
				result = add(result, -a);
				break;
			case 2:
				result = multiple(result, a);
				break;
			case 3:
				result = divide(result, a);
				break;
			}
			System.out.println("Post Math Result = " + result);
			
		}
		
		return result;
	}
	
	public double add(double a, double b) {
		return (a+b);
	}
	public double multiple(double a, double b) {
		return (a*b);
	}
	public double divide(double a, double b) {
		return (a/b);
	}
	public int exponate(double a, double b) {
		double result = 1;
		for (int i = 0; i < b; i++){
			result *= a;
		}
		return (int)result;
	}
	public double root(double a, double b) {//a=index, b=radicand
		double result = a;
		int decimals = NumberOfDecimalPoints(a);
		for(double i = 0; i < 50; i++) {
			result = (1/a)*(((a-1)*(result))+((b)/(exponate(result, (a-1)))));
			result = trunkate(result, decimals);
		}
		
		return result;
	}
	
	public double mod(double a, double b) {
		return (a%b);
	}
	
	public double trunkate(double a, int b) {
		
		String number = Double.toString(a);
		StringBuilder sb = new StringBuilder(10);
		sb.append(number);
		int decimal = sb.indexOf(".");
		for(int i = b; i < decimal; i++) {			
			sb.replace(i, i, "0");
		}
		sb.delete(decimal, sb.length());
		double result = Double.parseDouble(sb.toString());
		
		return result;
	}
	public int NumberOfDecimalPoints(double a) {
		return BigDecimal.valueOf(a).precision();
	}
}
