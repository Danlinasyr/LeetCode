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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, path, paths);
        
        return paths;
    }
    
    private void dfs(TreeNode root, StringBuilder path, List<String> paths) {
        if (root == null) {
            return;
        }
        
        path.append(root.val);
        path.append("->");
         
        if (root.left == null && root.right == null) {
            paths.add(path.substring(0, path.length() - 2));
            return;
        }
        

        int sz = path.length(); //1
        dfs(root.left, path, paths);
        // backtracking path to current recursion
        path = path.delete(sz, path.length());
        dfs(root.right, path, paths); 
    }
}