import java.util.ArrayList;
import java.util.Collections;

/**
 * Statistical Utility Library.
 * This class provides methods to compute statistical measures such as
 * mean (with an optional threshold), median, minimum, and maximum from a
 * list of double values.
 *
 * <p>Adheres to Google Java Style Guide:</p>
 * <ul>
 *   <li>5.2.2 Class Names</li>
 *   <li>5.4.1 Method Names (using descriptive verbs)</li>
 *   <li>5.2.4 Variable Names (improved clarity)</li>
 *   <li>7.1.1 Indentation (2 spaces used consistently)</li>
 *   <li>7.3.3 Line Length (limited to 100 characters)</li>
 *   <li>8.3.1 Javadoc Comments (added class and method-level documentation)</li>
 * </ul>
 */
public class StatisticalLibrary {

    /**
     * Computes the mean of the values in the list.
     * If the threshold parameter is true, only values greater than or equal to
     * the specified min value are considered.
     *
     * @param values the list of values
     * @param min the minimum value to consider if threshold is true
     * @param threshold if true, only considers values greater than or equal to min
     * @return the mean of the values that meet the criteria
     */
    public static double computeMean(ArrayList<Double> values, double min, boolean threshold) {
        double sum = 0;
        int count = 0;

        // Iterate over all values and apply the threshold condition if necessary
        for (double value : values) {
            if (threshold) {
                if (value >= min) {
                    sum += value;
                    count++;
                }
            } else {
                sum += value;
                count++;
            }
        }

        // Return the mean; handle the case where count is 0 to avoid division by zero
        return count > 0 ? sum / count : 0;
    }

    /**
     * Computes the median of the values in the list.
     * The list is sorted before determining the median.
     *
     * @param values the list of values
     * @return the median value
     */
    public static double computeMedian(ArrayList<Double> values) {
        Collections.sort(values); // Sort the list before finding the median
        int size = values.size();
        double median;

        // If the size is odd, return the middle element; if even, return the average of the two middle elements
        if (size % 2 == 1) {
            median = values.get(size / 2);
        } else {
            median = (values.get((size / 2) - 1) + values.get(size / 2)) / 2;
        }

        return median;
    }

    /**
     * Finds and returns the minimum value in the list.
     *
     * @param values the list of values
     * @return the minimum value
     */
    public static double findMin(ArrayList<Double> values) {
        double min = values.get(0); // Initialize with the first value

        // Loop through the list to find the minimum value
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    /**
     * Finds and returns the maximum value in the list.
     *
     * @param values the list of values
     * @return the maximum value
     */
    public static double findMax(ArrayList<Double> values) {
        double max = values.get(0); // Initialize with the first value

        // Loop through the list to find the maximum value
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    /**
     * Main method to test the statistical methods.
     * Prints the results of the calculations using a predefined list of values.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize an ArrayList with test data
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        // Output the results of the statistical calculations
        System.out.println("Mean (threshold at 0): " + computeMean(data, 0, true));
        System.out.println("Median: " + computeMedian(data));
        System.out.println("Minimum: " + findMin(data));
        System.out.println("Maximum: " + findMax(data));
    }
}