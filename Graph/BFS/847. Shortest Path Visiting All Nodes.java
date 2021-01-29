class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int finalState = (1 << N) - 1;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Integer> dist = new HashMap<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Node(i, 1 << i));
            dist.put(new Node(i, 1 << i), 0);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int d = dist.get(node);
            if (node.state == finalState) {
                return d;
            }


            for (int next : graph[node.num]) {
                int s = node.state;
                s |= (1 << next);
                Node newNode = new Node(next, s);
                if (d + 1 < dist.getOrDefault(newNode, Integer.MAX_VALUE)) {
                    queue.offer(newNode);
                    dist.put(newNode, d + 1);
                }

            }

        }
        throw null;
    }




    class Node {
        int num;
        int state;

        public Node (int number, int new_state) {
            num = number;
            state = new_state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }

            Node other = (Node) o;

            return other.num == this.num && other.state == this.state;
        }

        @Override
        public int hashCode() {
            return 1331 * state + 1793 * num;
        }
    }
}