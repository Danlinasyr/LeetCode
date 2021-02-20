class Solution {

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums,
                    int target, Map<Integer, Integer> memo) {
        if (target == 0) {
            return 1;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            result += dfs(nums, target - nums[i], memo);
        }

        memo.put(target, result);
        return result;
    }
}