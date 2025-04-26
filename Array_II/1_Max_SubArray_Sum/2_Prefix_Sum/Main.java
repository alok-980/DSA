import java.util.*;

public class Main {

    // Function to find the maximum subarray sum
    public static int maxSubArray(int arr[]) {
        // Initialize maxSum to the smallest integer value
        int maxSum = Integer.MIN_VALUE;
        
        // Create the prefix sum array
        int prefix[] = new int[arr.length];
        
        // Initialize the first element of the prefix sum array
        prefix[0] = arr[0];
        
        // Print the first element of the prefix sum array
        System.out.print(prefix[0] + " ");
        
        // Calculate the prefix sum for the rest of the elements
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];  // Add the current element to the previous prefix sum
            System.out.print(prefix[i] + " ");  // Print the prefix sum array
        }
        
        System.out.println(); // Print a newline after printing the prefix sums
        
        // Loop through all possible subarrays to find the maximum sum
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                // Calculate the sum of the subarray arr[i...j] using the prefix sum array
                int currSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];  // Use prefix sum to calculate the sum
                
                // If the current subarray sum is greater than the maxSum, update maxSum
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        
        // Return the maximum subarray sum found
        return maxSum;
    }

    public static void main(String args[]) {
        // Define the array for which we need to find the maximum subarray sum
        int arr[] = {2, 4, 6, 8, 10};
        
        // Call the maxSubArray function and store the result
        int maxSum = maxSubArray(arr);
        
        // Print the maximum subarray sum
        System.out.println("max sum = " + maxSum);
    }
}
