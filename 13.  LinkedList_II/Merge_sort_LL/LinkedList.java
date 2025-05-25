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

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    
    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();

        ll.head = ll.mergeSort(ll.head);

        ll.print();
        
    }
}