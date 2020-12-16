class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int j = 0;
        while (j < n && nums[j] < 0) {
            j++;
        }
        int i = j - 1;  // edge case i = 0 - 1 = -1
        
        int[] ans = new int[n];
        int t = 0;
        while (i >= 0 && j < n) {
            
            while (i >= 0 && nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[t++] = nums[i] * nums[i];
                i--;
            }
            
            while (j < n && nums[i] * nums[i] >= nums[j] * nums[j]) {
                ans[t++] = nums[j] * nums[j];
                j++;
            }
        }
        
        while (i >= 0) {
            ans[t++] = nums[i] * nums[i];
        }
        
        while (j < n) {
            ans[t++] = nums[j] * nums[j];
        }
        
        return ans;
    }
}