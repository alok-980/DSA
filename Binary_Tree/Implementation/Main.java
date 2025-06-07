import java.util.LinkedList;
import java.util.Queue;

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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if(root == null) {
            // System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder traversal
    public static void postorder(Node root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level order traversal
    public static void levelorder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // height of tree
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // count of nodes
    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int lcount = count(root.left);
        int rcount = count(root.right);

        return (lcount + rcount) + 1;
    }

    // sum of nodes
    public static int sumofNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int lsum = sumofNodes(root.left);
        int rsum = sumofNodes(root.right);

        int sum = lsum + rsum + root.data;
        return sum;
    }

    // Diameter2 of a tree
    public static int diameter2(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHeight = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // Diameter of a tree with good TC
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    // subTree of a given tree
    public static boolean isIndentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(!isIndentical(node.left, subRoot.left)) {
            return false;
        }

        if(!isIndentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIndentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int node[] = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};

        BinaryTree tree = new BinaryTree();

        // Node root = tree.buildTree(nodes);

        // preorder(root);
        // inorder(root);
        // postorder(root);
        // levelorder(root);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sumofNodes(root));
        // System.out.println(diameter(root).diam);
    }
}