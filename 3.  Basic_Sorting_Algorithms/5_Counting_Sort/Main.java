import java.util.*;

public class Main {
    public static void countingSort(int arr[]) {
        // Step 1: Find the largest element
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Step 2: Create count array (frequency array)
        int count[] = new int[largest + 1];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 3: Fill the original array in sorted order using count array
        int j = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        countingSort(arr); // Sort the array using Counting Sort

        // Print the sorted array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
