import java.util.Scanner;

public class challenge1 {

	public static void
	numberGuessingGame()
	{
	
		try (Scanner sc = new Scanner(System.in)) {
			int number = 1 + (int)(10* Math.random());

			int max = 5;

			int i, guessNumber;

			System.out.println("Guess a number between 1 to 10."+" within 5 attempts.");
		
			for (i = 1; i <=max; i++) {

					guessNumber = sc.nextInt();

					if (number == guessNumber) {
					System.out.println("You guessed the number in "+i+" attempts, "
						+ " Well Done!!.");
					break;
				}
				else if (number > guessNumber && i != max - 1) {
					System.out.println("Your guess is low ");
				}
				else if (number < guessNumber && i != max - 1) {
					System.out.println("Your guess  is high ");
				}
			}

			if (i == max) {
				System.out.println("You have exceeded "+max+ " attempts.");

				System.out.println("The number was " + number);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ::: "+e);
		}
	}

	public static void main(String arg[])
	{
		numberGuessingGame();
	}
}
