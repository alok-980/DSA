import java.util.*;

public class Main {

    public static int maxSubArray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int currSum = 0;
                for(int k=i; k<=j; k++) {
                    currSum = currSum + arr[k]; 
                    if(maxSum < currSum) {
                        maxSum = currSum;
                    }
                }
                System.out.print(currSum + " ");
            }
            System.out.println();
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 10};
        int maxSum = maxSubArray(arr);
        System.out.println("max sum = " + maxSum);
    }
}