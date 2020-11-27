class StockSpanner {
    /*
    1. use a stack to store today's price and result (max number of consecutive days)
    2. when today's price bigger than the stack top, pop the stack top, accumulate the max consecutive day
    
    [100, 80, 60, 70, 60, 75, 85]

    stack: (100, 1) (80, 1) (70, 2) (60, 1)
    */
    
    Stack<int[]> stack;
    public StockSpanner() {
         stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        stack.push(new int[] {price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */