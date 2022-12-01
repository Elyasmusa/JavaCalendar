import java.util.Scanner;
import java.io.PrintWriter;
/**
 * @param
 *
 */
public class TestDate {
    public static void main(String[] Arg) {
        int month, day, year;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Month, Day, Year: ");
        month = input.nextInt();
        day = input.nextInt();
        year = input.nextInt();

        ExtDate date = new ExtDate(day, month, year);
        Calendar calendar = new Calendar(date);

        int choice;
        do {
            printMenu();
            System.out.print("Enter Your Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(date.printDateMDY());
                    break;
                case 2:
                    System.out.println(date.printDateMY());
                    break;
                case 3:
                    System.out.println(date.getMonthName() + " Has " + date.getNumberOfDaysInMonth() + " days in the year of " + date.getYear());
                    break;
                case 4:
                    System.out.println(date.getDaysRemainingInYear() + " Days are left in " + year);
                    break;
                case 5:
                    System.out.println(date.getDaysPassedInYear() + " Days have passed in " + year);
                    break;
                case 6:
                    System.out.println("Enter days you would like to add: ");
                    int addDays = input.nextInt();
                    date.addDays(addDays);
                    System.out.println("After Addition new date is: " + date.printDateMDY());
                    break;
                case 7:
                    calendar.printCalendarForMonth();
                    break;
                case 8:
                    System.out.println("Enter filename");
                    input.nextLine();
                    String fileName = input.nextLine();
                    try {
                        PrintWriter output = new PrintWriter(fileName);
                        output.println(date.printDateMDY());
                        output.close();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 9);
    }

    public static void printMenu() {
        System.out.println("\nWelcome to the Calendar Program. \n" +
                "Choose among the Following Options:\n" +
                "1. Print Date M-D-Y\n" +
                "2. Print Date M-Y\n" +
                "3. Print number of days in a month \n" +
                "4. Print number of days left in a year\n" +
                "5. Print number of days gone in a year\n" +
                "6. Add days and print new Day\n" +
                "7. Print Calendar\n" +
                "8. Save the data in a file\n" +
                "9. Terminate the Program");
    }
}
