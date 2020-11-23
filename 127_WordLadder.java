class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // hit -> hot -> dot -> dog -> cog
        // hit -> hot -> lot -> log -> cog
        
        /*
        Think: if at every transformation, we consider all possible words to transform to. 
        At certain step, we should be able to get to the endWord, the first time we get the endWord, it is the short path to endWord.
        */
        
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        
        queue.offer(beginWord);
        map.put(beginWord, 1);  //distance including the beginWord
        
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            for(String nextWord : getNextWords(currWord, wordList)) {
                if (nextWord.equals(endWord)) return map.get(currWord) + 1;
                
                if (!map.containsKey(nextWord)) {
                    queue.offer(nextWord);
                    map.put(nextWord, map.get(currWord) + 1);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String word, List<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < word.length(); i++) {
            for (char c : alphabet.toCharArray()) {
                String nextWord = replace(word, i, c);
                if (wordList.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        
        return nextWords; 
    }
    
    private String replace (String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}