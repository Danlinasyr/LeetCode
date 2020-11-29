class Solution {
    
    /*
    [6,0,8,2,1,5]
     ^            
    
    */  
    public int maxWidthRamp(int[] A) {
        
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[i] < A[stack.peek()]) {
                stack.push(i);
            }
        }
            
        for (int j = A.length - 1; j > maxWidth; j--) {
            while (!stack.isEmpty() && A[j] >= A[stack.peek()]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            } 
        }
        
        return maxWidth;
    }
}