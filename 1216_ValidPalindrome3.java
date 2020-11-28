class Solution {
    
    /*
    "abcdeca"
     acedcba
     
     LCS(i, j) =     1. LCS(i-1, j-1) + 1   when s[i] = s[j]
                     2. Max(LCS(i-1, j),  LCS(i, j-1))  when s[i] != s[j]  
                     
    LCS(i, 0) = 0
    LCS(0, j) = 0
    */
    
    public boolean isValidPalindrome(String s, int k) {
        
        // get a reverse string of s
        String t = new StringBuilder(s).reverse().toString();
        
        // LCS bewteen s and t
        int m = s.length();
        int[][] LCS = new int[m+1][m+1];
        
        for (int i = 0; i < m; i++) {
            LCS[i][0] = 0;
            LCS[0][i] = 0;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        
        if (k < m - LCS[m][m]) {
            return false;
        } else {
            return true;
        }
        
    }
}