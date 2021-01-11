class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = buildGraph(times);
        Map<Integer, Integer> dist = new HashMap<>();
        // for (int node = 1; node <= N; ++node) {
        //     dist.put(node, Integer.MAX_VALUE);
        // }
        // dist.put(K, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((info1, info2) -> (info1[1] - info2[1]));
        pq.offer(new int[] {K, 0});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int node = info[0];
            int d = info[1];
            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, d);
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int d2 = edge[1];
                    if (!dist.containsKey(neighbor)) {
                        pq.offer(new int[] {neighbor,  d + d2});
                    }
                }
            }
        }

        if (dist.size() != N) {
            return -1;
        }
        int ans = 0;
        for (int cand : dist.values()) {
            ans = Math.max(ans, cand);
        }
        return ans;

    }

    private Map<Integer, List<int[]>> buildGraph (int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        return graph;
    }
}