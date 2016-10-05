package hr.fer.zemris.java.tecaj.hw1;

/**
 * Lists first N prime numbers which it gets from it's argument.
 * @author Jasmin Zukić
 *
 */
public class PrimeNumbers {
	
	/**
	 * Main method that lists prime numbers in standard output. Expects one argument from 
	 * the command line. Other arguments are ignored.
	 * @param args Number of primes to calculate.
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No arguments given. Try a number bigger or equal than 1.");
			return;
		}
		int number = Integer.parseInt(args[0]);
		if(number < 1) {
			System.out.println("Requested number is smaller than 1. Try again.");
			return;
		}
		
		System.out.println("You requested calculation of " + number 
				+ " prime numbers. Here they are:");
		
		int testNumber = 2;
		boolean prime = false;
		boolean notPrime = false;
		for(int i = 0; i < number; i++) {
			while(!prime) {
				for(int k = 2; k <= Math.floor(Math.sqrt(testNumber)); k++) {
					if(testNumber % k == 0) { 
						notPrime = true;
						break;
					}
				}
				if(notPrime) {
					testNumber++;
					notPrime = false;
				} else {
					prime = true;
				}
			}
			prime = false;
			System.out.println(i+1 + ". " + testNumber);
			testNumber++;
		}
	}
}
