class Solution {
    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == c) {
                    continue;
                }
                String newWord = word.substring(0, i) + j + word.substring(i+1);
                if (dict.contains(newWord)) {
                    ret.add(newWord);
                }
            }
        }
        return ret;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // start == end
        
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        dict.add(beginWord);
        Map<String, List<String>> neighbors = new HashMap<>();
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.offer(beginWord);
        seen.add(beginWord);
        
        boolean found = false;
        int steps = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                String word = queue.poll();
                neighbors.put(word, new ArrayList<>());
                
                for(String nextWord : getNextWord(word, dict)) {
                    
                    // System.out.println(nextWord);
                    if (!nextWord.equals(endWord) && seen.contains(nextWord)) {
                        continue;
                    }
                    
                    if (nextWord.equals(endWord)) {
                        found = true;
                    }
                    
                    neighbors.get(word).add(nextWord);
                    queue.offer(nextWord);
                    temp.add(nextWord);
                }
            }
            steps++;
            for (String s : temp) {
                seen.add(s);
            }
            if (found) {
                break;
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, neighbors, path, res, steps);
        return res;
    }
    
    private void dfs(String s, String e, 
                     Map<String, List<String>> neighbors, 
                     List<String> path, List<List<String>> res, int steps) {
        if (steps == 0) {
            if (s.equals(e)) {
                res.add(new ArrayList<String>(path));
            }
            return;
        }
        for (String next : neighbors.get(s)) {
            path.add(next);
            dfs(next, e, neighbors, path, res, steps-1);
            path.remove(path.size() - 1);
        }
    }
}