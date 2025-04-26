import java.util.*;

public class Main {

    // Function to find the largest element in the array
    public static int findLargest(int arr[]) {
        // Initialize the variable 'largest' to the smallest possible value
        int largest = Integer.MIN_VALUE; // This ensures that any number in the array is greater than this initial value

        // Loop through each element of the array
        for(int i = 0; i < arr.length; i++) {
            // If the current element is greater than the current largest, update 'largest'
            if(largest < arr[i]) {
                largest = arr[i]; // Update largest with the current element
            }
        }
        // Return the largest element found in the array
        return largest; // Return the largest number
    }

    public static void main(String args[]) {
        // Define the array
        int arr[] = {2, 6, 8, 0, 4, 3};

        // Call findLargest to find and print the largest element in the array
        System.out.println(findLargest(arr)); // Output the largest element
    }
}
