import java.util.*;

public class Main {

    public static int binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;

            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 8;

        int idx = binarySearch(arr, key);

        if(idx == -1) {
            System.out.println("key is not matched");
        } else {
            System.out.println("key is matched at index : " + idx);
        }
    }
}