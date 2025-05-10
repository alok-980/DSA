import java.util.*;

public class Main {

    // Linear search function
    public static int linearSearch(int arr[], int key) {
        // Loop through each element of the array
        for(int i = 0; i < arr.length; i++) {
            // If the current element matches the key, return the index
            if(key == arr[i]) {
                return i; // Key is found, return index
            }
        }
        // If the key is not found, return -1
        return -1; // Key not found
    }

    public static void main(String args[]) {
        // Define the array and the key to search for
        int arr[] = {2, 4, 1, 0, 10};
        int key = 0;

        // Call the linearSearch function to find the index of the key
        int idx = linearSearch(arr, key);

        // If idx is -1, it means the key was not found in the array
        if(idx == -1) {
            System.out.println("key is not matched");
        } else {
            // If the key is found, print the index where it was found
            System.out.println("key is matched at index : " + idx);
        }
    }
}
