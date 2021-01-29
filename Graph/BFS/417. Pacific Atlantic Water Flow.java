class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList();
        }
        int n = matrix[0].length;

        int[][] pac = new int[m][n];
        int[][] alt = new int[m][n];

        for (int i = 0; i < m; i++) {
            DFS(matrix, i, 0, pac);
        }

        for (int j = 0; j < n; j++) {
            DFS(matrix, 0, j, pac);
        }

        for (int i = 0; i < m; i++) {
            DFS(matrix, i, n - 1, alt);
        }

        for (int j = 0; j < n; j++) {
            DFS(matrix, m - 1, j, alt);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] == 1 && alt[i][j] == 1) {
                    List<Integer> high = new ArrayList<>();
                    high.add(i);
                    high.add(j);
                    res.add(high);
                }
            }
        }

        return res;
    }

    private void DFS(int[][] matrix, int r, int c, int[][] sea) {
        int m = matrix.length;
        int n = matrix[0].length;
        sea[r][c] = 1;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || sea[x][y] == 1) {
                continue;
            }
            if (matrix[x][y] >= matrix[r][c]) {
                DFS(matrix, x, y, sea);
            }
        }
    }
}