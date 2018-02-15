/* Ryan Gadalkin : HW2 Q1
   Reference/Citation - https://stackoverflow.com/questions/8981649/can-someone-explain-this-java-code-formatting-the-output-using-system-out-forma
**/

import java.util.Scanner;

public class Homework2Question1 {

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int height, spacing;

        System.out.printf("How tall do you want your pyramid to be: ");

        height = Integer.parseInt(input.next());
        spacing = height * 2;

        for (int i = 1; i <= height; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                if (j == 1) System.out.printf("%" + spacing + "s", "");
                System.out.printf("%d ", j);

                if (j == i)
                    for (int k = i - 1; k >= 1; k--)
                        System.out.printf("%d ", k);
            }
            System.out.printf("\n");
            spacing -= 2;
        }
    }
}