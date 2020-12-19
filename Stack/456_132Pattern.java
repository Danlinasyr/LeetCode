class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i-1],  nums[i-1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums[i]) {
                if (stack.peek() > mins[i]) {
                    return true;
                }
                stack.pop();
            }
            
            stack.push(nums[i]);
        }
        
        return false;
    }
}