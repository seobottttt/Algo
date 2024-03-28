import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        // 노드 클래스
        char ch;
        Node left;
        Node right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    static class Tree {
        Node root;

        public void createNode(char data, char left, char right) {
            if (root == null) {
                root = new Node(data);
                root.left = left != '.' ? new Node(left) : null;
                root.right = right != '.' ? new Node(right) : null;
            } else {
                searchNode(root, data, left, right);
            }


        }

        public void searchNode(Node center, char data, char left, char right) {
            if (center == null) {
                return;
            } else if (center.ch == data) {
                center.left = left != '.' ? new Node(left) : null;
                center.right = right != '.' ? new Node(right) : null;
            } else {
                searchNode(center.left, data, left, right);
                searchNode(center.right, data, left, right);
            }

        }

        // 전위 : root -> left -> right
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.ch);
                if (node.left != null) {
                    preOrder(node.left);
                }
                if (node.right != null) {
                    preOrder(node.right);
                }
            }
        }

        // 중위 : left -> root -> right
        public void inOrder(Node node) {
            if (node != null) {
                if(node.left != null) inOrder(node.left);
                System.out.print(node.ch);
                if(node.right != null) inOrder(node.right);
            }
        }

        // 후위 : left -> right -> root
        public void postOrder(Node node){
            if(node != null){
                if(node.left != null) postOrder(node.left);
                if(node.right != null) postOrder(node.right);
                System.out.print(node.ch);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int nodeNum = Integer.parseInt(br.readLine());

        Tree t = new Tree();


        for (int i = 0; i < nodeNum; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.createNode(root,left,right);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }
}
