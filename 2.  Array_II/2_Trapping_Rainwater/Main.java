import java.util.*;

public class Main {

    // Function to calculate trapped rain water
    public static int trappedRainWater(int height[]) {
        // Step 1: Calculate max left boundary for each index
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];  // The first element's left max is itself

        // Calculate left max for every element in the array
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);  // Max of left side up to this point
        }

        // Step 2: Calculate max right boundary for each index
        int rightmax[] = new int[height.length];
        rightmax[height.length - 1] = height[height.length - 1];  // The last element's right max is itself

        // Calculate right max for every element in the array, starting from the end
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);  // Max of right side from this point
        }

        // Step 3: Calculate trapped water for each index
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            // Water level is the minimum of the left and right max heights
            int waterLevel = Math.min(leftmax[i], rightmax[i]);

            // The trapped water at current index is the difference between water level and current height
            trappedWater += waterLevel - height[i];
        }

        // Return the total trapped water
        return trappedWater;
    }

    public static void main(String args[]) {
        // Example input: Array of heights representing the elevation map
        int height[] = {4, 2, 0, 6, 3, 2, 5};

        // Call the function to calculate the trapped water
        int trappedWater = trappedRainWater(height);

        // Print the result
        System.out.println("Total trapped rain water = " + trappedWater);
    }
}
