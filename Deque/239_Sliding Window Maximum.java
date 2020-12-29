class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[] {nums[0]};
        }
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!deq.isEmpty() && deq.peek() < i - k + 1) {
                deq.poll();
            }
            
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            
            deq.offer(i);
            
            if (i >= k - 1) {
                res[j++] = nums[deq.peek()];
            }

        }
        

        return res;
    }
}