/* Ryan Gadalkin : HW1 Q6
   Reference/Citation - https://www.desmos.com/calculator/zs5wfg9uem
                      - https://math.stackexchange.com/questions/198764/how-to-know-if-a-point-is-inside-a-circle
**/

import java.util.Scanner;

public class Homework1Question6 {

    public static class Circle {
        double coordinates[] = new double[2];
        double radius;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        double distance;

        System.out.println("Circle Checker:");

        do {
            System.out.print("Enter the coordinates of the first circle. Type it like this -> X Y : ");
            for (int i = 0; i < 2; i++) circle1.coordinates[i] = Double.parseDouble(input.next());
            System.out.print("Enter the radius of the first circle: ");
            circle1.radius = Double.parseDouble(input.next());

            System.out.print("Enter the coordinates of the second circle. Type it like this -> X Y : ");
            for (int i = 0; i < 2; i++) circle2.coordinates[i] = Double.parseDouble(input.next());
            System.out.print("Enter the radius of the second circle: ");
            circle2.radius = Double.parseDouble(input.next());

            distance = Math.sqrt(Math.pow(circle2.coordinates[0] - circle1.coordinates[0], 2) + Math.pow(circle2.coordinates[1] - circle1.coordinates[1], 2));
            System.out.printf("Circle 1: (%f, %f) R = %f\nCircle 2: (%f, %f) R = %f\nDistance = %f\n", circle1.coordinates[0], circle1.coordinates[1], circle1.radius,
                                                                                                       circle2.coordinates[0], circle2.coordinates[1], circle2.radius, distance);

            if      (distance == 0.0 && circle1.radius == circle2.radius) System.out.println("The circles are exactly the same.");
            else if (distance > circle1.radius + circle2.radius)          System.out.println("The circles are separate from each other.");
            else if (distance == circle1.radius + circle2.radius)         System.out.println("The circles are touching each other.");
            else if (distance + circle1.radius <= circle2.radius)         System.out.println("Circle 1 is within Circle 2.");
            else if (distance + circle2.radius <= circle1.radius)         System.out.println("Circle 2 is within Circle 1.");
            else if (distance < circle1.radius + circle2.radius)          System.out.println("The circles are overlapping each other.");
            System.out.print("Would you like to enter another set (Y/N)? N will exit the program. : ");
        }
        while (input.next().toUpperCase().equals("Y"));
    }
}
