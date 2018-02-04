/* Ryan Gadalkin : HW1 Q3
   Reference/Citation - https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
**/

import java.util.Random;

public class Homework1Question3 {

    public static void main(String[] args) {
        String[] month = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        Random randomGenerator = new Random();
        int randomNumber;

        for (int i = 0; i <= 50; i++) // Print a large output
        {
            randomNumber = randomGenerator.nextInt(month.length) + 1; // Maximum value + starting position
            System.out.printf("Rolled %2d: \t\tMonth = %s\n", randomNumber, month[randomNumber - 1]);
        }
    }
}
