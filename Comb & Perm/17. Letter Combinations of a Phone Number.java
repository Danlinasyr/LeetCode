class Solution {


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }
        Map<Integer, List<Character>> digit2letters = new HashMap<>();
        char c = 'a';
        for (int d = 2; d <= 9; d++) {
            digit2letters.put(d, new ArrayList<>());
            if (d == 9 || d == 7) {
                for (int i = 0; i < 4; i++) {
                    digit2letters.get(d).add(c);
                    c++;
                }
            } else {
                for (int i = 0; i <  3; i++) {
                    digit2letters.get(d).add(c);
                    c++;
                }
            }
        }

        List<String> res = new ArrayList<>();
        dfs(digits, digit2letters, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, Map<Integer, List<Character>> digit2letters, int index, StringBuilder comb, List<String> res) {
        if (index == digits.length()) {
            res.add(comb.toString());
            return;
        }

        for (char c : digit2letters.get(digits.charAt(index) - '0')) {
            comb.append(c);
            dfs(digits, digit2letters, index + 1, comb, res);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}