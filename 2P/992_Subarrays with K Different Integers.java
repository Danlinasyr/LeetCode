class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        // K == 0 ?? 
        
        return atMost(A, K) - atMost(A, K - 1);
    }
    
    private int atMost(int[] A, int k) {
        if (k == 0) {
            return 0;
        }
        
        int i = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; j++) {  //[1,2,1,2,3] k = 2
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);                               // ^ ^  
            if (map.get(A[j]) == 1) {
                k--;
            }
            
            while (i <= j && k < 0) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    k++;
                }
                i++;
            }
            count += j - i + 1;
            
        }
        return count;
    }
}