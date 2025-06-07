import java.util.*;

public class Main {

    public static int connectNRopes(int arr1[]) {
        int profit = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<arr1.length; i++) {
            pq.add(arr1[i]);
        }

        while (pq.size() >= 2) {
            int p1 = pq.poll();
            int p2 = pq.poll();

            int p = p1 + p2;

            pq.add(p);

            profit += p;
        }

        return profit;
    }
    public static void main(String args[]) {
        int arr1[] = {4, 3, 2, 6};

        System.out.println(connectNRopes(arr1));
    }
}