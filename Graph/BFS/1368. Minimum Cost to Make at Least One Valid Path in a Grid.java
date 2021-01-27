class Solution {
    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new ArrayDeque<>();
        int[][] visited = new int[m][n];
        List<Point> temp = flow(0, 0, grid, visited);
        // System.out.println(temp.size());
        // if (temp.size() == m * n) return 0;
        for (Point p : temp) {
            queue.offer(p);
        }

        int cost = 0;
        while (!queue.isEmpty()) {

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Point p = queue.poll();
                int r = p.r;
                int c = p.c;
                if (r == m - 1 && c == n - 1) {
                    return cost;
                }
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];


                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] == 1) {
                        continue;
                    }

                    temp = flow(nr, nc, grid, visited);
                    for (Point np : temp) {
                        queue.offer(np);
                    }
                }
            }
            cost++;

        }

        return 0;

    }

    class Point {
        int r, c;
        public Point(int row, int col) {
            r = row;
            c = col;
        }
    }


    // find all reachable points
    private List<Point> flow (int r, int c, int[][] grid, int[][] visited) {
        List<Point> res = new ArrayList<>();
        while (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && visited[r][c] == 0) {
            res.add(new Point(r, c));
            visited[r][c] = 1;
            int i = grid[r][c];
            r = r + dirs[i - 1][0];
            c = c + dirs[i - 1][1];
        }
        return res;
    }




}

// initialize queue the reachable pos from left corner
// all the visited node would be on the queue.


// level 0 :                           (0, 0) - (0, 3)
// level 1 :                           (1, 0) - (1, 3)
// level 2 :                           (2, 0) - (2, 3)
// level 3 :                           (3, 0) - $(3, 3)$