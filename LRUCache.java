class LRUCache {
    
    class LinkedNode {
        int key, val;
        LinkedNode next;

        public LinkedNode (int key, int val; LinkedNode next) {
            this.key = key;
            this.val = val;
            this.next= next;
        }

    }
    
    private int capacity;
    private LinkedNode sentinel, tail;
    private Map<Integer, LinkedNode> keyToPrev;
    
    // initialization
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.sentinel = new LinkedNode(0, 0, null);
        this.tail = this.sentinel;
        this.keyToPrev = new HashMap<Integer, LinkedNode>(); 
    }
    
    private void pushBack(LinkedNode node) {
        keyToPrev.put(node.key, tail);
        tail.next = node;
        tail = node;
        node.next = null;
    }
    
    private void popFront() {
        LinkedNode head = sentinel.next;
        keyToPrev.remove(head.key);
        sentinel.next = head.next;
        keyToPrev.put(head.next.key, sentinel);
    }
    
    // kick the used node to the end of the list
    // 1->3->5->3
    private void kick(LinkedNode prev) {
        LinkedNode node = prev.next;
        if (node == tail) {
            return;
        }
        
        //remove the current node from the LinkedList
        prev.next = node.next;
        // update previous node in the hashmap
        keyToPrev.put(node.next.key, prev);
        
        pushBack(node);
    }
    
    
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        LinkedNode prev = keyToPrev.get(key);
        LinkdeNode curr = prev.next;
        
        kick(prev);
        
        return curr.val;
    }
    
    public void put(int key, int value) {
        if (keyToPrev.containsKey(key)) {
            kick(keyToPrev.get(key));
            tail.val = value;
            return
        }

        pushBack(new LinkedNode(key, value, null));  // key dosen't exist, add a new node to the tail
        if (keyToPrev.size() > capacity) {
            popFront();
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// Array
// **LinkedList*
// HashMap <key: key, value: LinkedList prevNode>

// LRUCache is using hashmap to implement a double linked list  
// ** if you change it's next node, you must change it's previous node 

// 2 1 3 5 3
    
// sentinel -> 2 -> 1 -> 3
//             |
//             ----------|

// Cache               vs         Hashtable
// limited size                   expansible


