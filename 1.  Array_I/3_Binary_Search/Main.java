import java.util.*;

public class Main {

    // Function to perform binary search
    public static int binarySearch(int arr[], int key) {
        int start = 0; // Set the start index of the array
        int end = arr.length - 1; // Set the end index of the array

        // Continue until start is less than or equal to end
        while(start <= end) {
            int mid = (start + end) / 2; // Find the middle index

            // If the key is found at the middle index, return the index
            if(arr[mid] == key) {
                return mid; // Key is found at 'mid', return the index
            } 
            // If the key is smaller than the middle element, search the left half
            else if(arr[mid] > key) {
                end = mid - 1; // Update 'end' to search in the left half
            } 
            // If the key is larger than the middle element, search the right half
            else {
                start = mid + 1; // Update 'start' to search in the right half
            }
        }

        // If key is not found, return -1
        return -1; // Key not found
    }

    public static void main(String args[]) {
        // Define a sorted array and the key to search for
        int arr[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 8; // Key to search for

        // Call binarySearch to find the index of the key
        int idx = binarySearch(arr, key);

        // If idx is -1, the key was not found, else print the index
        if(idx == -1) {
            System.out.println("key is not matched"); // Key not found
        } else {
            System.out.println("key is matched at index : " + idx); // Key found at the index
        }
    }
}
