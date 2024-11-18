import java.util.*;

public class Main {

    public static int maxSubArray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        System.out.print(prefix[0] + " ");

        for(int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i]; 
            System.out.print(prefix[i] + " ");
        }
        System.out.println();

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int currSum = 0;
                currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1]; 
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 10};
        int maxSum = maxSubArray(arr);
        System.out.println("max sum = " + maxSum);
    }
}