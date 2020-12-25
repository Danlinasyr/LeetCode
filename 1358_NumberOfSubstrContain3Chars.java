class Solution {
    public int numberOfSubstrings(String s) {
        
        int i = 0;
        int ans = 0;

        int[] count = new int[] {0, 0, 0};
        for (int j = 0; j < s.length(); j++) { 
            count[s.charAt(j) - 'a']++;
            while (i < s.length() && count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += s.length() - j;
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        
        return ans;
    }
}