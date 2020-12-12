class Solution {
    
    /*
    {a, b} c {d, e} f   2 X 2 combinations
    
    */
    public String[] expand(String S) {
        if (S == null || S.length() == 0) return null;
        
        
        List<String> res = new ArrayList<>() ;
        dfs(S, 0, new StringBuilder(), res);
        
        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    private void dfs(String s, int index, StringBuilder sb, List<String> res) {
        
        // finished explore all the index of the given String S
        if (index == s.length()) {
            if (sb.length() > 0) {
                res.add(sb.toString());
                return;
            }
        }
        
        char c = s.charAt(index);
        
        if (c == '{') {
            int endIndex = index + 1;
            int position = sb.length();
            List<Character> charList = new ArrayList<>();
            while (endIndex < s.length() && s.charAt(endIndex) != '}') {
                if (Character.isLetter(s.charAt(endIndex))) {
                    charList.add(s.charAt(endIndex));
                }
                endIndex++;
            }
            Collections.sort(charList);
            for (char ch : charList) {
                sb.append(ch);
                dfs(s, endIndex + 1, sb, res);
                sb.setLength(position);
            }
        } else if (Character.isLetter(c)) {
            sb.append(c);
            dfs(s, index+1, sb, res);
        }
        
    }
}