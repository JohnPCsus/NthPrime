/**
 * 
 */
package main;

/**
 * @author <a href="mailto:johnpettet@csus.edu">John Pettet</a>
 * @version 1.0
 *
 */
public class NthPrime {

	/**
	 * Calculates and returns the integer value of the nth prime number up to
	 * the 100th prime number. A prime number is a number which cannot be
	 * divided except by itself and 1.
	 * 
	 * @param args
	 *            a single integer range between 1 and 100
	 * @return the value of the nth prime number
	 */
	public static void main(String[] args) {

		int n;
		int lastFound = 0;
		int numberFound = 0;

		boolean listAll = Boolean.FALSE;

		String useInstructions = "Please enter one Integer between 1 and 100.";

		// create our array of numbers less than 550 and initialize to TRUE,
		// we assume all numbers are prime unless proven otherwise.
		boolean[] numbers = new boolean[550];
		java.util.Arrays.fill(numbers, Boolean.TRUE);

		if (args.length == 0) {
			n = 100;
			listAll = Boolean.TRUE;

		} else {
			// Here check that only 1 argument was entered by user.
			if (args.length > 1) {
				System.out.println(useInstructions);
				return;
			}
			// if user did not input an integer parseInt() will throw
			// NumberFormatException
			try {
				n = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println(useInstructions);
				return;
			}
			// here we check that the input is in range
			if (n > 100 || n < 1) {
				System.out.println(useInstructions);
				return;
			}
		}
		/**
		 * we start at 2 the first prime number and count upwards by two. the
		 * next number that has not been marked false yet is prime by
		 * definition. we then do the same for each number not yet marked false.
		 * 
		 * we begin marking numbers FALSE at i*i because the product of our new
		 * prime and any other lesser prime must have already been marked off
		 * when we iterated through when i equaled that lesser prime.
		 * 
		 * we stop executing the second loop when i reaches the square root of
		 * the size of our array numbers and assume all remaining numbers are
		 * prime for the same reason as above
		 * 
		 * Improvements: This could be improved by instead multiplying each new
		 * prime by each number still marked TRUE in the sequence, instead of
		 * the"counting by i" approach. This was observed by Euler to eliminate
		 * each non Prime number exactly once.
		 */
		for (int i = 2; (i < numbers.length) && (numberFound < n); i++) {

			if (numbers[i]) {
				lastFound = i;
				numberFound++;
				if (listAll) {
					System.out.println(lastFound + ",");
				}

				if (i * i < numbers.length) {
					for (int j = i * i; j < numbers.length; j += i) {
						numbers[j] = Boolean.FALSE;
					}
				}
			}
		}

		//System.out.println(lastFound);

	}

}
