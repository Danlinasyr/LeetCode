class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if ((nums == null || nums.length == 0) && k != 0) {
            return 0;
        }
        
        int i = 0;
        int count = 0;
        int ans = 0;
        int n = nums.length;
        int c = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 != 0) {
                count++;
                c = 0;
            }
            while (count == k) {
                if (nums[i] % 2 != 0) {
                    count--;
                }
                i++;
                c++;
            }
            ans += c;
        }
        return ans;
    }
}


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        
        int n = nums.length;
        int i = 0;
        int total = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) {
                k--;
            }
            while (k < 0) {
                if (nums[i] % 2 == 1) {
                    k++;
                }
                i++;
            }
            total += j - i + 1;
        }
        return total;
    }
}