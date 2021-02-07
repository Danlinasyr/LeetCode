class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums,
                     int[] used,
                     List<Integer> perm,
                     List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 1) {
                continue;
            }

            used[i] = 1;
            perm.add(nums[i]);
            dfs(nums, used, perm, res);
            used[i] = 0;
            perm.remove(perm.size() - 1);
        }
    }
}