/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


<Recursion>
    input:curNode
    output: lastChildNode
    
    TreeNode prevNode = null;
    while(curNode != null){
        
        Basecase: curNode.child == null     -> contine;
        Recurrence: lastChildNode = recursion(curNode.child)
                    curNode.next.prev = lastChildNode;
                    lastChildNode.next = curNode.next;
                    curNode.next = lastChildNode;
                    
        prevNode = curNode;
        curNode = curNode.next
    }
    
    return prevNode;

    
*/

class Solution {
    public Node flatten(Node head) {

        dfs(head);
        return head;
        
    }
    
    private Node dfs(Node curNode){ //1
        
        Node prevNode = null;
        while(curNode != null){

            if(curNode.child != null){ //3,8
                Node lastChildNode = dfs(curNode.child);
                curNode.next.prev = lastChildNode;
                lastChildNode.next = curNode.next;
                curNode.next = curNode.child;
                curNode.child = null;
                curNode = lastChildNode;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }

        return prevNode;
    }
}