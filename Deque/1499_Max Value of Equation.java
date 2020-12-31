class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deq = new ArrayDeque<>();
        int maxVal = Integer.MIN_VALUE;
        int n = points.length;
        
        if (n == 2) {
            return points[1][0] - points[0][0] + points[0][1] + points[1][1];
        }
        
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && points[i][0] - points[deq.peek()][0] > k) {
                deq.poll();
            }
            
            while (!deq.isEmpty() && points[i][1] >= points[deq.peekLast()]) {
                deq.pollLast();
            }
            
            deq.offer(i);
            
            maxVal
            
        }
        
    }
}


Input: points = [{[1,3],[2,0], [4, 1]}, [5,10],[6,-10]], k = 3
                   ^            ^
                   |            |
                   xi           xj
1. sorted by the x-values
2. x1, x2, ... xi...xj,...xn    (|xi - xj| <= k)
3. yi + yj + k



