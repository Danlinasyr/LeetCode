class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int max_len = 0;
        int[] charSet = new int[128];
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(charSet[s.charAt(j)], i);
            max_len = Math.max(max_len, j - i + 1);
            charSet[s.charAt(j)] = j + 1;
        }
        
        return max_len;
    }
}

//     "abcabcbb"
//      ^  ^
     
//      abcdbXXXX
//        ^ ^
//        i j
     
//      charSet[b] != 0