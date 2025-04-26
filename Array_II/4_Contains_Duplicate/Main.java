import java.util.*;

public class Main {

    // Method to check if there are any duplicates in the array
    public static boolean containsDuplicate(int nums[]) {
        // Sorting the array
        Arrays.sort(nums);

        // Iterating through the sorted array and checking for adjacent duplicates
        for (int i = 1; i < nums.length; i++) {
            // If adjacent elements are the same, return true
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        // If no duplicates are found, return false
        return false;
    }

    public static void main(String args[]) {
        // Example array with duplicates
        int nums[] = {1, 2, 3, 1};

        // Call the method and print the result
        System.out.println(containsDuplicate(nums));  // Output will be true
    }
}
