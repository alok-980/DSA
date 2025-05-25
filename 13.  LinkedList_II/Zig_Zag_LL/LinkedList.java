public class LinkedList {

    // defining Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Declaring head, tail, and size as static so they're shared across all LinkedList instances
    public static Node head;
    public static Node tail;
    public static int size;

    // addFirst method to insert a new node at the beginning of the linked list
    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // new node next = head
        newNode.next = head;

        // head = new node
        head = newNode;
    }

    // addLast method to insert a new node at the end of the linked list
    public void addLast(int data) {
        //create a new node
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // tail next --> newNode
        tail.next = newNode;

        // tail = newNode
        tail = newNode;
    }


    // print method to display all elements of the linked list
    public void print() {

        //if linkedlist is null
        if(head == null) {
            System.out.println("null");
            return;
        }

        // Assign head to a temporary variable to avoid modifying the actual head of the list
        Node temp = head;

        // Traversing through the linked list
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        // zig zag merge
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();

        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}