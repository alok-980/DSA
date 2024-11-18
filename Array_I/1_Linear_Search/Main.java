import java.util.*;

public class Main {

    public static int linearSearch(int arr[], int key) {
        for(int i=0; i<arr.length; i++) {
            if(key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 1, 0, 10};
        int key = 0;

        int idx = linearSearch(arr, key);

        if(idx == -1) {
            System.out.println("key is not matched");
        } else {
            System.out.println("key is matched at index : " + idx);
        }
    }
}