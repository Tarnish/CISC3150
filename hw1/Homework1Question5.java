/* Ryan Gadalkin : HW1 Q5
   Reference/Citation - https://www.tutorialspoint.com/java/java_string_touppercase.html
**/

import java.util.Scanner;

public class Homework1Question5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double point[][] = new double[3][2];
        double length[] = new double[3];

        do {
            System.out.print("Enter the coordinates of point A. Type it like this -> X Y : ");
            point[0][0] = Double.parseDouble(input.next());
            point[0][1] = Double.parseDouble(input.next());

            System.out.print("Enter the coordinates of point B. Type it like this -> X Y : ");
            point[1][0] = Double.parseDouble(input.next());
            point[1][1] = Double.parseDouble(input.next());

            System.out.print("Enter the coordinates of point C. Type it like this -> X Y : ");
            point[2][0] = Double.parseDouble(input.next());
            point[2][1] = Double.parseDouble(input.next());

            System.out.printf("Point A = (%f, %f), Point B = (%f, %f), Point C = (%f, %f)\n", point[0][0], point[0][1], point[1][0], point[1][1], point[2][0], point[2][1]);

            length[0] = Math.sqrt(Math.pow(point[1][0] - point[0][0], 2) + Math.pow(point[1][1] - point[0][1], 2)); // AB
            length[1] = Math.sqrt(Math.pow(point[2][0] - point[1][0], 2) + Math.pow(point[2][1] - point[1][1], 2)); // BC
            length[2] = Math.sqrt(Math.pow(point[2][0] - point[0][0], 2) + Math.pow(point[2][1] - point[0][1], 2)); // AC

            System.out.printf("[DISTANCE] AB = %f, BC = %f, AC = %f\n", length[0], length[1], length[2]);

            if (length[0] + length[1] > length[2] || length[1] + length[2] > length[0] || length[0] + length[2] > length[1])
                System.out.println("The triangle is real!");
            else
                System.out.println("The triangle is fake!");

            System.out.print("Would you like to enter another set of coordinates (Y/N)? N will exit the program. : ");
        }
        while (input.next().toUpperCase().equals("Y"));
    }
}
