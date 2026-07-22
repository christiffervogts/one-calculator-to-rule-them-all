package main;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculate {

	ArrayList<Double> Inputs;
	ArrayList<Integer> Operations;
	
	int StatusCode = 0;
	String[] Statuses = new String[]{"None", "Undefined", "Indeterminate", "Not a Number", 
			"Null", "Complex", "Syntax Error"};
	

	public Calculate(ArrayList<Double> Inputs, ArrayList<Integer> Operations) {
		this.Inputs = Inputs;
		this.Operations = Operations;
	}
	public Result run() {
		
	    return new Result(run_calculation(), run_status_check());
	}
	private double run_calculation() {
		StatusCode = 0;
		double result = 0;
		System.out.println(Operations);

		if(Inputs.size() != Operations.size()) {
			StatusCode = 6;
			System.out.println(Inputs.size());
			System.out.println(Operations.size());
			System.out.println(Statuses[StatusCode]);
		}
		if(Inputs.contains(null) || Operations.contains(null)) {
			StatusCode = 4;
		}
		for(int i = 0; i < Inputs.size(); i++) {
			double a = Inputs.get(i);
			
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
				try {
					result = divide(result, a);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			
		}
		
		return result;
	}
	
	private String run_status_check() {
		
		return Statuses[StatusCode];
	}
	public double add(double a, double b) {
		return (a+b);
	}
	public double multiple(double a, double b) {
		return (a*b);
	}
	public double divide(Double a, Double b){
		if (a.equals(b) && (a.isInfinite() || a == 0)) {
			StatusCode = 2;
		}
		else if(b == 0 || b.isInfinite()) {
			StatusCode = 1;
		}
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
		if(b < 0) {
			StatusCode = 5;
		}
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
