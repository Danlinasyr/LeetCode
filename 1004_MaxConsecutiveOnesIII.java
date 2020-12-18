
// smooth left pointer
class Solution {
     // [1,1,1,0,0,0,1,1,1,1,0]
     //    ^       ^    
    public int longestOnes(int[] A, int K) {
        int j = 0;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            // j = Math.max(j, i+1);
            while (j < A.length && count <= K) {
                if (A[j] == 0) {
                    count++;
                }
                j++;
            }
            
            if (count > K) {
                ans = Math.max(ans, j - i - 1);
            } else {
                ans = Math.max(ans, j - i);
            }
            
            if (A[i] == 0) {
                count--;
            } 
        }
        
        return ans;
    }
}


// smooth right pointer, and non-decreasing size window
class Solution {
     // [1,1,1,0,0,0,1,1,1,1,0]
     //    ^       ^    
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j;
        int ans = 0;
        int count = 0;
        for (j = 0; j < A.length; j++) {
            
            if (A[j] == 0) {
                count++;
            }
            if (count > K) {
                if (A[i++] == 0) {
                    count--;
                }
            }
        }
        
        return A.length - i;
    }
}