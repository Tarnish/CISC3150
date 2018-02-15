/* Ryan Gadalkin : HW2 Q6
   Reference/Citation - https://stackoverflow.com/questions/23726640/using-an-empty-delimiter
**/

import java.util.Scanner;

public class Homework2Question6 {

    public static void main(String[] args)
    {
        /*
        If you're set on tokenizing individual characters with the Scanner class
        you can set the .useDelimiter method to "" -> name.useDelimiter("") or |
        */

        Scanner input = new Scanner(System.in);
        input.useDelimiter("");

        System.out.println("Enter text that will be split into individual characters by the delimiter:");

        while (input.hasNext())
            System.out.println(input.next());
    }
}
