class Solution {
    public int minOperations(int[] nums, int x) {
        // min operations = nums.length - longest subarray (sum = total - x)
        // what about nums.length == 1?
        
        int n = nums.length;
        int max_len = -1;
        int i = 0;  //left pointer==left boundary of the subarray
        int sum = 0;
        int total = 0;
        for (int k = 0; k < n; k++) {
            total += nums[k]; // 30
        }
        
        for (int j = 0; j < n; j++) {  // right pointer move from left to right in each loop
            sum += nums[j];
            while (sum > total - x && i <=j) {
                sum -= nums[i];
                i++;
            }
            
            if (sum == total - x) {
                max_len = Math.max(max_len, j - i + 1);
            }
        }
        
        return max_len == -1 ? -1 : n - max_len;
    }
}