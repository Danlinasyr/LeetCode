class Solution {
    
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new LinkedList<>();
        }
        List<List<String>> res = dfs(s);
        return res;
    }
    
    private List<List<String>> dfs(String s) {
        List<List<String>> res = new LinkedList<>();
        for (int i = 1; i < s.length(); i++) {
            String substr = s.substring(0, i);
            if (!isValidPalindrome(substr)) {
                continue;
            }
            String suffix = s.substring(i);
            List<List<String>> partitions = dfs(suffix);
            for (List<String> partition : partitions) {
                partition.add(0, substr);
                res.add(partition);
            }
        }
        
        if (isValidPalindrome(s)) {
            List<String> tmp = new LinkedList<>();
            tmp.add(s);
            res.add(tmp);
        }
        return res;
    }
    
    private boolean isValidPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}