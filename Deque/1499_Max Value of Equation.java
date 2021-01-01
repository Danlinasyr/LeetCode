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


class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int maxVal = Integer.MIN_VALUE;
        int n = points.length;
        
        if (n == 2) {
            return points[1][0] - points[0][0] + points[0][1] + points[1][1];
        }
        
        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && points[i][0] - points[deq.peek()][0] > k) {  
                //"while" vs "if" coz: here every entry might cause previous multiple
                // entry violate the rule xj - xi <= k
                deq.poll();
            }
            
            if (!deq.isEmpty()) { // every entry would check about the top of queue, so try to update the max
                 maxVal = Math.max(maxVal, points[i][0] + points[i][1] - points[deq.peek()][0] + points[deq.peek()][1]);
            }
            
            while (!deq.isEmpty() && points[i][1] - points[i][0] >= points[deq.peekLast()][1] - points[deq.peek()][0]) {
                deq.pollLast();
            }
            
            deq.offer(i);
            
        }
        
        return maxVal;
        
    }
}


// Input: points = [{[1,3],[2,0], [4, 1]}, [5,10],[6,-10]], k = 1
//                    ^            ^
//                    |            |
//                    xi           xj
// 1. sorted by the x-values
// 2. x1, x2, ... xi...xj,...xn    (|xi - xj| <= k)
// 3. yi + yj + k




