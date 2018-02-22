/* Ryan Gadalkin : HW3
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
                      - http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/String.java#String.compareTo%28java.lang.String%29
                      - http://en.cppreference.com/w/cpp/language/ascii
                      - https://stackoverflow.com/questions/19237516/convert-int-to-array-char-in-java
**/

import java.util.Scanner;

class MyString {

    private char[] MyString;

    public MyString(char[] chars) {
        MyString = chars;
    }

    public char charAt(int index) {
        return MyString[index];
    }

    public int length() {
        return MyString.length;
    }

    public MyString substring(int begin, int end) {
        char[] tempString = new char[end - begin + 1];
        for (int i = 0; begin + i <= end; i++) tempString[i] = MyString[begin + i];
        return new MyString(tempString);
    }

    public MyString toLowerCase() {
        char[] tempString = new char[MyString.length];
        for (int i = 0; i < MyString.length; i++) tempString[i] = Character.toLowerCase(MyString[i]);
        return new MyString(tempString);
    }

    public MyString toUpperCase() {
        char[] tempString = new char[MyString.length];
        for (int i = 0; i < MyString.length; i++) tempString[i] = Character.toUpperCase(MyString[i]);
        return new MyString(tempString);
    }

    public int compareTo(MyString s) {
        int maxCheck = (MyString.length >= s.length() ? MyString.length : s.length());
        int ascii_My, ascii_Temp, mismatchCounter = 0;

        char[] tempChar = new char[s.length()];

        for (int i = 0; i < s.length(); i++) tempChar[i] = s.charAt(i);

        for (int i = 0; i < maxCheck; i++) {
            if      (i >= MyString.length) { mismatchCounter--; continue; }
            else if (i >= s.length())      { mismatchCounter++; continue; }

            ascii_My = (int) MyString[i];
            ascii_Temp = (int) tempChar[i];

            if (ascii_My != ascii_Temp) return ascii_My - ascii_Temp;
        }
        return mismatchCounter;
    }

    public MyString getMyString(){
        return new MyString(MyString);
    }

    public String toString() {
        return new String(MyString);
    }

    public static MyString valueOf(int i) {
        boolean negative = false;

        if (i == 0) {
            char[] empty = new char[1];
            empty[0] = '0';
            return new MyString(empty);
        }
        else if (i < 0) {
            i = Math.abs(i);
            negative = true;
        }

        int size = (int) ((!negative) ? Math.log10(i) + 1 : Math.log10(i) + 2);
        char[] charArray = new char[size];

        for (int j = charArray.length - 1; j >= 0; j--) { // Work backwards to display order correctly
            if (j == 0 && negative) {
                charArray[j] = '-'; // Final char is '-' if negative
                continue;
            }
            charArray[j] = (char) ('0' + (i % 10)); // Display correctly
            i /= 10; // Remove row
        }
        return new MyString(charArray);
    }

}

public class Homework3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter a string: ");
        MyString userString = new MyString(input.nextLine().toCharArray());
        System.out.println("MyString = " + userString.getMyString());
        System.out.println("Length = " + userString.length());

        System.out.printf("Enter index of string (0 -> %d) : ", userString.length() - 1);
        int userIndex = Integer.parseInt(input.next());
        System.out.printf("Index (%d) = %c\n", userIndex, userString.charAt(userIndex));

        System.out.printf("Enter indexes of submitted string to get substring (%s) (0 -> %d) Format : (Begin# End#): ", userString.getMyString(), userString.length() - 1);
        int userIndexBegin = Integer.parseInt(input.next());
        int userIndexEnd = Integer.parseInt(input.next()); input.nextLine();
        System.out.println("Substring = " + userString.substring(userIndexBegin, userIndexEnd));

        System.out.println("String Uppercase = : " + userString.toUpperCase());
        System.out.println("String Lowercase = : " + userString.toLowerCase());

        System.out.printf("#1 Enter a string to compare to your original string (%s) : ", userString.getMyString());
        MyString userCompareString = new MyString(input.nextLine().toCharArray());
        System.out.println("Compare to output = " + userString.compareTo(userCompareString));

        System.out.printf("#2 Enter a string to compare to your original string (%s) : ", userString.getMyString());
        userCompareString = new MyString(input.nextLine().toCharArray());
        System.out.println("Compare to output = " + userString.compareTo(userCompareString));

        System.out.printf("#3 Enter a string to compare to your original string (%s) : ", userString.getMyString());
        userCompareString = new MyString(input.nextLine().toCharArray());
        System.out.println("Compare to output = " + userString.compareTo(userCompareString));

        System.out.printf("Enter an integer to convert : ");
        int userInt = Integer.parseInt(input.nextLine());
        System.out.println("Converted to : " + MyString.valueOf(userInt));
    }
}