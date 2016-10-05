package hr.fer.zemris.java.tecaj.hw1;

/**
 * Calculates the Nth number of the Hofstadters Q sequence.
 * @author Jasmin Zukić
 *
 */
public class HofstadterQ {
	
	/**
	 * Main method that demonstrates the functionality. Expects one number as a command line argument
	 * which is the Nth number to be found.
	 * @param args Nth number of the sequence to be calculated.
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No arguments given. Try a number bigger than 0.");
			return;
		}
		int number = Integer.parseInt(args[0]);
		if(number < 1) {
			System.out.println("Requested number is smaller than 1. Try again.");
			return;
		}
		long[] hofstadterQ = new long[number];
		hofstadterQ[0] = 1;
		hofstadterQ[1] = 1;
		for(int i = 2; i < number; i++) {
			hofstadterQ[i] = hofstadterQ[(int) (i - hofstadterQ[i-1])]
					+ hofstadterQ[(int) (i - hofstadterQ[i-2])];
		}
		System.out.println("You requested calculation of " + number 
				+ ". number of Hofstadter's Q-sequence. The requested number is " + hofstadterQ[number-1] + ".");
	}
}