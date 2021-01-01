class Solution {
    
    public int largestRectangleArea(int[] heights) {
        // use a mono non-decreasing queue to store the heights
        Deque<Integer> minDeque = new ArrayDeque<>();
        // use a queue to store heights within the optimal width
        Deque<Integer> queue = new ArrayDeque<>();
        
        int largest = 0;
        for (int height : heights) { // [1,2,2]  |  [1,2,3,4,5]
            while (!queue.isEmpty() && height >= minDeque.peek() * (queue.size() + 1)) {
                if (queue.peek() == minDeque.peek()) {
                    minDeque.poll();
                }
                queue.poll();
            }
            
            queue.offer(height); // [2, 3]
            while (!minDeque.isEmpty() && height < minDeque.peek()) {
                minDeque.poll();
            }
            minDeque.offer(height); // [2, 3]
            largest = Math.max(largest, queue.size() * minDeque.peek()); //1,
        }
        
        return largest;
    }
}


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        
        return maxArea;
    }
}
    
    

