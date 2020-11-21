class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] LCS = new int[m+1][n+1];
        
        for (int i = 0; i < m; i++) {
            LCS[i][0] = 0;
        }
        
        for (int j = 0; j < n; j++) {
            LCS[0][j] = 0;
        }


        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j -1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 2;
                } else {
                    LCS[i][j] = Math.max (LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        
        return m + n - LCS[m][n];
    }
}