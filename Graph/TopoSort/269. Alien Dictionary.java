class Solution {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = buildGraph(words);
        if (graph == null) {
            return "";
        }

        Map<Character, Integer> indegree = getIndegree(graph);


        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char currNode = queue.poll();
            res.append(currNode);
            for (char neighbor : graph.get(currNode)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (graph.size() != res.length()) {
            return "";
        }

        return res.toString();

        /*
        Input: words = ["wrt","wrf","er","ett","rftt"]
        Output: "wertf"
        */

    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }

            }
        }


        for (int i = 0; i < words.length - 1; i++) {

            String word = words[i];
            String nextWord = words[i + 1];
            int index = 0;
            while (index < word.length() && index < nextWord.length()) {
                if (word.charAt(index) == nextWord.charAt(index)) {
                    index++;
                } else {
                    graph.get(word.charAt(index)).add(nextWord.charAt(index));
                    break;
                }

            }

            if (index == Math.min(word.length(), nextWord.length())) {
                if (word.length() > nextWord.length()) {
                    return null;
                }
            }

        }

        return graph;
    }

    private Map<Character, Integer> getIndegree (Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();

        for (char node : graph.keySet()) {
            indegree.put(node, 0);
        }

        for (char node : graph.keySet()) {
            for (char neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        return indegree;
    }
}

