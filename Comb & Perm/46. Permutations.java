class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int[] seen = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, seen, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, int[] seen, List<Integer> perm, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen[i] == 1) {
                continue;
            }
            perm.add(nums[i]);
            seen[i] = 1;
            dfs(nums, index + 1, seen, perm, res);
            perm.remove(perm.size() - 1);
            seen[i] = 0;
        }
    }
}