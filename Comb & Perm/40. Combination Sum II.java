class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;

    }

    // recursion tree :  1 1 2 5 6 7 10
    //                         []
    //               [1] [1] [2] [5] [6] [7] [10]
    //             [1, 1] [1, 2]



    private void dfs(int[] candidates, int index, int remain, List<Integer> comb, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > remain) {
                continue;
            }
            comb.add(candidates[i]);
            dfs(candidates, i + 1, remain - candidates[i], comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}