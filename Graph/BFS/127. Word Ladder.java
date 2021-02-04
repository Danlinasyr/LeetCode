class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner cases : 
        
        
        // proprocess the wordList into a dictionary set so that we check the nextWord is valid in O(1);
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int distance = 1;

        // BFS
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return distance;
                }
                List<String> nextWords = getNextWord(currWord, visited, dict);
                for (String nextWord : nextWords) {
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
            distance++;
        }
     return 0;   

    }
    
    private List<String> getNextWord(String word, Set<String> visited, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (char nc = 'a'; nc <= 'z'; nc++) {
                if (c == nc) {
                    continue;
                }
                String nextWord = word.substring(0, i) + nc + word.substring(i+1);
            
                if (!visited.contains(nextWord) && dict.contains(nextWord)) {
                    res.add(nextWord);
                }
            }
        }
        return res;
    }
    
     //"hot","dot","dog","lot","log","cog" 
    
//     hit -> hot - lot -> log -> cog
//         -> hot -> dot -> dog -> cog
}