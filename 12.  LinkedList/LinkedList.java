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

    // add method to insert a new node at a specific index in the linked list
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
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

    // removeFirst method to remove the first node (head) of the linked list
    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    // removeLast method to remove the last node (tail) of the linked list
    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;

        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iterative method to search for a value in the linked list
    public int iterativeSearch(int key) {
        int i = 0;

        Node temp = head;

        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }

        return -1;
    }

    // Helper function for the recursive search, called to traverse the list
    public int helperFun(Node head, int key, int i) {
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return i;
        }

        return helperFun(head.next, key, i + 1);
    }

    // Recursive method to search for a value in the linked list
    public int recursiveSearch(int key) {

        return helperFun(head, key, 0);
    }

    // reverse function to reverse the LL.
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Find and remove Nth Node from end
    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // find mid in LL using slow fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // slow is my mid node.
    }

    // function to check is LL plandrom
    public boolean cheakPlandrom() {
        if(head == null || head.next == null) {
            return true;
        }

        // step 1 : find mid
        Node midNode = findMid(head);

        // step 2 : reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head

        // step 3 : check the left half and right half
        Node left = head;

        while (right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // detecting cycle in LL
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    // remove cycle from LL
    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static void main(String args[]) {
        // LinkedList ll = new LinkedList();

        // ll.print();

        // ll.addFirst(2);
        // ll.print();

        // ll.addFirst(3);
        // ll.print();

        // ll.addLast(0);
        // ll.print();

        // ll.addLast(-1);
        // ll.print();

        // ll.add(2, 1);
        // ll.print();

        // System.out.println("LL size = " + ll.size);

        // System.out.println(ll.removeFirst());
        // ll.print();
        // System.out.println("LL size = " + ll.size);

        // System.out.println(ll.removeLast());
        // ll.print();
        // System.out.println("LL size = " + ll.size);

        // System.out.println(ll.iterativeSearch(-1));

        // System.out.println(ll.recursiveSearch(2));
        // System.out.println(ll.recursiveSearch(10));

        // ll.deleteNthfromEnd(3);
        // ll.print();

        // ll.reverse();
        // ll.print();

        // ll.addLast(1);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.print();
        // System.out.println(ll.cheakPlandrom());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;

        // System.out.println(isCycle());

        // removeCycle();
        // System.out.println(isCycle());
        
    }
}