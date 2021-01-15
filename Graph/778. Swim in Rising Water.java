class Solution {

    private static final int[][] directions = new int[][] {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[0][0];
        int r = n * n;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (isPossible(grid, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean isPossible(int[][] grid, int t) {
        int n = grid.length;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int k = stack.pop();
            int r = k / n, c = k % n;
            if (r == n - 1 && c == n - 1) {
                return true;
            }

            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (isValid(nr, nc, n, visited, grid, t)) {
                    stack.push(nr * n + nc);
                    visited.add(nr * n + nc);
                }
            }
        }

        return false;
    }

    private boolean isValid(int nx, int ny, int n, Set<Integer> visited, int[][] grid, int t) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= n ) {
            return false;
        }
        if (visited.contains(nx * n + ny)) {
            return false;
        }

        return grid[nx][ny] <= t;
    }
}