class MaxStack {

    List<Integer> stack;
    List<int[]> maxPair;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayList<>();
        maxPair = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        
        if(maxPair.isEmpty() || x > peekMax()){
            maxPair.add(new int[]{x, 1});
        }
        
        if( x == peekMax()){
            maxPair.get(maxPair.size() - 1)[1]++;
        }
    }
    
    public int pop() {
        
        
        if(top() == peekMax()){
            maxPair.get(maxPair.size() - 1)[1]--;
        }
        
        if(maxPair.get(maxPair.size() - 1)[1] == 0){
            maxPair.remove(maxPair.size() - 1);
        }
        
        return stack.remove(stack.size() - 1);
        
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int peekMax() {
        return maxPair.get(maxPair.size() - 1)[0];
    }
    
    public int popMax() {
        int res = peekMax();
        maxPair.get(maxPair.size() -1)[1]--;
        
        if(maxPair.get(maxPair.size() - 1)[1] == 0){
            maxPair.remove(maxPair.size() - 1);
        }
        
        for(int i = stack.size() - 1; i >= 0; i--){
            if(stack.get(i) == res){
                stack.remove(i);
                break;
            }
        }
        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */