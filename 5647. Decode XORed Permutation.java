class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        List<Integer> perm = new ArrayList<>();
        int[] used = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = n - 1;
            int[] perm = new int[n];
            perm[k--] = i;
            used.add(i);
            for (int j = n - 2; j >= 0; j--) {
                perm[k] = encoded[j] ^ perm[k + 1];
                if (used.contains(perm[k]) || perm[k] > n || perm[k] == 0) {
                    break;
                } else {
                    used.add(perm[k]);
                }
            }
            if (k == 0) {
                return perm;
            }
        }
        return new int[] {};
    }

}


// 0001    0010
// 0010    0011
// 0011    0001

//    encoded[n - 1] XOR perm[n] -> perm[n-1]
//    encoded[n - 2] XOR perm[n-1] -> perm[n-3]