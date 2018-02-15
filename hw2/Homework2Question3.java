/* Ryan Gadalkin : HW2 Q3
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
                      - https://stackoverflow.com/questions/4138827/check-string-for-palindrome
**/

import java.util.Scanner;

public class Homework2Question3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter a string that will be checked if it is a palindrome: ");
        String text = input.next();

        char[] textSplit = text.toCharArray();
        int startPos = 0, endPos = textSplit.length - 1;

        while (endPos > startPos)
        {
            if (textSplit[startPos] != textSplit[endPos])
            {
                System.out.printf("%s is not a palindrome!", text);
                return;
            }
            startPos++;
            endPos--;
        }
        System.out.printf("%s is a palindrome!", text);
    }
}
