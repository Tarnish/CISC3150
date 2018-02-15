/* Ryan Gadalkin : HW2 Q5
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
**/

import java.util.Scanner;

public class Homework2Question5 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(",");

        System.out.printf("Enter a list of items that are separated by a comma ',' : ");

        while (input.hasNext())
            System.out.println(input.next());
    }
}
