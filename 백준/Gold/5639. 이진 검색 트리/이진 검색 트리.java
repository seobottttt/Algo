import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    static class BST {

        Node root;

        public void createNode(int data) {
            if (root == null) root = new Node(data);
            else insertNode(root, data);
        }

        public void insertNode(Node node, int data) {
            if (node.data > data) {
                if (node.left == null) node.left = new Node(data);
                else insertNode(node.left, data);
            } else {
                if (node.right == null) node.right = new Node(data);
                else insertNode(node.right, data);
            }
        }

        public void postOrderSearch(Node node) {
            if (node.left != null) postOrderSearch(node.left);
            if (node.right != null) postOrderSearch(node.right);
            System.out.println(node.data);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BST bst = new BST();

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty())
                break;
            bst.createNode(Integer.parseInt(input));
        }

        bst.postOrderSearch(bst.root);

    }
}
