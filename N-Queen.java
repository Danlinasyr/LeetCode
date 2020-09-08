class Solution {
    public int totalNQueens(int n) {
        
        // initialize attack-free zone n x n matrix
        int[][] afZone = new int[n][n];
        int count = 0;
        count = backTrack(0, n, afZone, count);
        return count;
        
    }
    
    /*
        input: rowIndex, queen_left, attack-free zone, solution count
        output: final count of solutions
        
        base: queen == 0 return count;
        
        iterate through each column:
            #1 check if the [row, col] is in attack-free zone
            #2 add queen at [row, col] and update attack-free zone
            #3 call backtrack(row+1, n - 1)    
            #4 remove the queen and update attach-free zone
    
    */
    
    private int backTrack(int i, int queen, int[][] afZone, int count){
        int n = afZone.length;
        
        if(queen == 0) return count++;
        
        for(int j = 0; j < n; j++){
            
            int[][] afZone_copy = afZone;
            if(afZone[i][j] == 0){
                
                
                for(int k = 0; k < n; k++){
                    // update attack-zone horizontal and vertical
                    afZone[i][k] = 1;
                    afZone[k][j] = 1;
                
                    // update attack-zone horizontal and vertical
                    if(i-k > 0 && j-k > 0){
                        afZone[i-k][j-k] = 1;
                    } 
                    if(i+k<n && j+k<n){
                        afZone[i+k][j+k] = 1;
                    }
                    if(i-k>0 && j+k<n){
                        afZone[i-k][j+k] = 1;
                    }
                    if(i+k<n && j-k>0){
                        afZone[i+k][j-k] = 1;
                    }    

                }
                
                count = backTrack(i+1, queen-1, afZone, count);

            }
            afZone = afZone_copy;
            
            
        }
        
        return count;
    }
}