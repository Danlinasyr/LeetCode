class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if ( (i & (1 << j)) != 0) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    count++;
                }
            }
            if (max - min == 1) {
                res = Math.max(res, count);
            }
        }

        return res;
    }
}


class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count += 1;
                } else if (nums[j] == nums[i] + 1) {
                    count += 1;
                    flag = true;
                }
            }
            if (flag) {
                res = Math.max(res, count);
            }

        }

        return res;
    }
}