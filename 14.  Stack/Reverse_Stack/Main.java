import java.util.*;

public class Main {

    public static void pushAtBottom(Stack<Integer> s, int top) {
        if(s.isEmpty()) {
            s.push(top);
            return;
        }

        int peek = s.pop();
        pushAtBottom(s, top);
        s.push(peek); 
    }

    public static void reversStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();

        reversStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reversStack(s);
        printStack(s);
    }
}