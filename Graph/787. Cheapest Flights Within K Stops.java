class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        int[] prices = new int[n];
        int[] stops = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> (n1[1] - n2[1]));
        pq.offer(new int[] {src, 0, 0});
        prices[src] = 0;
        stops[src] = 0;
        while (!pq.isEmpty()) {

            int[] node = pq.poll();
            int city = node[0];
            int price = node[1];
            int stop = node[2];

            if (city == dst) {
                return price;
            }

            if (stop > K) {
                continue;
            }

            if (!graph.containsKey(city)) {
                continue;
            }
            for (int[] next : graph.get(city)) {

                if (price + next[1] < prices[next[0]]) {
                    pq.offer(new int[] {next[0], price + next[1], stop + 1});
                    prices[next[0]] = price + next[1];
                }

                else {
                    pq.offer(new int[] {next[0], price + next[1], stop + 1});
                    stops[next[0]] = stop + 1;
                }


            }

        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

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


