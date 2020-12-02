class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            while (left + 1< right && nums[left] == nums[left + 1]) {
                left++;
            }
            
            while (left + 1 < right && nums[right] == nums[right - 1]) {
                right--;
            }
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] >= nums[left]) {
                
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                }else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        
        return false;
    }
}