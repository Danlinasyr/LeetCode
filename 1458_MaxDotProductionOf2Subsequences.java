class Solution {
    /*
    [-1, 2, 6, -9]
    [3,-5, 1, 0, -4]
    
    dot product,  nums1[0] * nums2[0] + nums1[1] * nums2[1] +...
    
    for 0 <= i <= m, 0 <= j <= n, let P (i, j) be the max dot product between
    nums1 [0...i] and num2 [0...j]
    
    */
    
    private static final int INF = 100000;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] P = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            P[i][0] = -INF;
        }
        for (int j = 0; j <= n; j++) {
            P[0][j] = -INF;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // curr index at i for nums1 and at j for nums2 product is the only positive product
                int p1 = nums1[i-1] * nums2[j-1]; 
                // sum of curr index product and product of the previous subsequence nums1[0...i-1], nums2[0...j-1]
                int p2 = nums1[i-1] * nums2[j-1] + P[i-1][j-1];  
                int p12 = Math.max(p1, p2);
                int p3 = P[i][j-1];
                int p4 = P[i-1][j];
                int p34 = Math.max(p3, p4);
                P[i][j] = Math.max(p12, p34);
            }
        }
        
        return P[m][n];
    }
}