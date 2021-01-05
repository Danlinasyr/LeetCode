class MaxStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x > maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {  //TC: O(N)
        // [123454321]
        // [123455555]
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (max != stack.peek()) {
            int out = pop();
            buffer.push(out);
        }
        int res = pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        
        return res;
    }
}

class Item implements Comparable<Item> {
    public int val, id;
    
    public Item(int val, int id) {
        this.val = val;
        this.id = id;
    }
    
    public int compareTo(Item another) {
        if (this.val != another.val) {
            return another.val - this.val;
        } else {
            return another.id - this.id;
        }
    } 
}



// Solution with MinHeap and HashSet
class MaxStack {

    /** initialize your data structure here. */
    private Stack<Item> stack;
    private Queue<Item> maxHeap;
    private int globalId;
    private Set<Item> poppedSet;

    public MaxStack() {
        stack = new Stack<>();
        maxHeap = new PriorityQueue<>();
        globalId = 0;
        poppedSet = new HashSet<>();
    }
    
    public void push(int x) {
        Item item = new Item(x, globalId);
        stack.push(item);
        maxHeap.offer(item);
        globalId++;
    }
    
    public int pop() {
        clean_up_stack();
        Item item = stack.pop();
        poppedSet.add(item);
        return item.val;
    }
    
    public int top() {
        clean_up_stack();
        Item item = stack.peek();
        return item.val;
    }
    
    public int peekMax() {
        clean_up_heap();
        Item item = maxHeap.peek();
        return item.val;
    }
    
    public int popMax() {  //TC: O(N)
        clean_up_heap();
        Item item = maxHeap.poll();
        poppedSet.add(item);
        return item.val;
    }
    
    private void clean_up_stack() {
        while (!stack.isEmpty() && poppedSet.contains(stack.peek())) {
            Item item = stack.pop();
            poppedSet.remove(item);
            
            
        }
    }
    
    private void clean_up_heap() {
        while (!maxHeap.isEmpty() && poppedSet.contains(maxHeap.peek())) {
            Item item = maxHeap.poll();
            poppedSet.remove(item);
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();   // impossible to implement it in O(1)
 */