import java.io.*;
import java.util.*;


public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    Map<Integer, List<String>> chainMap = new HashMap<Integer, List<String>>();

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                int cur_key = hashFunc(query.s);
               // System.out.print("Adding "+query.s + " .To Hash Key "+cur_key) ;

                    List<String>  cur_list = new ArrayList<String>();
                cur_list = chainMap.get(cur_key);
                    if (cur_list != null){
                        if (!cur_list.contains(query.s)){
                            cur_list.add(0,query.s);
                            //  System.out.println("Adding list to key inside inner loop :"+cur_list);
                            chainMap.put(cur_key,cur_list);
                        }
                    }
                    else {
                        cur_list = new ArrayList<String>();
                        cur_list.add(query.s);
                        chainMap.put(cur_key,cur_list);
                    }

                break;
            case "del":
                 cur_key = hashFunc(query.s);
                if (chainMap.get(cur_key) != null)
                {
                     cur_list = new ArrayList<String>();
                     cur_list = chainMap.get(cur_key);
                    if (cur_list != null) {
                        if (cur_list.contains(query.s)) {
                            cur_list.remove(query.s);
                            chainMap.put(cur_key, cur_list);
                        }
                    }
                }
                break;
            case "find":
                 cur_key = hashFunc(query.s);
                if (chainMap.get(cur_key) != null)
                {
                    cur_list = new ArrayList<String>();
                    cur_list = chainMap.get(cur_key);
                    if (cur_list != null) {
                        if (cur_list.contains(query.s)) {
                            writeSearchResult(true);
                        }
                        else {
                            writeSearchResult(false);
                        }
                    }
                    else
                    {
                        writeSearchResult(false);
                    }
                }
                else
                {
                    writeSearchResult(false);
                }
                break;
            case "check":
                cur_list = new ArrayList<String>();
                cur_list =  chainMap.get(query.ind);
               if (cur_list == null){
                   out.println();
               }
               else
               {
                   for (String cur : cur_list)
                       out.print(cur + " ");
                   out.println();
               }

                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
