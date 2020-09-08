class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        /*   subarray + limit  implies this is a sliding window problem
            the goal of this problem is to find the longest subarray
            
            if max - min < limit : the subarray would satisfy
            
            10  1  2  4  7  2
            
                   ^
                         ^    
                   min
        */
        if(nums.length <= 1) return nums.length;
        
        int min = Integer.MAX;
        int max = Integer.MIN;
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++){
            
            maxCount = Math.max(maxCount, count);
            for(int j = i; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                
                if(max - min > limit){
                    break;
                }
                
                count++;
            }

            

        }
        
    }
}