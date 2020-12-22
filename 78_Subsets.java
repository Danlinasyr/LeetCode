class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // << shift left   1 << n means, 2^n
        for (int i = 0; i < (1<<n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}


// bitmask      combination
// 000 => 0     []
// 001 => 1     [1]
// 010 => 2     [2]
// 011 => 3     [1,2]   
// 100 => 4     [3]
// 101 => 5     [1,3]
// 110 => 6     [2,3]
// 111 => 7     [1, 2, 3]