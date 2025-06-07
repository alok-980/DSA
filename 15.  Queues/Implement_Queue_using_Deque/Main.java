import java.util.*;

public class Main {
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        // add
        public void add(int data) {
            deque.addLast(data);
        }

        // remove
        public int remove() {
            if(deque.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.removeFirst();
        }

        // peek
        public int peek() {
            if(deque.isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return deque.getFirst();
        }

        // isEmpty
        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}