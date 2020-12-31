class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length - k + 1];
        
        //one pass sliding window, keep a mono queue for storing the index of potential max
        // 1. keep size of queue == k (pop_front)
        // 2. keep queue non-increasing order in term of value of the index(pop_back)
        
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() + k <= i) {
                deque.poll();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // keep the index because we need to check if index at the the front/top
            // of queue is out to date (need to toss of the sliding window)
            deque.offer(i);
            
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peek()];
            }
        }
        
        return ans;
    }
}

// Window position               Deque/Queue
// ---------------               -----
// [1] 3 -1  -3  5  3  6  7       [1]
// [1  3]-1  -3  5  3  6  7       [3]
// [1  3 -1] -3  5  3  6  7       [3, -1]            i = 2 = k - 1 = 3 - 1
// 1  [3 -1  -3] 5  3  6  7       [3, -1, -3] 
// 1   3[-1  -3  5] 3  6  7       [5] 
// 1   3 -1 [-3  5  3] 6  7       [5, 3] 
// 1   3 -1  -3 [5  3  6] 7       [6]
// 1   3 -1  -3  5 [3  6  7]      [7]

