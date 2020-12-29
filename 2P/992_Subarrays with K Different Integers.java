class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
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
    }
}