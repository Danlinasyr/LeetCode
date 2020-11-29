class Solution {
    
//      subsequence i < j --> Monotonic Stack
//      1. nums[i] < stack[top], pop(),
//      2. stack.size() + (len - i - 1) >= k   
        
    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.size() + (len - i - 1) >= k && stack.peek() > nums[i]) {
                stack.pop();
            }  
            // maintain the size of the stack
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }     
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
        
    }
}