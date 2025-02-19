import java.util.*;

public class Main {
    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = i;
            int prev = i-1;
            while(prev >= 0 && arr[prev] > arr[curr]) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = arr[curr];
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        insertionSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}