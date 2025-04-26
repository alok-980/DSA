import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        // Sort the entire array in ascending order
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int arr2[] = {5, 4, 1, 2, 3};

        // Sort a subarray from index 1 to 4 (end index is exclusive)
        Arrays.sort(arr2, 1, 5);  // Sorts elements at index 1 to 4

        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int arr3[] = {5, 4, 1, 2, 3};

        // To sort in descending order, we need to use Integer[] instead of int[]
        // Arrays.sort(arr3, Collections.reverseOrder()); // won't work on primitive int[]

        // Print original array (as descending sort is commented)
        for(int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
