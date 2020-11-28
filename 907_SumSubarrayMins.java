class Solution {
    
    public int sumSubarrayMins(int[] arr) {
        
        Stack<int[]> previousLess = new Stack<>();
        Stack<int[]> nextLess = new Stack<>();
        
        int[] leftDistance = new int[arr.length];
        int[] rightDistance = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            leftDistance[i] = i + 1;
            rightDistance[i] = arr.length - i;
        }
        
        
        for (int i = 0; i < arr.length; i++) {
            while (!previousLess.isEmpty() && previousLess.peek()[0] > arr[i]) {
                previousLess.pop();
            }
            
            leftDistance[i] = previousLess.isEmpty() ? i + 1 : i - previousLess.peek()[1];
            previousLess.push(new int[] {arr[i], i});
        }
        
        for (int i = 0; i < arr.length; i++) {
            while (!nextLess.isEmpty() && nextLess.peek()[0] > arr[i]) {
                rightDistance[nextLess.peek()[1]] = i - nextLess.peek()[1];
                nextLess.pop();
            }
            nextLess.push(new int[] {arr[i], i});
        }
        
        int ans = 0;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            ans = (int) ((ans + (long) arr[i] * leftDistance[i] * rightDistance[i]) % mod);
        }
        return ans;
    }
}