/* Ryan Gadalkin : HW4
   Reference/Citation - https://stackoverflow.com/questions/17777985/adding-elements-from-each-row-of-jagged-array
                      - https://stackoverflow.com/questions/46374381/print-combinations-of-strings-in-a-jagged-array
                      - https://stackoverflow.com/questions/29656999/find-divisors-and-store-them-in-array
**/

import java.util.Scanner;

public class Homework4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("How many rows in your 2d array : ");
        int maxSize = 1;
        int rows = Integer.parseInt(input.next());
        char[][] myChar = new char[rows][];
        int[] divisor = new int[myChar.length];
        int charIndex;

        for (int i = 0; i < rows; i++) {
            System.out.printf("Length of row [%d] : ", i);
            myChar[i] = new char[Integer.parseInt(input.next())];
            maxSize *= myChar[i].length;

            System.out.printf("Values of array [%d] (separate with spaces) : ", i);
            for (int j = 0; j < myChar[i].length; j++) myChar[i][j] = input.next().charAt(0);
        }

        System.out.printf("Max output = %d\n", maxSize);

        int temp = 1;
        for (int i = myChar.length - 1; i >= 0; i--) {
            divisor[i] = temp;
            temp *= myChar[i].length;
        }

        for (int i = 0; i < maxSize; i++) { // total possible combinations
            for (int j = 0; j < myChar.length; j++) { // get all needed characters for single combination
                charIndex = (i / divisor[j] % myChar[j].length); // divide current combination index by divisor.
                                                                 // use modulo to get correct index from quotient
                System.out.printf("%c", myChar[j][charIndex]);   // print outcome
            }
            System.out.println();
        }

    }

}
