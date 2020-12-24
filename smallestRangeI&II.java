//908. Smallest Range I
/*
Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
After this process, we have some array B.
Return the smallest possible difference between the maximum value of B and the minimum value of B.

Example 1:
Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:
Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:
Input: A = [1,3,6], K = 3
Output: 0
Explanation: B = [3,3,3] or B = [4,4,4]
 
Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
*/

class Solution { // tc: O(max(K^2, n*logn)), sc: O(1)
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int ans = A[n - 1] - A[0];
        for (int i = -K; i <= K; i++) {
            for (int j = -K; j <= K; j++) {
               ans = Math.min(ans, Math.abs(A[n-1]+i - A[0]+j)); 
            }
            
        }
        return ans;
    }
}



/*
Approach 1: Linear Scan
Intuition

As in Smallest Range I, smaller A[i] will choose to increase their value ("go up"), and bigger A[i] will decrease their value ("go down").

Algorithm

We can formalize the above concept: if A[i] < A[j], we don't need to consider when A[i] goes down while A[j] goes up. This is because the interval (A[i] + K, A[j] - K) is a subset of (A[i] - K, A[j] + K) (here, (a, b) for a > b denotes (b, a) instead.)

That means that it is never worse to choose (up, down) instead of (down, up). We can prove this claim that one interval is a subset of another, by showing both A[i] + K and A[j] - K are between A[i] - K and A[j] + K.

For sorted A, say A[i] is the largest i that goes up. Then A[0] + K, A[i] + K, A[i+1] - K, A[A.length - 1] - K are the only relevant values for calculating the answer: every other value is between one of these extremal values.

*/

class Solution {
    public int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int ans = A[n-1] - A[0];
        
        for (int i = 0; i < n - 1; i++) {
            int a = A[i], b = A[i+1];
            int high = Math.max(A[n-1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        
        return ans;
    }
}