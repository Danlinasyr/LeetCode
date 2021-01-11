class Solution {

    // visited[][0] visited from jumping right, visited from jump left;
    private int[][] visited = new int[6001][2];

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max_forbidden = 0;
        for (int i : forbidden) {
            max_forbidden = Math.max(max_forbidden, i);
            visited[i][0] = -1;
            visited[i][1] = -1;
        }
        int limit = Math.max(max_forbidden, x) + b;
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {

                int[] curr = queue.poll();
                int pos = curr[0];
                int dir = curr[1];
                if (pos == x) {
                    return step;
                }

                if (pos <= limit && visited[pos + a][0] == 0) {
                    queue.offer(new int[] {pos + a, 0});
                    visited[pos + a][0] = 1;
                }

                if (dir == 0) {
                    if (pos - b >= 0 && visited[pos - b][1] == 0) {
                        queue.offer(new int[] {pos - b, 1});
                        visited[pos - b][1] = 1;

                    }
                }

            }
            step++;

        }


        return -1;
    }
}


