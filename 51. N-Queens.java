class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] board = new int[n][n];
        Set<Integer> diagonalUp = new HashSet<Integer>();
        Set<Integer> diagonalDown = new HashSet<Integer>();
        dfs(0, n, board, res, diagonalUp, diagonalDown);
        return res;
    }
    
    // input : row, n, board, res
    // output/update : res
    // base case: row == n, res.add(printBoard(board))
    // recursion rule: for 0...n-1 : 
    //                  check if [r, c] can have another queen:
    //                      update board
    //                      recursion call
    //                      undo board
    
    private void dfs(int row, int n, 
                     int[][] board, 
                     List<List<String>> res,
                    Set<Integer> diagonalUp,
                    Set<Integer> diagonalDown) {
        if (row == n) {
            res.add(printBoard(board));
            return;
        }
        
        System.out.println(row);
        for (int col = 0; col < n; col++) {
            if (!validQueen(row, col, board, diagonalUp, diagonalDown)) {
                continue;
            }
            board[row][col] = 1;
            diagonalUp.add(Math.abs(row - col));
            diagonalDown.add(row + col);
            dfs(row + 1, n, board, res, diagonalUp, diagonalDown);
            board[row][col] = 0;
            diagonalUp.remove(Math.abs(row - col));
            diagonalDown.remove(row + col);
        }
    }
    
    
    //auxiliary function 1:   check if we can insert queen at [x, y] position
    private boolean validQueen(int r, int c, int[][] board, Set<Integer> diagonalUp, Set<Integer> diagonalDown) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (i != c && board[r][i] == 1) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (j != r && board[j][c] == 1) {
                return false;
            }
        }
        if (diagonalUp.contains(Math.abs(r - c))) {
            return false;
        }
        
        if (diagonalDown.contains(r + c)) {
            return false;
        }
        
        return true;
        
    }
    //auxiliary function 2:   print board
    private List<String> printBoard(int[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            // System.out.println(sb.toString());
            res.add(sb.toString());
        }
        return res;
    }       
            
}