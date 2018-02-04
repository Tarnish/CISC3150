/* Ryan Gadalkin : HW1 Q4
   Reference/Citation - https://stackoverflow.com/questions/16137713/how-do-i-run-a-java-program-from-the-command-line-on-windows
                      - https://technet.microsoft.com/en-us/library/bb490982.aspx
**/

import java.util.Scanner;

public class Homework1Question4 {

    public static void main(String[] args) {

        /*
        1) open command line
        2) cd to the directory 'Homework1Question4.java' was located
        3) javac Homework1Question4.java
        4) java Homework1Question4 < Homework1Question4_input.txt >> Homework1Question4_output.txt
        */

        Scanner input = new Scanner(System.in);
        double inputNumber;

        while (input.hasNext())
        {
            inputNumber = Double.parseDouble(input.next());
            System.out.println(inputNumber);
        }
    }
}
