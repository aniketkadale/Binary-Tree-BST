import java.util.*;

public class BinaryTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }


    // Insert nodes
    public void populate(Scanner sc) {
        System.out.println("Enter the root node: " );
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    public void populate(Scanner sc, Node root) {
        System.out.println("Do you want to insert node to the left of " + root.value);
        boolean isLeft = sc.nextBoolean();

        if(isLeft) {
            System.out.println("Enter the node to the left of " + root.value);
            int value = sc.nextInt();
            root.left = new Node(value); 
            populate(sc, root.left);
        } 

        

        System.out.println("Do you want to insert a node to the right of " + root.value);
        boolean isRight = sc.nextBoolean();

        if(isRight) {
            System.out.println("Enter the node to the right of " + root.value);
            int value = sc.nextInt();
            root.right = new Node(value);
            populate(sc, root.right);
        }
// 
        // dispaly(root);

    }

    // Display the nodes

    public void dispaly() {
        dispaly(root, " ");
    }

    public void dispaly(Node root, String indent) {
        if(root == null) {
            return;
        }

        System.out.println(indent + root.value);
        dispaly(root.left, indent + "\t");
        dispaly(root.right, indent + "\t");
    }


    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node root, int level) {
        if(root == null) return;

        prettyDisplay(root.right, level + 1);

        if(level != 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|--------->" + root.value);
        } else {
            System.out.println(root.value);
        }

        prettyDisplay(root.left, level + 1);
    }
}