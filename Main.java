import java.util.*;
import java.util.LinkedList;

public class Main {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class  BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {
            idx++;

            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // diameter of a Tree
    // static class Info {
    //     int diam;
    //     int ht;

    //     public Info(int diam, int ht) {
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
    // }

    // public static Info diameterOfTree(Node root) {
    //     if(root == null) {
    //         return new Info(0, 0);
    //     }

    //     Info leftInfo = diameterOfTree(root.left);
    //     Info rightInfo = diameterOfTree(root.right);

    //     int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
    //     int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

    //     return new Info(diam, ht);
    // }

    // subTree of a another tree
    public static boolean isIdentical(Node root, Node Subroot) {
        if(root == null && Subroot == null) {
            return true;
        }

        if(root == null || Subroot == null || root.data != Subroot.data) {
            return false;
        }

        if(!isIdentical(root.left, Subroot.left)) {
            return false;
        }

        if(!isIdentical(root.right, Subroot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node Subroot) {
        if(root == null) {
            return false;
        }

        if(root.data == Subroot.data) {
            if(isIdentical(root, Subroot)) {
                return true;
            }
        }

        return isSubtree(root.left, Subroot) || isSubtree(root.right, Subroot);
    }

    // top view of binary tree
    static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topViewOfTree(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if(curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // is tree univalid
    public static boolean isUnivalid(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.left.data != root.data) {
            return false;
        }

        if(root.right != null && root.right.data != root.data) {
            return false;
        }

        boolean isLeftUnivalid = isUnivalid(root.left);
        boolean isRightUnivalid = isUnivalid(root.right);

        return isLeftUnivalid && isRightUnivalid;
    }

    // invert tree (mirror) new tree
    public static Node invertTree(Node root) {
        if(root == null) {
            return root;
        }

        Node newNode = new Node(root.data);

        Node leftNode = invertTree(root.left);
        Node rightNode = invertTree(root.right);

        newNode.left = rightNode;
        newNode.right = leftNode;

        return newNode;
    }

    // invert same tree
    public static Node invert(Node root) {
        if(root == null) {
            return null;
        }

        Node temp = root.left;

        root.left = invert(root.right);
        root.right = invert(temp);

        return root;
    }

    // print K'th level
    public static void printKthLevel(Node root, int k) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int count = 1;

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if(curr == null) {
                count++;
                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                if(count == k) {
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int node[] = {2, 4, -1, -1, 5, -1, -1};
        int uni[] = {1, 1, 1, -1, -1, 1, -1, 1, -1, -1, 1, -1, -1};
        int inv[] = {4, 2, 1, -1, -1, 3, -1, -1, 7, 6, -1, -1, 9, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(inv);
        // BinaryTree.idx = -1;
        // Node Subroot = tree.BuildTree(node);

        // preorder(root);

        // System.out.println(diameterOfTree(root).diam);
        // System.out.println(isSubtree(root, Subroot));;
        // topViewOfTree(root);

        // System.out.println(isUnivalid(root));
        // preorder(invert(root));
        // System.out.println();
        // printKthLevel(root, 3);
    }
}