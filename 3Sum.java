class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            -4, -1, -1, 0, 1, 2
            0   1   2   3  4  5
            
            if target = 4 :  nums[4] + nums[5] < 4
               target = 1 :  nums[3] + nums[4]   (skip 2 beacase nums[2] = num[1])
               
        */
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                twoSumII(nums, i , res);
            }
        }
        return res;
    }
    
    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while(lo != hi){ 
            int sum = nums[lo] + nums[hi] + nums[i];
            if(sum < 0){
                lo++;
            }else if (sum > 0){
                hi++;
            }else{
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo -1]){
                    lo++;
                }
            }
        }

    }
}