public class Main {

    // Kadane's algorithm to find the maximum subarray sum
    public static void kadanes(int arr[]) {
        // Initialize max sum (ms) to the minimum possible integer value
        int ms = Integer.MIN_VALUE;  
        // Initialize current sum (cs) to 0
        int cs = 0;  

        // Traverse through the array
        for(int i = 0; i < arr.length; i++) {
            // Add the current element to the current sum
            cs = cs + arr[i];
            
            // If current sum becomes negative, reset it to 0
            if(cs < 0) {
                cs = 0;
            }

            // Update the max sum if the current sum is greater than the previous max sum
            ms = Math.max(cs, ms);
        }

        // Output the maximum sum found
        System.out.println("Max = " + ms);
    }

    public static void main(String args[]) {
        // Example input array
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        // Call the kadanes method
        kadanes(arr);
    }
}


