import java.util.*;
import java.io.*;

public class is_bst {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;


        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        int[] result;
        int n;
        int i=0;
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            n = nodes;
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        int[] inOrder() {

            if (n==0){
                result = new int[1];
                return result;
            }
            else {
                result = new int[n];
                inOrderTraversal(0);
                return result;
            }

        }

        void inOrderTraversal(int index) {
            if ( tree[index].left != -1)
                inOrderTraversal(tree[index].left);
            result[i] = tree[index].key;
            i++;
            if (tree[index].right != -1)
                inOrderTraversal(tree[index].right);
        }

        boolean isBinarySearchTree() {
            boolean is_binary = true;
            if (result.length == 1){
                return true;
            }
            else {
                for (int k=0;k<n-1 && is_binary == true;k++){
                    if (result[k] > result[k+1]){
                        is_binary=false;
                    }
                }
                return is_binary;
            }

        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        tree.inOrder();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
