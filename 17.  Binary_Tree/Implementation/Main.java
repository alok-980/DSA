import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    // static class Info {
    //     int diam;
    //     int ht;

    //     public Info(int diam, int ht) {
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
    // }

    // public static Info diameter(Node root) {
    //     if(root == null) {
    //         return new Info(0, 0);
    //     }

    //     Info leftInfo = diameter(root.left);
    //     Info rightInfo = diameter(root.right);

    //     int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
    //     int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

    //     return new Info(diam, ht);
    // }

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

    // Top view of tree
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while ((!q.isEmpty())) {
            Info curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
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

    // Kth level traversal itreative way
    public static void kthLeve(Node root, int k) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        int level = 1;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if(curr == null) {
                level++;
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(level == k) {
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

    //kth level recursive approach
    public static void Klevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        Klevel(root.left, level + 1, k);
        Klevel(root.right, level + 1, k);
    }
    
    // Lowest Common Ancestor LCA (Approach 1)
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean fountLeft = getPath(root.left, n, path);
        boolean fountRight = getPath(root.right, n, path);

        if(fountLeft || fountRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        while(i < path1.size() && i < path2.size()) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }

        // last equal node --> i - 1 is the Lowest Common Ancestor
        return path1.get(i-1);
    }

    // LCA (Approach 2)
    public static Node lcaApp2(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lcaApp2(root.left, n1, n2);
        Node rightLCA = lcaApp2(root.right, n1, n2);

        if(leftLCA == null) {
            return rightLCA;
        }

        if(rightLCA == null) {
            return leftLCA;
        }

        return root;
    }

    // Minimum distance between 2 nodes
    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDis(Node root, int n1, int n2) {
        Node lca = lcaApp2(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    // K'th ancestor
    public static int KAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max+1 == k) {
            return root.data;
        }

        return max+1;
    }

    // Transform to sum tree
    public static int sumTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int data = root.data;
        
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftSum + newRight + rightSum;

        return data;
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // int node[] = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        // int topview[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        int topview[] = {1, 2, -1, 4, -1, 5, -1, 6, -1, -1, 3, -1, -1};
        // int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1};


        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        // preorder(root);
        // inorder(root);
        // postorder(root);
        // levelorder(root);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sumofNodes(root));
        // System.out.println(diameter(root).diam);

        // topView(root);
        // kthLeve(root, 3);
        // Klevel(root, 1, 3);
        // System.out.println("LCA = " + lca(root, 5, 4).data);
        // System.out.println("LCA = " + lcaApp2(root, 4, 1).data);
        // System.out.println(minDis(root, 4, 6));
        // System.out.println(KAncestor(root, 5, 2));
        sumTree(root);
        levelorder(root); // to print the new transformed tree
    }
}