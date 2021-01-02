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

// This is the LeetCode version for the min stack problem. The https://leetcode.com/problems/min-stack/
// The only difference I see is that its pop method doesn't need a return value;

// My pop method solution1 lead to this test case failure, but if change to solution2 it passes.

// Input : 
// ["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
// [[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]

// My output : 
// [null,null,null,null,null,null,-1024,null,-1024,null,-1024]

// Expected output : [null,null,null,null,null,null,-1024,null,-1024,null,512]

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    // Solution 1
    public void pop() {
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }

    // Solution 2
    // public void pop() {
    //     int num = stack.pop();
    //     if (num == minStack.peek()) {
    //         minStack.pop();
    //     }
    // }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}