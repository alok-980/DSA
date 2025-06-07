import java.util.*;

public class Main {

    public static void nextGreater(int arr[]) {
        int nxtGreate[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length - 1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nxtGreate[i] = -1;
            } else {
                nxtGreate[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for(int i=0; i<nxtGreate.length; i++) {
            System.out.print(nxtGreate[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};

        nextGreater(arr);
    }
}