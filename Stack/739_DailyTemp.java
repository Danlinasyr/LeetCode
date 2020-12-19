class Solution {
    
    /*
    [73, 74, 75, 71, 69, 72, 76, 73]

    

    1. if we see a greater temp > stack[top], pop until stack[top] < temp
    2. when poping from stack, res[i] = currIndex - i, where i is the popped index
    3. push index of current temp into a stack, 
    4. if there is any index left in stack, we pop them and res[i] = 0
    
    stack : (6, 76) (7, 73)
    res   : 1, 1, 4, 2, 1, 1, 0, 0
    */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return T;
        
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int popedIndex = stack.pop();
                res[popedIndex] = i - popedIndex;
            }
            stack.push(i);
        }
        
        return res;
    }
}