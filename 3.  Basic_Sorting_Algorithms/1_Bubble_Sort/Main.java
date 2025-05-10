import java.util.*;

public class Main {

    // Function to sort the array using Bubble Sort algorithm
    public static void bubbleSort(int arr[]) {
        // Outer loop for number of passes
        for(int i = 0; i < arr.length - 1; i++) {
            // Inner loop for comparing adjacent elements
            for(int j = 0; j < arr.length - 1 - i; j++) {
                // Swap if elements are in the wrong order
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Function to print elements of the array
    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        // Input array
        int arr[] = {5, 4, 1, 2, 3};

        // Sorting the array
        bubbleSort(arr);

        // Printing the sorted array
        printArr(arr);
    }
}
