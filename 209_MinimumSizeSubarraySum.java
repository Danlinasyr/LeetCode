class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        } // [0, 1, 3, 6, 10, 15]
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefixSum[j] - prefixSum[i] + nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) return 0;
        
        int left = 0;
        
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right &&  sum >= s) {
                min_len = Math.min (min_len, right - left + 1);
                sum -= nums[left++];
            }
        }
        
        return min_len != Integer.MAX_VALUE ? min_len : 0;
    }
}