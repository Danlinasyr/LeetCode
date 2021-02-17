class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      dfs(nums, i, 0, new ArrayList<>(), res);
    }
    return res;
  }

  private void dfs(int[] nums,
                   int n,
                   int index,
                   List<Integer> subset,
                   List<List<Integer>> res) {
    if (subset.size() == n) {
      res.add(new ArrayList<>(subset));
      return;
    }

    for (int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[i - 1]) {
        continue;
      }
      subset.add(nums[i]);
      dfs(nums, n, i + 1, subset, res);
      subset.remove(subset.size() - 1);
    }
  }
}

//       [1] [2]
//   [1, 2]  [2, 2]
// [1, 2, 2]

