import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("This program helps you track your water intake for the week. 💧");

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        double[] weekData = new double[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter water intake in ounces for day " + (i + 1) + ": ");
            double dailyIntake = input.nextDouble();
            while (dailyIntake < 0) {
                System.out.print("Invalid input. Please enter a non-negative value for day " + (i + 1) + ": ");
                dailyIntake = input.nextDouble();
            }
            weekData[i] = dailyIntake;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData weeklyData = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("\nWeekly Water Intake Analysis:");
        System.out.println("Total intake: " + weeklyData.getTotal() + " ounces");
        System.out.println("Average daily intake: " + weeklyData.getAverage() + " ounces");
        System.out.println("Minimum daily intake: " + weeklyData.getMin() + " ounces");
        System.out.println("Maximum daily intake: " + weeklyData.getMax() + " ounces");

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("\nFull Week of Daily Intake:");
        System.out.println(weeklyData.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
        if (weeklyData.getAverage() < 56) {
            System.out.println("You need to drink more water next week!");
        } else {
            System.out.println("Great job staying hydrated this week!");
        }

    }
}
