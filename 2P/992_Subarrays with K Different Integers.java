class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
<<<<<<< HEAD
        int ans = 0;
        int intCount = 0;
        int j = 0;
        Map<Integer, Integer> intMap = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            while (j < A.length && intCount < K) {
                if (!intMap.containsKey(A[j])) {
                    intCount++;
                }
                intMap.put(A[j], intMap.getOrDefault(A[j], 0) + 1);
                j++;
            }
            
            if (intCount == K) {
                System.out.println(j);
                System.out.println(i);
                ans++;
            }
            intMap.put(A[i], intMap.get(A[i]) - 1);
            if (intMap.get(A[i]) == 0) {
                intCount--;
            }
        }
        
        return ans;
=======
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
>>>>>>> d7051d5ad5ca5d63d53840d7f49f70d046da1d73
    }
}