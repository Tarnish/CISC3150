/* Ryan Gadalkin : HW2 Q2
**/

import java.util.Scanner;

public class Homework2Question2 {

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        String[][] month = { { "January", "31" }, { "February", "28" }, { "March",     "31" }, { "April",   "30" }, { "May",      "31"}, { "June",     "30" },
                             { "July",    "31" }, { "August",   "31" }, { "September", "30" }, { "October", "31" }, { "November", "30"}, { "December", "31" } };

        String[] day = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };

        String inputDay;
        int year, dayOfWeek;

        System.out.printf("Enter the year of the calendar to be displayed: ");
        year = Integer.parseInt(input.next());
        System.out.printf("What day is the first of January on (Su/Mo/Tu/We/Th/Fr/Sa): ");
        inputDay = input.next();
        System.out.printf("\n");

        switch (inputDay.toUpperCase())
        {
            case "SU": dayOfWeek = 0; break;
            case "MO": dayOfWeek = 1; break;
            case "TU": dayOfWeek = 2; break;
            case "WE": dayOfWeek = 3; break;
            case "TH": dayOfWeek = 4; break;
            case "FR": dayOfWeek = 5; break;
            case "SA": dayOfWeek = 6; break;
            default:   dayOfWeek = 0; break;
        }

        if (year % 4 == 0) month[1][1] = "29";

        for (int i = 0; i < 12; i++)
        {
            String title = month[i][0] + " " + Integer.toString(year);
            System.out.printf("%" + (11 + (title.length()/2)) + "s\n", title);

            for (int j = 0; j < 7; j++) System.out.printf("%3s", day[j]);
            System.out.printf("\n");

            if (dayOfWeek != 0)
            {
                for (int k = 0; k < dayOfWeek; k++)
                    System.out.printf("%3s", "");
            }

            for (int m = 1; m <= Integer.valueOf(month[i][1]); m++)
            {
                System.out.printf("%3d", m);
                dayOfWeek++;

                if (dayOfWeek == 7)
                {
                    dayOfWeek = 0;
                    System.out.printf("\n");
                }
            }
            System.out.printf("\n\n");
        }
    }
}