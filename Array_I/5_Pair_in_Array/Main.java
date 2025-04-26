import java.util.*;

public class Main {

    // Function to print all pairs of elements from the array
    public static void arraysPair(int arr[]) {
        // Outer loop iterates through each element of the array except the last
        for(int i = 0; i < arr.length - 1; i++) {
            // Inner loop iterates through the elements after the current element (i)
            for(int j = i + 1; j < arr.length; j++) {
                // Print each pair of elements (arr[i], arr[j])
                System.out.print("( " + arr[i] + ", " + arr[j] + " )");
            }
            // Print a new line after printing all pairs for the current element arr[i]
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // Define an array with some integer values
        int arr[] = {2, 4, 6, 8, 10};

        // Call the arraysPair function to print pairs from the array
        arraysPair(arr);
    }
}
