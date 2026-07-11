package main;

import java.util.ArrayList;

public class Calculate {

	ArrayList<Integer> Inputs, Operations;
	
	public Calculate(ArrayList<Integer> Inputs, ArrayList<Integer> Operations) {
		this.Inputs = Inputs;
		this.Operations = Operations;
	}
	
	public int add(int a, int b) {
		return (a+b);
	}
	public int multiple(int a, int b) {
		return (a*b);
	}
	public int divide(int a, int b) {
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
		
		for(double i = 0; i < 50; i++) {
			result = (1/a)*(((a-1)*(result))+((b)/(exponate(result, (a-1)))));
			result = trunkate(result, 5);
			System.out.println(result);
		}
		
		return (double)result;
	}
	public int mod(int a, int b) {
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
	
}
