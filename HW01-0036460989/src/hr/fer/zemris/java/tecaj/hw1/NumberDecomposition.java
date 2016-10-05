package hr.fer.zemris.java.tecaj.hw1;

/**
 * Decomposes a number higher than 2 onto its prime factors.
 * @author saaffa
 *
 */
public class NumberDecomposition {
	
	/**
	 * Main method that does the decomposition onto prime numbers 
	 * @param args Number that needs to be decomposed.
	 */
	public static void main(String[] args) {
		//TODO ako nema argumenata
		if(args[0] == null) {
			System.out.println("No arguments given. Try a number bigger or equal than 2.");
			return;
		}
		int number = Integer.parseInt(args[0]);
		if(number < 2) {
			System.out.println("Requested number is smaller than 2. Try again.");
			return;
		}
		
		System.out.println("You requested decomposition of number " + number 
				+ " onto prime factors. Here they are:");
		
		int counter = 1;
		int modulo = 2;
		while(modulo <= Math.floor(Math.sqrt(number))){
			if(number % modulo == 0) {
				System.out.println(counter + ". " + modulo);
				counter++;
				number /= modulo;
				modulo = 2;
				continue;
			}
			modulo++;
		}
		System.out.println(counter + ". " + number);
	}
}
