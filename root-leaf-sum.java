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
    private List<List<Integer>> paths = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        helper(root, path);
        int sum = 0;
        for(List<Integer> p: paths){
            int num = 0;
            for(int i = 0; i < p.size(); i++){
                num += Math.pow(2, p.get(i));
            }
            sum += num;
        }
        
        return sum;
        
    }
    
    /*
    input: node, paths, path
    
    base case: node == null paths.add(path);
    recurrence: path.add(node.val)   <1, 0>  <1, 1>
    
                helper(node.left, path); 
                helper(node.right, path);
    
    */
    private void helper(TreeNode node, List<Integer> path){ // 1, {}
        if(node == null) {
            paths.add(path);
            return;
        }
        
        path.add(node.val);  //{1, 0, 0}
        helper(node.left, path);  
        helper(node.right, path); 
    }
}