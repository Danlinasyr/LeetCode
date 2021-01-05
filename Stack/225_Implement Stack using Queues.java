class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    private Queue<Integer> buffer;
    public MyStack() {
        queue = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }
    
    private void moveItems() {
        while (queue.size() != 1) {
            buffer.offer(queue.poll());
        }
    }
    
    private void switchQueue() {
        Queue<Integer> temp = buffer;
        buffer = queue;
        queue = temp;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        moveItems();
        int res = queue.poll();
        switchQueue();
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        int res = pop();
        queue.offer(res);
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */