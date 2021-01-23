class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] map = new int[m][n];
        PriorityQueue<Integer> heights = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = forest.get(i).get(j);
                if (forest.get(i).get(j) > 1) {
                    heights.offer(forest.get(i).get(j));
                }
            }
        }
        int steps = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                //can we cut off the tree
                if (map[r][c] == heights.peek()) {
                    heights.poll();
                    map[r][c] = 1;

                    if (heights.isEmpty()) {
                        return steps;
                    }
                }

                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 0) {
                        continue;
                    }
                    queue.offer(new int[] {x, y});
                    if (map[x][y] == 1) {
                        map[x][y] = 0;
                    }
                }
            }
            steps++;
        }

        return -1;

    }
    // 1. start from the source move four direction from the current position;
    // 2. cut the tree of this position if the height = maxHeight + 1, then update the maxHeight = height;
    // 3. push current position onto the queue
}