class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        // [3, null]
        List<Integer> levels = new ArrayList<>();
        while(!queue.isEmpty()){//null 9 20
            
            TreeNode currNode = queue.poll();
            
            if(currNode == null){
                res.add(levels);
                levels = new ArrayList<>();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
                continue;
            }
            
            levels.add(currNode.val);
            if(currNode.left != null){
                queue.offer(currNode.left);
            }
                
            if(currNode.right != null){
                queue.offer(currNode.right);
            }
            
        }
        return res;
        
    }
}