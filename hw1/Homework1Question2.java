/* Ryan Gadalkin : HW1 Q2
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
**/

import java.util.Scanner;

public class Homework1Question2 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        double radius, area;

        final String promptRadiusMessage = "Enter the radius of the circle to find the area: ";
        System.out.print(promptRadiusMessage);

        while (userInput.hasNext())
        {
            radius = Double.parseDouble(userInput.next());
            area = Math.PI * Math.pow(radius, 2);
            System.out.printf("A circle with a radius of %f has an area of %f\n\n", radius, area);
            System.out.print(promptRadiusMessage);
        }
    }
}
