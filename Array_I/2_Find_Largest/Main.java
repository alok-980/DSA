import java.util.*;

public class Main {

    public static int findLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        //same as it is we can find smallest Integer.MAX_VALUE

        for(int i=0; i<arr.length; i++) {
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String args[]) {
        int arr[] = {2, 6, 8, 0, 4, 3};

        System.out.println(findLargest(arr));
    }
}