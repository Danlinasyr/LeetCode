class MyQueue {

    /** Initialize your data structure here. */
    private Deque<Integer> stack;
    private Deque<Integer> buffer;
    public MyQueue() {
        stack = new ArrayDeque<>();
        buffer= new ArrayDeque<>();
    }
    
    private void stackToBuffer() { // Amortized TC: O(1)
        while (!stack.isEmpty()) {
            buffer.push(stack.pop());
        }
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (buffer.isEmpty()) {
            this.stackToBuffer();
        }
        return buffer.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (buffer.isEmpty()) {
            this.stackToBuffer();
        } 
        return buffer.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && buffer.isEmpty();
    }
}


// [6, 7]
// [5, 4, 3]  -> 1, 2
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */