package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {
	
	/**
	 * Main program of this class. Checks number of agruments (0 to 2) and calculates
	 * perimeter and area. If no arguments are given, it asks for an input.
	 * @param args width and height. Other arguments are ignored.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		double width = 0;
		double height =0;
		
		if(args.length == 1) {
			System.out.println("Invalid number of arguments was provided.");
			return;
			
		} else if(args.length == 0) {
			width = inputEdges("width");
			height = inputEdges("height");
			
		} else if(args.length >= 2){
			if(args.length > 2) {
				System.out.println("Too many arguments. I will use only the first two");
			}
			
			width = Double.parseDouble(args[0]);
			height = Double.parseDouble(args[1]);
			
			if(width < 0) {
				System.out.println("First argument (width) is negative.");
				return;
			}
			if(height < 0) {
				System.out.println("Second argument (height) is negative.");
				return;
			}
			
		}
		
		System.out.println(
				"You have specified a rectangle with width " + width + 
				" and height " + height + 
				". Its area is " + width*height + 
				" and its perimeter is " + 2*(width+height) + "."
				);
	}
	
	/**
	 * Reads from standard input (keyboard). Repeats until it's given a number larger than 0.
	 * @param edge width or height
	 * @return length of that edge
	 * @throws IOException
	 */
	public static double inputEdges(String edge) throws IOException {
		double edgeLength = 0;
		String input;
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(System.in)));
		do {
			System.out.println("Please provide " + edge + ":");
			input = reader.readLine().trim();
			if(input.isEmpty()) {
				System.out.println("Nothing was given.");
				continue;
			}
			edgeLength = Double.parseDouble(input);
			if(edgeLength < 0) {
				System.out.println("Number is negative");
				continue;
			} else break;
		}while(true);
		
		return edgeLength;
	}
	
}