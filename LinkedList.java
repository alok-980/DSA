public class LinkedList {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode head;
    public static ListNode tail;

    public static int size;

    // add first
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add last
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // add by idx
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        ListNode newNode = new ListNode(data);
        size++;

        ListNode temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove first
    public int removeFirst() {
        if(head == null) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int result = head.data;
            head = tail = null;
            size--;
            return result;
        }

        int result = head.data;
        head = head.next;
        size--;
        return result;

    }

    // remove last
    public int removeLast() {
        if(head == null) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int result = head.data;
            head = tail = null;
            size = 0;
            return result;
        }

        ListNode prev = head;
        int i=0;
        while (i < size - 2) {
            prev = prev.next;
            i++;
        }

        int result = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return result;
    }

    // remove
    public int remove(int idx) {
        if (idx == 0) {
            return removeFirst();
        }

        ListNode temp = head;
        int i=0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        int result = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return result;
    }

    // print
    public void print() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static int searchKey(int key) {
        ListNode temp = head;

        int i = 0;
        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public static int recurshivSearch(int key, ListNode temp, int i) {

        if(temp == null) {
            return -1;
        }

        if(temp.data == key) {
            return i;
        }

        return recurshivSearch(key, temp = temp.next, i = i + 1);
    }

    public void reverseLinkedList() {
        ListNode prev = null;
        ListNode curr = tail = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static int removeNfromEnd(int idx) {
        int i = size - idx;
        int j = 0;
        ListNode temp = head;

        while (j < i - 1) {
            temp = temp.next;
            j++;
        }

        int result = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return result;
    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPlaindrom(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode midNode = findMid(head);

        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();

        ll.addFirst(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(30);
        ll.addLast(20);
        ll.addLast(10);

        ll.print();

        // System.out.println(searchKey(501));
        // System.out.println(recurshivSearch(20, head, 0));
        // ll.reverseLinkedList();
        // removeNfromEnd(4);
        System.out.println(isPlaindrom(head));
    }
}