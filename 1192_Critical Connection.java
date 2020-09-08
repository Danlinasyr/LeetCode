class Solution {
    public static final int UNVISITED = -1;
    public static int[] ids;
    public static int[] low;
    public static int id;
    public static List<Integer>[] graph;
    public static List<List<Integer>> res;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        


        //initialize adjacency-list graph
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        //build graph based on connections
        for (List<Integer> connection : connections){
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }


        ids = new int[n];
        low = new int[n];
        res = new ArrayList<>();
        Arrays.fill(ids, UNVISITED);

        for (int i = 0; i < n; i++) {
            if (ids[i] == UNVISITED){
                dfs(i,-1);
            }
        }
        return res;

    }

    public void dfs(int at, int from){
        ids[at] = low[at] = id++;

        for (int to : graph[at]){
            if(at == from){
                continue;
            }
            
            if(ids[to] != UNVISITED) {
                dfs(to, at);
                low[at] = Math.min (low[at], low[to]);
                
                if(ids[at] < low[to]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(at);
                    bridge.add(to);
                    res.add(bridge);
                }
            }else{
                low[at] = Math.min(low[at], ids[to]);
            }

        }

    }

}