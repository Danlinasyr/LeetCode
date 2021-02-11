class Solution {
    class Position {
        int x, y, k;
        public Position (int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(0, 0, k));
        int[][] minE = new int[m][n];
        minE[0][0] = k;
        int steps = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Position curr = queue.poll();
                int x = curr.x;
                int y = curr.y;
                if (x == m - 1 && y == n - 1) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }
                    if (grid[r][c] == 1) {
                        if (curr.k == 0) {
                            break;
                        }

                        if (minE[r][c] == 0 || curr.k - 1 > minE[r][c]) {
                            minE[r][c] = curr.k - 1;
                            queue.offer(new Position(r, c, curr.k - 1));
                        }
                    }

                    if (grid[r][c] == 0) {
                        if (minE[r][c] == 0 || curr.k > minE[r][c]) {
                            minE[r][c] = curr.k;
                            queue.offer(new Position(r, c, curr.k));
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}



//                         (0, 0, k)
//                 (0, 1, k)         (1, 0, k - 1)
//             (0, 1, k) (1, 1, k - 1)  (1, 1, k - 2)


/*
[[0,0,0,0,0,0,0,0,0,0],
[0,1,1,1,1,1,1,1,1,0],
[0,1,0,0,0,0,0,0,0,0],
[0,1,0,1,1,1,1,1,1,1],
[0,1,0,0,0,0,0,0,0,0],
[0,1,1,1,1,1,1,1,1,0],
[0,1,0,0,0,0,0,0,0,0],
[0,1,0,1,1,1,1,1,1,1],
[0,1,0,1,1,1,1,0,0,0],
[0,1,0,0,0,0,0,0,1,0],
[0,1,1,1,1,1,1,0,1,0],
[0,0,0,0,0,0,0,0,1,0]]
1
*/