import java.util.*;

public class Main {

    public static void reverse(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int size = q.size() - k;

        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        int i=0;
        while (i < size) {
            q.add(q.remove());
            i++;
        }
    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        reverse(q, 7);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}