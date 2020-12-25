class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, longestWithMostXCharacters(s, k, i));
        }
        
        return ans;
    }
    
    private int longestWithMostXCharacters(String s, int k, int m) {
        int j = 0;
        int longest = 0;
        int count = 0;
        int freq = 0;
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            
            
            while (j < s.length() && count <= m) {
                char c = s.charAt(j);
                if (letters[c - 'a'] == 0) {
                    count++;
                }

                letters[c - 'a']++;
                if (letters[c - 'a'] == k) {
                    freq++;
                } 
                
                if (freq == count) {
                    longest = Math.max(longest, j - i + 1);
                }
                j++; 
            }
            
            if (letters[s.charAt(i) - 'a'] == k) {
                freq--;
            }
            
            letters[s.charAt(i) - 'a']--;
            
            if (letters[s.charAt(i) - 'a'] == 0) {
                count--;
            }
            
            
        }
        
        return longest;
        
    }
}



// XXXXaaabbcXX
    
//     {    } =  most m different letters
//     i    j   
    
    
// 26 lowercase aphabelt