class Solution {
    public int maxResult(int[] nums, int k) {
        
        // dp[i] is the highest score you get by jumping from 0 to i and ending with i
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        Deque<Integer> d = new ArrayDeque<>(); // use to store the max score from i - k + 1 to i
        d.offer(0);
        for (int i = 1; i < n; i++) {  
            dp[i] = dp[d.peek()] + nums[i];
                        
            while (!d.isEmpty() && i - d.peek() >= k) { // to keep deque contains indexes only range i - k to i
                d.poll();
            }
            
            while (!d.isEmpty() && dp[d.peekLast()] <= dp[i]) {
                d.pollLast();
            }
            
            d.offer(i);
            
        }

        return dp[n - 1];
        
    }
}

