import java.util.*;
public class BinarySearchTree {
    public BinarySearchTree() {

    }

    public Node root;

    public class Node {
        int value;
        Node left;
        Node right;
        int height;

        Node(int value) {
            this.value = value;
        }

        public int getValue(Node node) {
            return value;
        }
    }

    public int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }


    public boolean isEmpty() {
        return root == null;
    }


    // Insert multiple nodes from the array so thet we don't have to write it again and again on the console.

    public void populate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            // add this
            insert(nums[i]);
        }
    }

    // Sorted arrays
    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }
    
    // Populate sorted array. Just take the mid element and call recursion for left and 
    public void populateSorted(int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = (start + end) / 2;

        insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }


    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(value < node.value) {
            node.left = insert(value, node.left);
        } 

        if(value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node root) {
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && balanced(root.left) && balanced(root.right);
    }

    public void display() {
        // add this
        display(root, "Root Node: ");
    }

    public void display(Node root, String details) {
        if(root == null) return;

        System.out.println(details + root.value);
        display(root.left, "Left child of " + root.value + "-> ");
        display(root.right, "Right child of " + root.value + "-> ");
    }

    // Tree Traversals

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node root) {
        if(root == null) return;

        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null) return;

        preOrder(root.left);
        System.out.println(root.value + " ");
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.value + " ");
    }
}
