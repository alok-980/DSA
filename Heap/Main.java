import java.util.*;

public class Main {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        // add
        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        // peek
        public int peek() {
            return arr.get(0);
        }

        // heapify
        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if(minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // remove
        public int remove() {
            int data = arr.get(0);

            // step 1 - swap 1'st and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 - remove from last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            
            return data;
        }

        // isEmpty
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        // step 1 - build maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(arr, i, n);
        }

        // step 2 - push largest at end
        for(int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    // print nearest K cars
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int disSq;
        int idx;

        Point(int x, int y, int disSq, int idx) {
            this.x = x;
            this.y = y;
            this.disSq = disSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSq - p2.disSq;
        }
    }

    // connecting N ropes min cost
    public static int ropesCost(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();

            cost += min + min2;

            pq.add(min + min2);
        }

        return cost;
    }

    // weakest soldiers
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            }
            else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // maximum sliding window
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            //ascending
            //return this.val - p2.val

            //descending
            return p2.val - this.val;
        }
    }
    public static void main(String args[]) {
        // Heap h = new Heap();

        // h.add(2);
        // h.add(5);
        // h.add(3);
        // h.add(1);

        // h.remove();

        // while(!h.isEmpty()) {
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        // int arr[] = {1, 2, 4, 5, 3};

        // heapSort(arr);

        // for(int i=0; i<arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();

        // for(int i=0; i<pts.length; i++) {
        //     int disSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
        //     pq.add(new Point(pts[i][0], pts[i][1], disSq, i));
        // }

        // for(int i=0; i<k; i++) {
        //     System.out.println("C" + pq.remove().idx);
        // }

        // int rpoes[] = {2, 3, 3, 4, 6};

        // System.out.println("min cost of connecting N ropes = " + ropesCost(rpoes));

        // int army[][]
        
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}