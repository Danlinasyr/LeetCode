class Solution {
    private static final int[][] directions = {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //BFS
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[][] visited = new boolean[n][m];
        while (! queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == destination[0] && pos[1] == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int[] new_pos = go (maze, pos[0], pos[1], direction);
                if (visited[new_pos[0]][new_pos[1]]) {
                    continue;
                }
                queue.offer(new_pos);
                visited[new_pos[0]][new_pos[1]] = true;
            }
        }

        return false;
    }

    private int[] go(int[][] maze, int x, int y, int[] direction) {
        while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1) {
            x += direction[0];
            y += direction[1];
        }
        return new int[] {x - direction[0], y - direction[1]};
    }
}