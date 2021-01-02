// DP without optimization
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = nums[i];
        }
        if (n == 1) return nums[0];
        for (int i = 1; i < n; ++i) { 
            int max = 0;
            for (int j = Math.max(0, i - k); j < i; ++j) { // the window size is k+1, thus the range is [i - k, i)  + [i]
                max = Math.max(max, dp[j]);
            }
            dp[i] = Math.max(dp[i], dp[i] + max);
        }
        
        
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }  
        
        return ans;
    }
}

// dp[i] = nums[i] + max(0, dp[i - 1], dp[i - 2], ..., dp[i - k])
    // dp[0] = nums[0]
    // dp[1] = nums[1] + max(0, dp[0]);
    // dp[2] = nums[2] + max(0, dp[0], dp[1])



// DP optimize with deque for calucalute the max of the sliding window k
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = nums[i];
        }
        if (n == 1) return nums[0];
        
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {  //[10,-2,-10,-5,20]
            if (!deq.isEmpty() && i - deq.peek() > k) {
                deq.poll();
            }
            
            int max = deq.isEmpty() ? 0 : dp[deq.peek()];
            dp[i] = Math.max(dp[i], dp[i] + max);  
            
            while (!deq.isEmpty() && dp[deq.peekLast()] < dp[i]) {
                deq.pollLast();
            }
            deq.offer(i);  
        }
        
        
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }  
        
        return ans;
    }
}














// XX[XXX]XX
//    2 4
//     k=2  means a window size of 3
   
//    [10 2 -10] 
//    1. keep a decreasing order, so when we popfront, we sum up the max onto the total from the window
//    2. when keep the window size fixed according to the limit, we garentee the next index come in satisfy the condition, so we are safe to popback the less qualified answer.











































class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int maxSum = 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        Deque<Integer> deq = new ArrayDeque<>();
        for (int j = 0; j < n; ++j) {  //[10,-2,-10,-5,20]
            if (!deq.isEmpty() && j - deq.peek() > k) {
                int front = deq.poll();
                if (maxSum == 0 || nums[front] > 0) {
                    maxSum += nums[front];
                }
            }
            while (!deq.isEmpty() && nums[j] >= nums[deq.peekLast()]) {
                int last = deq.pollLast();
                if (deq.isEmpty() || j - deq.peekLast() > k) {
                    maxSum += nums[last];
                }
            }
            deq.offer(j);
        }
        
        while (!deq.isEmpty()) {
            int front = deq.poll();
            if (nums[front] > 0) {
                maxSum += nums[front];
            }
        }
        
        return maxSum;   
    }
}


// XX[XXX]XX
//    2 4
//     k=2  means a window size of 3
   
//    [10 2 -10] 
//    1. keep a decreasing order, so when we popfront, we sum up the max onto the total from the window
//    2. when keep the window size fixed according to the limit, we garentee the next index come in satisfy the condition, so we are safe to popback the less qualified answer.