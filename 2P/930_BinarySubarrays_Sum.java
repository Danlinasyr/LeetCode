class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        
        
        int[] prefixSum = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        } // [0, 1, 1, 2, 2, 3]
        
        Map<Integer, Integer> count = new HashMap<>();  
        
        int ans = 0;
        for (int x : prefixSum) {
            ans += count.getOrDefault(x, 0); // +1+1+2
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }
        
        return ans;
    }
}


class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0;
        for (int x : A) {
            sum += x;
        }
        // if (S > sum) {
        //     return -1;
        // }
        int[] index = new int[sum + 2];
        int t = 0;
        // ???
        index[t++] = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                index[t++] = i;
            }  
        }
        // ??? 
        index[t] = A.length;
        int ans = 0;
        if (S == 0) {
            for (int i = 0; i < index.length - 1; i++) {
                // w : number of zeros between two consecutive ones
                int w = index[i+1] - index[i] - 1;
                ans += w * (w + 1) / 2;
            }
            
            return ans;
        }
        
        for (int i = 1; i < index.length - S; i++) {
            int j = i + S - 1;
            // current one index - previous one index
            int left = index[i] - index[i - 1];
            // next one index - current one index
            int right = index[j+1] - index[j];
            ans += left * right;
        }
        
        return ans;
    }
}