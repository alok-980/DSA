import java.util.*;

public class Main {

    // Function to print all elements of the array
    public static void printArray(int arr[]) {
        // Loop through the array and print each element
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Print each element followed by a space
        }
        System.out.println(); // Print a newline after the entire array
    }

    // Function to reverse the array in place
    public static void reverseArray(int arr[]) {
        int start = 0; // Start index of the array
        int end = arr.length - 1; // End index of the array

        // Loop until the start index is less than the end index
        while(start < end) {
            // Swap the elements at the start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++; // Increment the start index
            end--; // Decrement the end index
        }
    }

    public static void main(String args[]) {
        // Define an array
        int arr[] = {2, 4, 6, 8, 10, 12, 14};

        // Reverse the array
        reverseArray(arr);

        // Print the reversed array
        printArray(arr);
    }
}
