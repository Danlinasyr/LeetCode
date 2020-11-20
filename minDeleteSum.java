class Solution {
    
    /*
    d l l e t e
    l l e e t
      
    For i, j    0 <= i <= m,  0 <= j <= n, where m = s1 length, n = s2 length
    Let LCS (i , j) is the max ASCII sum of the common subsequence of the string s1 0...i and string s2 0...j, including i and j
    
    LCS(0, j) = 0;
    LCS(i, 0) = 0;
                     
                     max (LCS (i-1, j), LCS (i, j-1))  when s[i] != s[j];
    LCS (i, j) =  
            
                      LCS(i-1, j-1) + 2 * s[i]          when s[i] == s[j];
    
    */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] LCS = new int[m+1][n+1];
        
        int sum1 = 0;
        for (int i = 0; i < m; i++) {
            sum1 += s1.codePointAt(i);
            LCS[i][0] = 0;
        }
        
        int sum2 = 0;
        for (int j = 0; j < n; j++) {
            sum2 += s2.codePointAt(j);
            LCS[0][j] = 0;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j -1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 2 * s1.codePointAt(i - 1);
                } else {
                    LCS[i][j] = Math.max (LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        
        return sum1 + sum2 - LCS[m][n];
        
    }
}