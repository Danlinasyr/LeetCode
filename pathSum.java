/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, new ArrayList<>(), sum, res);
        return res;
    }
    
    private void dfs(TreeNode root, 
                     int pathSum, 
                     List<Integer> path,
                     int sum, 
                     List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        pathSum += root.val;
        path.add(root.val);
        int sz = path.size();
        
        if (root.left == null && root.right == null) {
            if (pathSum == sum) {
                res.add(new ArrayList<>(path));
            }
        }
        
        dfs(root.left, pathSum, path, sum, res);
        List<Integer> rightPath = path.subList(0, sz);
        dfs(root.right, pathSum, rightPath, sum, res);
    }
}