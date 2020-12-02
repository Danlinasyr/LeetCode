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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        
        TreeNode lowerBound = lowerBound(root, target);
        TreeNode upperBound = upperBound(root, target);
        
        if (lowerBound == null) {
            return upperBound.val;
        }
        
        if (upperBound == null) {
            return lowerBound.val;
        }
        
        if (upperBound.val - target < target - lowerBound.val) {
            return upperBound.val;  
        } else {
            return lowerBound.val;
        }
    }
    
    // find the largest treenode val that is smaller than target
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) return null;
        
        if (target <= root.val) {
            return lowerBound(root.left, target);
        }
        
        // target > root.val
        TreeNode lowerBound = lowerBound(root.right, target);
        if (lowerBound != null) {
            return lowerBound;
        }
        
        return root;
    }
    
    // find the smallest treenode val that is larger than or equal to target
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) return null;
        
        if (root.val < target) {
            return upperBound(root.right, target);
        }
        
        // target <= root.val
        TreeNode upperBound = upperBound(root.left, target);
        if (upperBound != null) {
            return upperBound;
        }
        
        return root;
    }
}