
import java.util.LinkedList;
import java.util.Stack;

class BinarySearchTree {

    // Class containing left and right child of current node and key value 
    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    static Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST 
    Node insertRec(Node root, int key) {

        // If the tree is empty, return a new node 
        if (root == null) {
            root = new Node(key);
            return root;
        } /* Otherwise, recur down the tree */ else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // A utility function to search a given key in BST
    public static Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is greater than root's key
        if (root.key < key) {
            return search(root.right, key);
        }

        // Key is smaller than root's key
        return search(root.left, key);
    }

    

    public static Node searchIterative(Node root, int key) {
        while (root != null) {
            if (root.key == key) {
                return root;
            } else if (root.key < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    public void insertIterative(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        // Find the node that will be the parent of the new key
        while (temp != null) {
            if (temp.key > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.key < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        // Insert the new key in a leaf
        if (prev.key > key) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    public void inorderWithStack() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.key + " ");
                temp = temp.right;
            }
        }
    }

    void TraverseByLevel(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(n.key + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    void TraverseByLevelShowingLevels(Node root) {
        LinkedList<Node> queueKey = new LinkedList<>();
        LinkedList<Integer> queueLevel = new LinkedList<>();

        int currentLevel = 0;

        if (root != null) {
            queueKey.add(root);
            queueLevel.add(1);
        }
        while (!queueKey.isEmpty()) {
            Node n = queueKey.remove();
            int level = queueLevel.remove();

            if (level > currentLevel) {
                currentLevel = level;
                System.out.print("\nLevel " + currentLevel+ ":");
            }
            System.out.print(n.key + " ");
            if (n.left != null) {
                queueKey.add(n.left);
                queueLevel.add(level + 1);
            }
            if (n.right != null) {
                queueKey.add(n.right);
                queueLevel.add(level + 1);
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

       tree.insert(50);
       tree.insert(30);
       tree.insert(20);
       tree.insert(40);
       tree.insert(70);
       tree.insert(60);
       tree.insert(80);

// 8, 3,  1, 6, 4, 7, 10, 14, 13
        // tree.insert(3);
        // tree.insert(1);
        // tree.insert(6);
        // tree.insert(4);
        // tree.insert(7);
        // tree.insert(10);
        // tree.insert(14);
        // tree.insert(13);
        // print inorder traversal of the BST


        // Node placeInTree = BinarySearchTree.search(root, 70);

        // if (placeInTree == null) {
        //     System.out.println("\n" + 70 + " is not found in BST");
        // } else {
        //     System.out.println(placeInTree.key + " is found in BST");
        // }

        // placeInTree = BinarySearchTree.search(root, 70);

        // if (placeInTree == null) {
        //     System.out.println("\n" + 70 + " is not found in BST using iterative search");
        // } else {
        //     System.out.println(placeInTree.key + " is found in BST using iterative search");
        // }

        // placeInTree = BinarySearchTree.search(root, 25);
        // if (placeInTree == null) {
        //     System.out.println(25 + " is not found in BST");
        // } else {
        //     System.out.println(placeInTree.key + " is found in BST");
        // }

        // placeInTree = BinarySearchTree.search(root, 10);
        // if (placeInTree == null) {
        //     System.out.println(10 + " is not found in BST");
        // } else {
        //     System.out.println(placeInTree.key + " is found in BST");
        // }        
        
        
        System.out.println("The inorder recursive traversal of BST is...");
        tree.inorder();

        System.out.println("\nThe inorder traversal with stack of BST is...");
        tree.inorderWithStack();

        // System.out.println("\nThe preorder traversal of BST is...");
        // tree.preorderRec(root);

        // System.out.println("\nThe postorder traversal of BST is...");
        // tree.postorderRec(root);

        System.out.println("\nThe by level traverse of BST is...");
        tree.TraverseByLevel(root);

        System.out.println("\nThe by level traverse showing levels of BST is...");
        tree.TraverseByLevelShowingLevels(root);

    }
}
