class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] map = new int[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)->(p1[2] - p2[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = forest.get(i).get(j);
                if (map[i][j] > 1) {
                    pq.offer(new int[] {i, j, map[i][j]});
                }
            }
        }


        int sum = 0;
        int sx = 0;
        int sy = 0;
        while (!pq.isEmpty()) {
            int[] spot = pq.poll();
            int steps = minSteps(map, sx, sy, spot[0], spot[1]);
            if (steps == -1) {
                return -1;
            }
            sum += steps;
            sx = spot[0];
            sy = spot[1];
        }

        return sum;

    }

    private int minSteps (int[][] map, int sx, int sy, int ex, int ey) {
        int m = map.length;
        int n = map[0].length;
        int steps = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sx, sy});
        int[][] seen = new int[m][n];
        seen[sx][sy] = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                if (r == ex && c == ey) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 0 || seen[x][y] == 1) {
                        continue;
                    }
                    queue.offer(new int[] {x, y});
                    seen[x][y] = 1;
                }
            }
            steps++;
        }

        return -1;

    }

}