import java.util.*;

public class Main {

    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insertion in BST
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Print BST
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search in BST
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    // Delete in BST
    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // Case 1: leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            // Case 3: Two child
            Node IS = findInorderSeccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSeccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Print in range k1 - k2
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    // print root to leaf
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + " --> ");
        }
        System.out.println("null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size() - 1);
    }

    // Valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirror BSt
    public static Node createMirror(Node root) {
        if(root == null) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // Sorted arry to balanced BST
    public static Node balancedBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr[mid]);

        root.left = balancedBST(arr, st, mid-1);
        root.right = balancedBST(arr, mid+1, end);

        return root;
    }

    // Convert BST to Balanced BST
    public static void inorderSeq(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        inorderSeq(root.left, list);
        list.add(root.data);
        inorderSeq(root.right, list);
    }

    public static Node balancedBst(ArrayList<Integer> list, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(list.get(mid));

        root.left = balancedBst(list, st, mid-1);
        root.right = balancedBst(list, mid+1, end);

        return root;
    }

    public static Node createBalBST(Node root) {
        // inorder seq
        ArrayList<Integer> list = new ArrayList<>();
        inorderSeq(root, list);

        // sorted inorder to balanced
        return balancedBst(list, 0, list.size() - 1);
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Largest BST in BT
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max); 
    }

    // Merge 2 BSTs
    public static void inorderSeqList(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        inorderSeqList(root.left, arr);
        arr.add(root.data);
        inorderSeqList(root.right, arr);
    }

    public static Node createMergedBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr.get(mid));

        root.left = createMergedBST(arr, st, mid-1);
        root.right = createMergedBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        // step 1: inorder seq of BST 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorderSeqList(root1, arr1);

        // step 2: inorder seq of BST 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorderSeqList(root2, arr2);

        // merge both arraylist
        int i=0, j=0;

        ArrayList<Integer> finalArr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            }
            else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // create BST with merged arrayList here you get final merged BSTs
        return createMergedBST(finalArr, 0, finalArr.size() - 1);
    }

    public static void main(String args[]) {
        int values[] = {5, 1, 3, 4, 2, 7};
        int value[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // Node root = null;

        // for(int i=0; i<values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        


        // inorder(root);
        // System.out.println();

        // System.out.println(search(root, 14));

        // delete(root, 5);
        // inorder(root);
        // System.out.println();

        // printInRange(root, 5, 12);

        // printRoot2Leaf(root, new ArrayList<>());

        // System.out.println(isValidBST(root, null, null));
        
        // inorder(root);
        // System.out.println(isValidBST(root, null, null));
        // System.out.println();
        // createMirror(root);
        // inorder(root);
        // System.out.println();
        // System.out.println(isValidBST(root, null, null));

        // int balBST[] = {3, 5, 6, 8, 10, 11, 12};
        // Node root2 = balancedBST(balBST, 0, balBST.length - 1);

        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // preorder(createBalBST(root));


        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println("largest BST size = " + maxBST);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        preorder(root1);
        System.out.println();

        preorder(root2);
        System.out.println();

        Node root = mergeBST(root1, root2);
        preorder(root);
    }
}