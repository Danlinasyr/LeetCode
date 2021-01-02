class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // store index since the answer we are looking for is related to the length of the subarray
        
        int n = nums.length;
        if (n == 1) return 1;
        Deque<Integer> minDeq = new ArrayDeque<>();  
        Deque<Integer> maxDeq = new ArrayDeque<>();
        int longest = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            
            while (!maxDeq.isEmpty() && nums[j] > nums[maxDeq.peekLast()]) {
                maxDeq.pollLast();
            }
            maxDeq.offer(j);
            
            while (!minDeq.isEmpty() && nums[j] < nums[minDeq.peekLast()]) {
                minDeq.pollLast();
            }
            minDeq.offer(j);
            
            while (i <= j && nums[maxDeq.peek()] - nums[minDeq.peek()] > limit) {
                if (maxDeq.peek() == i) {
                    maxDeq.poll();
                }
                if (minDeq.peek() == i) {
                    minDeq.poll();
                }
                i++;
            }
            
            longest = Math.max(longest, j - i + 1);
        }
        
        return longest;
    }
}





// previously what I know about the mono queue or deque DS technique:

// 1. popFront when the front is out to date => violate the limit
// 2. popBack based on the order you keep => keep a increaseing order so that front is the smallest element in the window




// previously what I know about the mono queue or deque DS technique:

// 1. popFront when the front is out to date => violate the limit
// 2. popBack based on the order you keep => keep a increaseing order so that front is the smallest element in the window