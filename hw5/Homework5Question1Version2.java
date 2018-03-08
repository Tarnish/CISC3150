/* Ryan Gadalkin : HW5 Q1
   Reference/Citation - https://stackoverflow.com/questions/3757763/integer-number-too-large-error-message-for-600851475143
                      - https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
                      - https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
                      - https://stackoverflow.com/questions/16205843/java-loop-efficiency
                      - https://stackoverflow.com/questions/7772864/would-java-inline-methods-during-optimization
**/

import java.util.Random;
import java.util.Scanner;

public class Homework5Question1Version2 {

    public static void main(String [] args) {
        long before = System.currentTimeMillis(); // As required by question
        long dotLimit = 4000000000L;
        long insideCircle = 0L;

        double userRadius, squareArea, circleArea, areaRatio1, areaRatio2;

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter radius of circle: ");
        userRadius = Double.parseDouble(input.next());
        squareArea = Math.pow(userRadius, 2.0);
        circleArea = (Math.PI * squareArea) / 4.0;
        areaRatio1 = circleArea / squareArea;

        System.out.printf("User entered radius = %f\nQuadrant area = %f\nCircle area = %f\nRatio 1 = %f\nπ = %f\n", userRadius, squareArea, circleArea, areaRatio1, Math.PI);

        Random randomValues = new Random();
        double x, y;
        for (long i = 0L; i < dotLimit; i++) {
            x = randomValues.nextDouble() * userRadius;
            y = randomValues.nextDouble() * userRadius;

            if (Math.hypot(x, y) <= userRadius || x == 0.0 || y == 0.0) insideCircle++;
        }

        System.out.println("Computed dots inside circle = " + insideCircle);
        System.out.println("Computed dots outside circle = " + (dotLimit - insideCircle));

        areaRatio2 = (double) insideCircle / dotLimit;
        System.out.printf("Post Ratio = %f\nPost π = %f\n", areaRatio2, (areaRatio2 * 4));

        System.out.println(System.currentTimeMillis() - before); // As required by question
    }
}
