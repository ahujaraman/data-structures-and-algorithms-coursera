

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountleafNodes_Contest {


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



    public class TreeLeavesCount {
        int n;
        int parent;

        int read() throws IOException {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            Map<Integer, List<Integer>> TreeMap = new HashMap<Integer, List<Integer>>();
            int[] input_arr = new int[n];

            for (int i = 0; i < n; i++) {
                parent = in.nextInt();
                input_arr[i] = parent;
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

            int node_delete = in.nextInt();

            if (n==1){
                System.out.println(0);
                return 0;
            }

            /*
            Delete nodes parent, get and then remove the delete node as the parents child
             */

            int parent_del_node = input_arr[node_delete];

            if (parent_del_node == -1){
                System.out.println(0);
                return 0;
            }
            if (n==2 && parent_del_node!= -1){

            }

          /*  System.out.println("Delete node : " + node_delete);
            // System.out.print(TreeMap.size());
            for (Map.Entry<Integer, List<Integer>> entry : TreeMap.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> values = entry.getValue();
                System.out.print("Key = " + key);
                System.out.print("  Values = " + values);
                System.out.println();
            }
            // System.out.println(TreeMap.size());

*/
            List<Integer> curLevel = TreeMap.get(node_delete);
            TreeMap.remove(node_delete);

            // System.out.println(curLevel);
            // System.out.println(TreeMap.size());
            int count = 1;
            if (curLevel == null) {
                List<Integer> nodes = new ArrayList<Integer>();
                nodes = TreeMap.get(parent_del_node);
              //  System.out.println("The parent del node :" + nodes);
                nodes.remove(Integer.valueOf(node_delete));
                TreeMap.put(parent_del_node, nodes);



                System.out.println(countLeafNodes(TreeMap));


            } else {
                List<Integer> nodes = new ArrayList<Integer>();
                nodes = TreeMap.get(parent_del_node);
             //   System.out.println("The parent del node :" + nodes);
                nodes.remove(Integer.valueOf(node_delete));
                TreeMap.put(parent_del_node, nodes);
                while (curLevel.size() > 0) {

                    // System.out.println("Inside Loop");
                    List<Integer> nextLevel = new ArrayList<Integer>();


                    for (int i = 0; i < curLevel.size(); i++) {
                        int visited = curLevel.get(i);

                        if (TreeMap.get(visited) != null) {
                            nextLevel.addAll(TreeMap.get(visited));
                        }
                        // System.out.println(visited);
                        TreeMap.remove(visited);
                        //System.out.println("Removing key :"+visited);
                        // System.out.println("TreeMap Size "+ TreeMap.size());
                    }
                    curLevel.clear();
                    curLevel.addAll(nextLevel);
                    //System.out.println("New CurLevel  "+ curLevel);
                }

              //  System.out.println("Delete Node subtree post :");
                System.out.println(countLeafNodes(TreeMap));



            }


          /*  for (Map.Entry<Integer, List<Integer>> entry : TreeMap.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> values = entry.getValue();
                System.out.print("Key = " + key);
                System.out.print("  Values = " + values);
                System.out.println();
            } */


            return 0;

        }


     public  int countLeafNodes(Map<Integer, List<Integer>> TreeMap) {

            List<Integer> curLevel = new ArrayList<Integer>();
            List<Integer> rootLevel = TreeMap.get(-1);
            int root_key = rootLevel.get(0);
            curLevel = TreeMap.get(root_key);
           // System.out.println("Root plus curLevel" + curLevel);
           // System.out.println("Root Key " + root_key);
            TreeMap.remove(root_key);
            TreeMap.remove(-1);

            if (curLevel == null) {
                return 1;
            }
            int curLevelSize = 0;
            int nextLeveSize = 0;
            while (curLevel.size() > 0) {

                // System.out.println("Inside Loop");
                List<Integer> nextLevel = new ArrayList<Integer>();


                curLevelSize = curLevel.size();
                for (int i = 0; i < curLevel.size(); i++) {
                    int visited = curLevel.get(i);

                    if (TreeMap.get(visited) != null) {
                        nextLevel.addAll(TreeMap.get(visited));
                    }
                    // System.out.println(visited);
                    TreeMap.remove(visited);
                    //System.out.println("Removing key :"+visited);
                    // System.out.println("TreeMap Size "+ TreeMap.size());
                }
                curLevel.clear();
                curLevel.addAll(nextLevel);
                nextLeveSize = curLevel.size();
                //System.out.println("New CurLevel  "+ curLevel);
            }


          //  System.out.println("Leaf nodes " + curLevelSize);
            return curLevelSize;
        }







    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new CountleafNodes_Contest().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        CountleafNodes_Contest.TreeLeavesCount tree = new CountleafNodes_Contest.TreeLeavesCount();
        tree.read();

    }
}
