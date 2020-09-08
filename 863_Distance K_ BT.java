/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        treeToGraph(root, null, map);
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        
        List<Integer> res = new ArrayList<>();
        
        
        while(!queue.isEmpty()){
            
            for(int i = 0; i < queue.size(); i++){
                TreeNode curNode = queue.poll();
                if(K==0){
                    res.add(curNode.val);
                }
                for (TreeNode neighbor : map.get(curNode)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            K--;
        }
        
        return res;
        
        
    }
    
    
    private void treeToGraph(TreeNode node, TreeNode parent, Map<TreeNode, Set<TreeNode>> map){
        if(node == null) return;
        
        if(!map.containsKey(node)){
            map.put(node, new HashSet<>());
            
            if(parent != null){
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            treeToGraph(node.left, node, map);
            treeToGraph(node.right, node, map);

            
        }
    }
}