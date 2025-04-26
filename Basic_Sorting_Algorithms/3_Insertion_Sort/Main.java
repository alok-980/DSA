import java.util.*;

public class Main {

    // Function to perform Insertion Sort
    public static void insertionSort(int arr[]) {
        // Start from the second element (i = 1)
        for(int i = 1; i < arr.length; i++) {
            int curr = arr[i];     // Current element to be inserted
            int prev = i - 1;      // Index of previous element

            // Shift all elements greater than curr to one position ahead
            while(prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // Place the current element at its correct position
            arr[prev + 1] = curr;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        // Sort the array using insertion sort
        insertionSort(arr);

        // Print sorted array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
