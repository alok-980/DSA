import java.util.*;

public class Main {

    // Function to print subarrays, count the subarray sum, and find the minimum and maximum sum
    public static void findSubArray(int arr[]) {
        // Initialize variables to hold the sum, maximum and minimum sums
        int sum = 0;
        int max = Integer.MIN_VALUE; // Set max to smallest possible value
        int min = Integer.MAX_VALUE; // Set min to largest possible value

        // Outer loop to define the starting index of the subarray
        for(int i = 0; i < arr.length; i++) {
            // Inner loop to define the ending index of the subarray
            for(int j = i; j < arr.length; j++) {
                // Print the subarray from index i to j
                System.out.print("(");

                // Loop to print the elements of the subarray and calculate the sum
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " "); // Print the current element
                    sum = sum + arr[k]; // Add current element to the sum
                }
                System.out.print(")"); // Close the subarray
                System.out.print(" = " + sum + ",  "); // Print the sum of the subarray

                // Find the minimum and maximum sum of the subarrays
                if(min > sum) {
                    min = sum; // Update min if the current sum is smaller
                } else if(max < sum) {
                    max = sum; // Update max if the current sum is larger
                }

                sum = 0; // Reset the sum for the next subarray
            }
            System.out.println(); // Print a new line after each row of subarrays
        }

        // Print the minimum and maximum subarray sums
        System.out.println();
        System.out.println("min = " + min + " & " + "max = " + max);
    }

    public static void main(String args[]) {
        // Define the array
        int arr[] = {12, 4, 6, 8, 10, 40};
        
        // Call the findSubArray function to print subarrays and find the min/max sums
        findSubArray(arr);
    }
}
