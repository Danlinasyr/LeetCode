class Solution {
    
    /*
    c*a?b
    caab
    */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        return isMatchHelper(s, 0, p, 0);
    }
    
    private boolean isMatchHelper(String s, int sIndex, String p, int pIndex) {
        
        if (pIndex == p.length()) {
            // if p is empty now, s has to empty as well to be able to match
            return sIndex == s.length();
        }
        
        if (sIndex == s.length()) {
            
            // when s is empty,unless p is all *...*
            return allStar(p, pIndex);
        }
        
        char sFirstChar = s.charAt(sIndex);
        char pFirstChar = p.charAt(pIndex);
        
        if (pFirstChar != '*') {
            return charMatch(sFirstChar, pFirstChar) && isMatchHelper(s, sIndex + 1, p, pIndex + 1);
        }
        
        for (int i = sIndex; i <= s.length(); i++) {
            if (isMatchHelper(s, i, p, pIndex + 1)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    
    private boolean allStar(String p, int index) {
        for (int i = index; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean charMatch(char s_ch, char p_ch) {
        return (s_ch == p_ch || p_ch == '?');
    }
}