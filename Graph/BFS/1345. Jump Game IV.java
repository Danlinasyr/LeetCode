class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!graph.containsKey(arr[i])) {
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[arr.length];
        queue.offer(0);
        int move = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int node = queue.poll();
                if (node == arr.length - 1) {
                    return move;
                }
                for (int step = -1; step <= 1; step += 2) {
                    int next = node + step;
                    if (next < 0 || next >= arr.length || visited[next] == 1) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next] = 1;
                }

                for (int nei : graph.get(arr[node])) {
                    if (visited[nei] == 1) {
                        continue;
                    }
                    queue.offer(nei);
                    visited[nei] = 1;
                }
                graph.get(arr[node]).clear();
            }
            move++;
        }

        return -1;
    }
}