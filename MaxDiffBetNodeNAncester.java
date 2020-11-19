/*
[8,3,10,1,6,null,14,null,null,4,7,13]

                    8
              3           10      
        1         6          14
                4   7       13    
              
*/


class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int maxDiff = Integer.MIN_VALUE;
        int visitedMax = Integer.MAX_VALUE;
        int visitedMin = Integer.MIN_VALUE;

        int visitingMax;
        int visitingMin;
        
        Deque<TreeNode> queue  = new ArrayDeque<>();1 
        queue.offer(root);
        
        //BFS + Level Traversal
        while(! queue.isEmpty()){
            visitingMax = Integer.MAX_VALUE;
            visitingMin = Integer.MIN_VALUE;
            for(int i = 0; i < queue.size(); i++){
                TreeNode node = queue.poll();
                Math.max(visitingMax, node.val);
                Math.min(visitingMin, node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            maxDiff = Math.max(Math.abs(visitedMax - visitingMin), Math.abs(visitedMin - visitingMax));    
            // update visited Max and Min
            visitedMax = Math.max(visitedMax, visitingMax);
            visitedMin = Math.min(visitedMin, visitingMin);
        }
        
        return maxDiff;
        
    }
}