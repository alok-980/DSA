import java.util.*;

public class Main {

    // Function to find the maximum subarray sum
    public static int maxSubArray(int arr[]) {

        // Initialize the maximum sum to the smallest possible integer
        int maxSum = Integer.MIN_VALUE;

        // Outer loop: iterate through all possible subarrays
        for (int i = 0; i < arr.length; i++) {
            
            // Inner loop: iterate through the end of subarray starting from index 'i'
            for (int j = i; j < arr.length; j++) {

                // Variable to hold the sum of the current subarray
                int currSum = 0;

                // Inner loop: calculate the sum of the current subarray
                for (int k = i; k <= j; k++) {
                    currSum = currSum + arr[k];

                    // Update maxSum if the current sum is larger
                    if (maxSum < currSum) {
                        maxSum = currSum;
                    }
                }

                // Print the current subarray sum
                System.out.print(currSum + " ");
            }

            // Print a newline for separating the subarrays
            System.out.println();
        }

        // Return the maximum sum found
        return maxSum;
    }

    public static void main(String args[]) {

        // Define the array
        int arr[] = {2, 4, 6, 8, 10};

        // Call the function to find the max subarray sum
        int maxSum = maxSubArray(arr);

        // Print the maximum sum
        System.out.println("max sum = " + maxSum);
    }
}
