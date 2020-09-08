class Solution {
    private int n;
    private int m;
    public boolean exist(char[][] board, String word) {
        
        n = board.length;
        m = board[0].length;
        boolean res = false;
        for(int row = 0 ; row < n; row++){
            for(int col = 0; col < m ; col++){
                res = helper(row, col, 0, board, word, visited);
                if(res == true) {
                    return true;
                }
            }    
        }
        
        return res;
    
    }
    
    /*
    recursion  inpout:  row, col, k, word 
                output: boolean 

    base: row < 0, col < 0; row >= board.length || col >= board[0].lenght
    recurrence: 
                if(board[row][col] != '0' && board[row][col] == word.charAt(k)) : 
                        board[row][col] = '0';
                        recursion(row+1, col, k+1, word) || recursion(row, col+1, k+1, word) 
                        || recursion(row-1, col, k+1, word)
                        || recursion(row, col-1, k+1, word)
                else: return flase;

    */

    private boolean helper(int row, int col, int k, char[][] board, String word){
         
        if( k >= word.length()) return true;
        
        if(row < 0 || col < 0 || row >= n || col >= m){
            return false;
        }
        
        if(board[row][col] == word.charAt(k)){
            board [row][col] = '0';
            return helper(row+1, col, k+1, board, word)||helper(row, col+1, k+1, board, word) || helper(row-1, col, k+1, board, word)|| helper(row, col-1, k+1, board, word);

        
        }
    
        board[row][col] = word.charAt(k);    
        return false;

    }
}