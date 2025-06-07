package Queues.Implement_Stack_using_Deque;
import java.util.*;

public class Main {
    // implement stack using deque
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        // push
        public void push(int data) {
            deque.addLast(data);
        }

        // pop
        public int pop() {
            if (deque.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            return deque.removeLast();
        }

        // peek
        public int peek() {
            if (deque.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            return deque.getLast();
        }

        // is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }
    public static void main(String args[]) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}