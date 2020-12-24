class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;
        int n = s.length();
        if (n * k == 0) return 0;
        
        int max_len = 1;
        int left = 0, right = 0, count = 0;
        int[] charSet = new int[128];

        for (; right < n; right++) { 
            if (charSet[s.charAt(right)] == 0) {
                count++;
            }
            
            charSet[s.charAt(right)]++;
            
            if (count > k) {
                charSet[s.charAt(left)]--;
                
                if (charSet[s.charAt(left)] == 0) {
                    count--;
                }
                left++;
            }
            
        }
        
        return right - left;
        
    }
}