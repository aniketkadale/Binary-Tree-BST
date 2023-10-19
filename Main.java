import java.util.*;
public class Main {
    public static void main(String[] args) {
        // BinaryTree bt = new BinaryTree();
        // Scanner sc = new Scanner(System.in);
        // bt.populate(sc);
        // // bt.prettyDisplay();
        // bt.dispaly();

        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        bst.populate(nums);
        bst.display();
    
    }
}
