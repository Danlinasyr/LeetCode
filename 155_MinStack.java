class MinStack {
    
    class Element {
        int val;
        int min;
        public Element(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    private Stack<Element> stack;
    /** initialize your data structure here. */
    public MinStack() {
         stack = new Stack<Element>();
    }
    
    public void push(int x) {
        int min;
        if (stack.isEmpty()) {
            min = x;
        } else {
            min = Math.min (stack.peek().min, x);
        }
        stack.add(new Element(x, min));
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */