class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] charSet = new int[256];
        int i = 0;
        int count = 0;
        int max_len = 0;
        for (int j = 0; j < n; j++) {
            if (charSet[s.charAt(j)] == 0) {
                count++;
            }
            charSet[s.charAt(j)]++;
            while (i < j && count > 2) {
                charSet[s.charAt(i)]--;
                if (charSet[s.charAt(i)] == 0) {
                    count--;
                }
                i++;
            }
            
            max_len = Math.max(max_len, j - i + 1);
        }
        
        return max_len;
    }
}
