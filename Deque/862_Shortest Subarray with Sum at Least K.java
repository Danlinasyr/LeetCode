class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        Deque<Integer> d = new ArrayDeque<>();
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + A[i];  // prefixSum[i] is the sum of nums that its index range from 0 to i - 1;
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int j = 0; j < n + 1; j++) {
            while (!d.isEmpty() && prefixSum[j] - prefixSum[d.peek()] >= K) { // sum from d.peek() + 1 to j-1
                shortest = Math.min (shortest, j - d.peek());
                d.poll();
            }
            
            while (!d.isEmpty() && prefixSum[j] <= prefixSum[d.peekLast()]) {
                d.pollLast();
            }
            d.offer(j);
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}

