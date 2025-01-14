// print SubArray, count the SubArray sum and find the MIN & MAX

import java.util.*;

public class Main {

    public static void findSubArray(int arr[]) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //printing subarray
        for(int i = 0; i<arr.length; i++) {
            for(int j = i; j<arr.length; j++) {
                System.out.print("(");
                for(int k = i; k<=j; k++) {
                    System.out.print(arr[k] + " ");

                    //counting the subarray sum
                    sum = sum + arr[k];
                }
                System.out.print(")");
                System.out.print(" = " + sum + ",  ");

                //finding MIN & MAX
                if(min > sum) {
                    min = sum;
                } else if(max < sum) {
                    max = sum;
                }
                sum = 0;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("min = " + min + " & " + "max = " + max);
    }

    public static void main(String args[]) {
        int arr[] = {12, 4, 6, 8, 10, 40};
        findSubArray(arr);
    }
}