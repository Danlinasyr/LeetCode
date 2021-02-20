class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, k, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int num, int k, List<Integer> comb, List<List<Integer>> res) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }

        for (int i = num; i <= 9; i++) {
            if (i > n) {
                continue;
            }
            comb.add(i);
            dfs(n - i, i + 1, k - 1, comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}