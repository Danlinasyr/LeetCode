class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        // dp[i] is the longest subsequence ending with num on index i ***<dragon tail>***
        int[] dp = new int[n];
        
        // initialization, the dragon start with 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max (dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        
        return max;
    }
}


/*
for each num in arr, find a num that is first greater-than num in previous subsequence replace that num with curr num
loop through the arr, find the longest increasing subarray from the start
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        List<Integer> queue;

        for (int num : nums) {
            int pos = binarySearch(queue, num);
            if (pos == queue.size()) {
                queue.add(num);
            }
            queue.set(pos, num);
        }

        return queue.size();
    }

    private binarySearch (List<Integer> queue, int target) {
        int left = 0;
        int right = queue.size();

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (queue.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (queue.get(left) >= target) {
            return left;
        } 

        if (queue.get(right) >= target) {
            return right;
        }

        return queue.size();
    }
}


// Leetcode solution combining DP with BinarySearch (java libary)

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}

