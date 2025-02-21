import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int arr2[] = {5, 4, 1, 2, 3};

        Arrays.sort(arr2, 1, 5);
        // Arrays.sort(arr, si, ei)

        for(int i=0; i<arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        //if we want to sort in desending order --> Arrays.sort(arr, Collections.reverseOrder());

        int arr3[] = {5, 4, 1, 2, 3};

        // Arrays.sort(arr3, Collections.reverseOrder());
        
        for(int i=0; i<arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}