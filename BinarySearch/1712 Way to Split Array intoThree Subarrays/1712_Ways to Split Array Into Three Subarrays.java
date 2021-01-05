class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        
        int j = 0;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            j = Math.max(j, i+1);
            while (j < n && preSum[i] > preSum[j] - preSum[i]) {
                j++;
            }
            
            if (j == n) {
                break;
            }
        
            int k = binarySearch_UpperBound(preSum, 0, n-1,  0.5 * (preSum[n-1] + preSum[i]));
            // System.out.println("binary search upper bound: " + k);
            if (k == n-1) {
                k--;
            }
            
            if  (k < j) {
                continue;
            }
            
            // System.out.println("i: " + i + " j: " + j + " k: " + k);
            count += k - j + 1;  
            count = count % mod; 
        }
        
        return count;
    }
    
    private int binarySearch_UpperBound(long[] arr, int start, int end, double target) {
        int left = start;
        int right= end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] <= target) {
            return right;
        }

        if (arr[left] <= target) {
            return left;
        }

        return -1;
    }
}



// [X X X] {[X X X X] X X X} [X X X X X]
//      i   i+1    j      k  k+1
// 1. sum[0 : i] <= sum[i+1 : j]       
//     preSum[i] <= preSum[j] - preSum[i];
// 2. sum[i+1, k] <= sum[k+1 : n-1]   (where j <= k)
//     preSum[k] - preSum[i] <= preSum[n-1] - preSum[k] 
//  ==>preSum[k] <= (preSum[n-1] + preSum[i])/ 2
     
// count += k - j + 1;
    
    
// For example:
// [1,2,2,2,5,0]
// [1] [2] [2,2,5,0]
// [1] [2,2] [2,5,0]
// [1,2] [2,2] [5,0]