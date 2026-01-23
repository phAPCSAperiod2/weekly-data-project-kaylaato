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

        Scanner input = new Scanner(System.in); // Scanner for user input

        // -------------------------------------------------------------

        System.out.println("This program helps you track your water intake for the week. 💧"); // welcome message
        System.out.print("Enter how much water (in ounces) do you aim to drink each day? "); // prompt for daily goal
        double dailyGoal = input.nextDouble(); // read daily goal
        System.out.println("Your daily goal: " + dailyGoal + " ounces of water"); // display daily goal

        // -------------------------------------------------------------
        
        double[] weekData = new double[7]; // array to hold 7 days of data

        // -------------------------------------------------------------
        
        for (int i = 0; i < weekData.length; i++) { // loop for each day
            System.out.print("\nEnter water intake in ounces for day " + (i + 1) + ": "); // prompt for daily intake
            double dailyIntake = input.nextDouble(); // read daily intake
            while (dailyIntake < 0) { // validate input
                System.out.print("Invalid input. Please enter a non-negative value for day " + (i + 1) + ": "); // re-prompt
                dailyIntake = input.nextDouble(); // read daily intake again
            }
            weekData[i] = dailyIntake; // store valid intake in array
        }

        // -------------------------------------------------------------
        
        WeeklyData weeklyData = new WeeklyData(weekData); // create WeeklyData object

        // -------------------------------------------------------------
        
        displayWaterIntakeStats(weeklyData); // call method to display stats

        // -------------------------------------------------------------
        
        System.out.println("\nFull Week of Daily Intake:"); // header for daily intake
        System.out.println(weeklyData.toString()); // display daily intake using toString()

        // -------------------------------------------------------------
        
        int daysReachedGoal = 0; // counter for days meeting goal
        for (int i = 0; i < weekData.length; i++) { // loop through week data
            if (weekData[i] >= dailyGoal) { // check if daily intake meets or exceeds goal
                daysReachedGoal++; // increment counter
            }
        }
        System.out.println("You reached your daily goal on " + daysReachedGoal + " out of 7 days."); // display days met goal
        

        if (weeklyData.getAverage() < 56) { // check if average intake is below recommended
            System.out.println("Based on your average intake, you need to drink more water next week!"); // advice message
        } else {
            System.out.println("Based on your average intake, you were very hydrated this week! Keep it up!"); // positive feedback
        }
    }

    /**
     * This method displays the water intake statistics for the week.
     * 
     * @param weeklyData
     */
    public static void displayWaterIntakeStats(WeeklyData weeklyData) {
            System.out.println("\nWeekly Water Intake Analysis:"); // header for analysis
            System.out.println("Total intake: " + weeklyData.getTotal() + " ounces");
            System.out.println("Average daily intake: " + weeklyData.getAverage() + " ounces");
            System.out.println("Minimum daily intake: " + weeklyData.getMin() + " ounces");
            System.out.println("Maximum daily intake: " + weeklyData.getMax() + " ounces");
    }

}