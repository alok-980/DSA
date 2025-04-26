import java.util.*;

public class Main {

    // Function to perform Selection Sort
    public static void selectionSort(int arr[]) {
        // Outer loop to move boundary of unsorted subarray
        for(int i = 0; i < arr.length - 1; i++) {
            int minPos = i;  // Assume the current position has the minimum

            // Find the minimum element in the unsorted part
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;  // Update index of minimum element
                }
            }

            // Swap the found minimum with the first element of unsorted part
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        // Call selection sort
        selectionSort(arr);

        // Print sorted array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
