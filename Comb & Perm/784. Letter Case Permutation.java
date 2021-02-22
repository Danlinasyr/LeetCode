class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String s, int index, StringBuilder perm, List<String> res) {
        if (index == s.length()) {
            res.add(perm.toString());
            return;
        }
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            perm.append(Character.toLowerCase(c));
            dfs(s, index + 1, perm, res);
            perm.deleteCharAt(perm.length() - 1);
            perm.append(Character.toUpperCase(c));
            dfs(s, index + 1, perm, res);
            perm.deleteCharAt(perm.length() - 1);
        } else {
            perm.append(c);
            dfs(s, index + 1, perm, res);
            perm.deleteCharAt(perm.length() - 1);
        }

    }
}