/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
public class WeeklyData{

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    private double[] waterData; // array to store week's data


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(double[] input) {
        if (input == null) { // check for null input
            this.waterData = new double[0]; // initialize to empty array
        } else { 
            this.waterData = new double[input.length]; // create new array of same length
            for (int i = 0; i < input.length; i++) { // copy each element
                this.waterData[i] = input[i];
            }
        }
    }



    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        double total = 0; // variable to store running total
        for(double data: waterData){ // enhanced for loop to iterate through array
            total += data; // add each element to total
        }
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        if(waterData.length == 0){
            return 0.0; // return 0.0 for empty array
        }
        else{
            double average = getTotal() / waterData.length; // calculate average
            return average;
        }
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        double max = waterData[0]; // assume first value is max
        for (int i = 1; i < waterData.length; i++){ // loop through array starting from second element
            if(waterData[i]>max){ // compare current element to max
                max = waterData[i]; // update max if current element is greater
            }
        }
        return max;
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        double min = waterData[0]; // assume first value is min
        for (int i = 0; i < waterData.length; i++){ // loop through array
            if(waterData[i]<min){ // compare current element to min
                min = waterData[i]; // update min if current element is smaller
            }
        }
        return min; 
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // builds a string efficiently
        for (int i = 0; i < waterData.length; i++) { // loop through array
        sb.append("Day ").append(i + 1).append(": ").append(waterData[i]).append("\n"); // format each day's data
        }
        return sb.toString(); // return the built string
    }
}
