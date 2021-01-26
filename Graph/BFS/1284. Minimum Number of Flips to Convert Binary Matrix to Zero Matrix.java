class Solution {
    private static final int[][] directions = new int[][] {{ -1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] visited = new int[1 << (m * n)];
        Queue<Integer> queue = new ArrayDeque<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= (mat[i][j] << i * n + j);
            }
        }
        queue.offer(start);
        visited[start] = 1;
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int state = queue.poll();
                if (state == 0) {
                    return step;
                }
                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        int ns = flip(state, x, y, m, n);
                        if (visited[ns] == 0) {
                            queue.offer(ns);
                            visited[ns] = 1;
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private int flip (int state, int x, int y, int m, int n) {
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            state ^= (1 << (nx * n + ny));
        }

        return state;
    }
}