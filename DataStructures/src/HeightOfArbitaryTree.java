

import java.util.*;
import java.io.*;


public class HeightOfArbitaryTree {
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

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public class TreeHeight {
        int n;
        int parent;

        int read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            Map<Integer, List<Integer>> TreeMap = new HashMap<Integer, List<Integer>>();

            for (int i = 0; i < n; i++) {
                parent = in.nextInt();

                List<Integer> child_nodes = new ArrayList<Integer>();


                if (TreeMap.containsKey(parent) == false) {
                    child_nodes.add(i);
                    TreeMap.put(parent, child_nodes);
                } else {
                    child_nodes = TreeMap.get(parent);
                    child_nodes.add(i);
                    TreeMap.put(parent, child_nodes);

                }

            }

            if (n==1){
                return 1;
            }
           // System.out.print(TreeMap.size());
         /*   for (Map.Entry<Integer, List<Integer>> entry : TreeMap.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> values = entry.getValue();
                System.out.print("Key = " + key);
                System.out.print("  Values = " + values);
                System.out.println();
            }
            System.out.println(TreeMap.size());
*/
         else {

            List<Integer> rootLevel = TreeMap.get(-1);
            int cur_key = rootLevel.get(0);
            int height = 1;

            List<Integer> curLevel = TreeMap.get(cur_key);
            TreeMap.remove(cur_key);

           // System.out.println(curLevel);
           // System.out.println(TreeMap.size());
            int count=1;
           while (curLevel.size() >0){

              // System.out.println("Inside Loop");
                List<Integer> nextLevel = new ArrayList<Integer>();


                for (int i=0;i < curLevel.size() ; i++){
                   int visited =  curLevel.get(i);

                   if (TreeMap.get(visited) != null){
                       nextLevel.addAll(TreeMap.get(visited));
                   }
                   // System.out.println(visited);
                   TreeMap.remove(visited);
                    //System.out.println("Removing key :"+visited);
                   // System.out.println("TreeMap Size "+ TreeMap.size());
                }
                height++;


                curLevel.clear();
                curLevel.addAll(nextLevel);
               //System.out.println("New CurLevel  "+ curLevel);
            }


           return height;
         }
        }









    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new HeightOfArbitaryTree().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        System.out.println(tree.read());

    }
}
