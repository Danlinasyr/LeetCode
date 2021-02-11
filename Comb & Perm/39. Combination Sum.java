class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[candidates.length];
        //1 <= candidates.length <= 30  no corner case then

        Arrays.sort(candidates);
        dfs (candidates, new ArrayList<Integer>(), 0, visited, 0, target, res);
        return res;
    }

    private void dfs(int[] candidates,
                     List<Integer> comb,
                     int sum,
                     int[] visited,
                     int currPos,
                     int target,
                     List<List<Integer>> res) {

        if (sum == target) {
            res.add(new ArrayList<Integer> (comb));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = currPos; i < candidates.length; i++) {

//             if (i > 0 && candidates[i] == candidates[i-1] && visited[i-1] == 0) {
//                 continue;
//             }
            comb.add(candidates[i]);
            visited[i] = 1;
            dfs(candidates, comb, sum + candidates[i], visited, i, target, res);
            comb.remove(comb.size() - 1);
            visited[i] = 0;
        }
    }
}