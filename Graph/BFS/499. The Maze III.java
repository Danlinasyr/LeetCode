class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, -1}, {0, 1}};
    private static final String[] pa = new String[] {"d", "u", "l", "r"};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return "impossible";
        }

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new ArrayDeque<>(); // we might have to understand why ArrayDeque than LinkedList
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.offer(new int[] {ball[0], ball[1]});
        distance[ball[0]][ball[1]] = 0;
        String[][] paths = new String[m][n];
        paths[hole[0]][hole[1]] = "end";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                paths[ball[0]][ball[1]] = "";
            }
        }

        while (!queue.isEmpty()) {
            // System.out.println(queue.size());
            int[] p = queue.poll();
            if (p[0] == hole[0] && p[1] == hole[1]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = p[0];
                int y = p[1];
                int dist = distance[x][y];
                String path = paths[x][y];
                path += pa[i];
                while (x + dirs[i][0] >= 0 && x + dirs[i][0] < m
                        && y + dirs[i][1] >= 0 && y + dirs[i][1] < n
                        && maze[x + dirs[i][0]][y + dirs[i][1]] != 1) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                    dist++;
                    if (x == hole[0] && y == hole[1]) {
                        break;
                    }
                }

                if (x == p[0] && y == p[1]) {
                    continue;
                }

                if (dist <= distance[x][y]) {
                    if (dist < distance[x][y]) {
                        distance[x][y] = dist;
                        paths[x][y] = path;
                    } else if (path.compareTo(paths[x][y]) < 0) {
                        paths[x][y] = path;
                    }
                    queue.offer(new int[] {x, y});
                }
            }
        }

        return paths[hole[0]][hole[1]].equals("end") ? "impossible" : paths[hole[0]][hole[1]];
    }
}