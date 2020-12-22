class Solution {
    public int minInsertions(String s) {
        // mbadm  ->  mbadbm -> mbdadbm   2
        // leetcode -> leetcodel -> leetcodeel -> leetcodteel -> leetcodcteel -> leetcodocteel  5
        // ^      ^      ^   ^         ^  ^            
        // dp[i][j] is minimum number of steps to make s palindrome for s[i, j];
        
        int m = s.length();
        int[][] dp = new int[m][m];
   
        for (int i = 0; i < m; i++) {
            dp[i][i] = 0;
        }
        
        // m b a d m
        // 0 1 2 3 4
        for (int l = 2; l <= m; l++) {   // l = 2
            for (int i = 0; i + l - 1< m; i++) {  // i = 0, 1, 2, 3
                int j = i + l - 1;                 // j = 1, 2, 3, 4
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j]+1, dp[i][j-1]+1);  // dp[0][1] =1 dp[1][2] = 1 dp[2][3] = 1 dp[3][4] = 1
                }
            } 
        }
        
        return dp[0][m-1];
    }
}