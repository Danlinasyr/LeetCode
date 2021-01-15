class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> (n1[1] - n2[1]));
        pq.offer(new int[] {src, 0});
        visited.add(src);
        while (K >= 0 && !pq.isEmpty()) {
            int sz = pq.size();

            for (int i = 0; i < sz; i++) {
                int[] node = pq.poll();
                int from = node[0];
                int price = node[1];


                for (int[] to : graph.get(from)) {

                    if (to[0] == dst) {
                        return price + to[1];
                    }

                    pq.offer(new int[] {to[0], price + to[1]});
                    visited.add(to[0]);
                }
            }

            K--;
        }

        return -1;

    }

    private Map<Integer, List<int[]>> buildGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<int[]>());
            }
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        return graph;
    }
}


