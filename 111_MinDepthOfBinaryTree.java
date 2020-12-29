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

// DFS - tree traversal  

class Solution {
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 1);
        return min;
    }
    
    // input : currNode and tree depth at the root the of currNode
    // return the height of treeNode...
    private void minDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
        }
        
        if (node.left != null) {
           minDepth(node.left, depth+1); 
        }
        if (node.right != null) {
           minDepth(node.right, depth+1);
        }
        
    }
}



// without global virables
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
        
    }
    
    // base case : left and right node are null, we get depth 1 
    //             return MAX_VALUE if node is null
    // recursion rule : add 1 onto the minimum between left and right recursion call
    private int getMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        return Math.min(getMin(node.left), getMin(node.right)) + 1;
        
    }
}


// within one recursion function (no helper) to compare with method above 
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) { // treat root.left or root.right is null as a another base case so that when root == null case can be unify as return 0;
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
}




// BFS
class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 0) {
                depth = depth + 1;
            }
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                
                if (currNode == null) {
                    continue;
                }
                if (currNode.left == null && currNode.right == null) {
                    return depth;
                } 
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right); 
                }
                
            }

        }
        return depth;
    }
}