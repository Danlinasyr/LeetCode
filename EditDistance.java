class Solution {
    /*
    h o r s e
    r o s
    
    i n t e n t i o n
    e x e c u t i o n    
    
    for 0 <= i <= n, 0<= j <= m, let E(i, j) be the minimum cost of the editting
    for a word1[0...i] and a word2[0...j].
    
    There four cases come to the cost of editing each index's letter:
            
            h     o    s     ""   
            |     |    |      |
            c     o    ""     s  
    
    E(i, j) = min {1 + E(i-1, j), 1 + E(i, j-1), diff(i, j) + E(i-1, j-1)};
    
    E(i, 0) = i
    E(0, j) = j
    */
    
    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // including empty string, we should build table size of (m + 1, n + 1)
        int[][] E = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            E[i][0] = i;
        }
        
        for (int j = 1; j <= n; j++) {
            E[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                E[i][j] = Math.min (1 + E[i - 1][j], Math.min (1 + E[i][j-1], diff(word1.charAt(i-1),word2.charAt(j-1)) + E[i-1][j-1]));
            }
        }
        
        return E[m][n];
    }
    
    public int diff(char a, char b) {
        return a == b ? 0 : 1;
    }
}