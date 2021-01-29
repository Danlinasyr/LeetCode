class Solution {
    private int m, n;
    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> highs = new ArrayList<>();
        int[][] added = new int[m][n];
        findHighPoints(matrix, 0, 0, highs, added);
        for (int[] h : highs) {
            int steps = bfs(h[0], h[1]);
            if (steps != -1) {
                List<Integer> pos = new ArrayList<>();
                pos.add(h[0]);
                pos.add(h[1]);
                res.add(pos);
            }
        }
        return res;
    }

    private void findHighPoints(int[][] matrix, int x, int y, List<int[]> res, int[][] added) {
        //high points:
        if (isHighest(matrix, x, y)) {
            if (added[x][y] == 0) {
                res.add(new int[] {x, y});
                added[x][y] = 1;
            }
            return;
        }

        for (int[] dir : dirs) {
            int r = x + dir[0];
            int c = y + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n) {
                continue;
            }
            if (matrix[r][c] >= matrix[x][y]) {
                findHighPoints(matrix, r, c, res, added);
            }
        }
    }

    private boolean isHighest(int[][] matrix, int x, int y) {
        for (int[] dir : dirs) {
            int r = x + dir[0];
            int c = y + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n) {
                continue;
            }
            if (matrix[r][c] >= matrix[x][y]) {
                return false;
            }
        }

        return true;
    }

    private int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] seen = new int[m][n];
        queue.offer(new int[] {x, y});
        seen[x][y] = 1;
        int steps = 0;
        while (queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] pos = queue.poll();
                if (pos[0] == m - 1 && pos[1] == n - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || seen[r][c] == 1) {
                        continue;
                    }
                    queue.offer(new int[] {r, c});
                    seen[r][c] = 1;
                }

            }

            steps++;
        }

        return -1;
    }
}

//150 * 150 * 2