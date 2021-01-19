
// two pass, each index can water = minimum of the left side highest and right side highest - height of index.
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // leftMost[i] means the highest number from 0 to i - 1;
        int[] leftMost = new int[n];

        // rightMost[i] means the highest number from i+1 to n-1;
        int[] rightMost = new int[n];

        leftMost[0] = 0;
        for (int i = 1; i < n; i++) {
            leftMost[i] = Math.max(leftMost[i - 1], height[i - 1]);
        }

        rightMost[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMost[i] = Math.max(rightMost[i + 1], height[i + 1]);
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            int h = Math.min(leftMost[i], rightMost[i]) - height[i];
            total += Math.max(0, h * 1);
        }

        return total;
    }
}



// using mono stack one pass

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int h = Math.min(height[i], height[stack.peek()]) - height[top];
                int area = h * (i - stack.peek() - 1);
                total += area;
            }
            stack.push(i);
        }

        return total;
    }
}