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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        helper(root, L, R, sum);
        return sum;
    }
    
    public void helper(TreeNode node, int L, int R, int sum){
        if(node == null) return;
        
        if (node.val >= L && node.val <= R){
            sum += node.val;
            helper(node.left, L, R, sum);
            helper(node.right, L, R, sum);
        }else if(node.val < L){
            helper(node.right, L, R, sum);
        }else if(node.val > R){
            helper(node.left, L, R, sum);
        }
    }
}