import java.util.*;
import java.io.*;

public class is_bst_hard {
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

        int n;
        int i = 0;

        class Node {
            long key;
            int left;
            int right;

            Node(long key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        Node[] result;

        void read() throws IOException {
            Scanner in = new Scanner(System.in);
            nodes = in.nextInt();
            n = nodes;
            tree = new Node[nodes];

            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextLong(), in.nextInt(), in.nextInt());
            }
        }

        Node[] inOrder() {

            if (n == 0) {
                result = new Node[1];
                return result;
            } else {
                result = new Node[n];
                inOrderTraversal(0);
                return result;
            }
        }


        void inOrderTraversal(int index) {
            if (tree[index].left != -1)
                inOrderTraversal(tree[index].left);
            result[i] = new Node(tree[index].key, tree[index].left, tree[index].right);
            i++;
            if (tree[index].right != -1)
                inOrderTraversal(tree[index].right);
        }

        boolean isBinarySearchTree() {
            boolean is_binary = true;
            if (result.length == 1) {
                return true;
            } else {
                for (int k = 0; k < n - 1 && is_binary == true; k++) {
                    //
                    // System.out.println("The Left : " + result[k].key +" Right : "+  result[k+1].key);
                    long minimum = -2147483648;
                    long maximum = 2147483647;
                   // Long.MAX_VALUE =  9223372036854775807;
                    // Long.MIN_VALUE = -9223372036854775808;


                    //  && result[k+1].right != 2

                    if (result[k].key > result[k + 1].key) {
                        return false;

                    } else if (result[k].key == result[k + 1].key) {
                        long left_child;
                        long right_child;
                        long cur_node;

                        if (result[k + 1].left == -1) {
                            left_child = minimum;
                        } else {
                            left_child = result[result[k + 1].left].key;
                        }

                        if (result[k + 1].right == -1) {
                            right_child = maximum;
                        } else {
                            right_child = result[result[k + 1].right].key;
                        }


                        cur_node = result[k + 1].key;

                        //  System.out.println("Left Child : " +left_child)  ;
                        // System.out.println("Cur Node : " +cur_node)  ;
                        //  System.out.println("Right Child : " +right_child)  ;

                        if (left_child < cur_node && right_child >= cur_node) {
                            is_binary = true;
                        } else {

                            is_binary = false;
                            return false;
                        }

                    }

                }
                //

            }

            return is_binary;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {

                    new is_bst_hard().run();
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
