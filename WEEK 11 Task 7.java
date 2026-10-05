import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        // Creating a sample binary tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Preorder Traversal:");
        preOrder(root);
    }
}
