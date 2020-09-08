class Solution {
    public String alienOrder(String[] words) {
        
      /*
      edge case: 1. if it is a cycle, return ""
                 2. if word1 starts with the word2
      [
        "wrt",
        "wrf",
        "er",
        "ett",
        "rftt"
      ]
      */

      //Algo part 0: the alien letter in the order should only contains the letters that are in the word list.
      //   - Use a HashMap to keep count of letter apperance, intially just keep the unique record, later on to keep the record for indegree edges
      //   - Graph, Use a HashMap to keep adjacent list of the vertices (all the unique letters)
      Map<Character, Integer> count = new HashMap<>();
      Map<Character, List<Character>> graph = new HashMap<>();

      for(word : words){
        for(char c : word.toCharArrays()){
          count.put(c, 0);
          graph.put(c, new ArrayList<>())
        }
      }


      /*
      Algo part1: first diff letter, 1st alphabet   directed to   2nd alphabet
      + edge case 2
      wrt, wrf :  t -> f
      wrf, er  :  w -> e
      er, et   :  r -> t
      ett, rftt:  e -> r

      wrt -> wrf -> er -> et -> rftt
      */

      for(int i = 0; i < words.length - 1; i++){
        String word1 = words[i];
        String word2 = words[i+1];

        if(word1.startsWith(word2)){
          return "";
        }

        for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
          Character c1 = word1.charAt(j);
          Character c2 = word2.charAt(j);
          if(c1 != c2){
            graph.put(c1, graph.get(c1).add(c2));
            count.put(c1, count.get(c1) + 1);
            break;
          }
        }
      }



      /*
      Algo part2: sort the graph in topoligical order
      w -> e -> r -> t -> f
      */
      Queue<Character> queue = new LinkedList<>();

      for(Character c : count.keySet()){
        if(count.get(c) == 0){
          queue.offer(c);
        }
      }

      // String to return
      StringBuilder sb = new StringBuilder();

      while(!queue.isEmpty()){
        Character visited = queue.poll();
        sb.append(visited);

        for(Character next : graph.get(visited)){
          count.put(next, count.get(next)-1);
          if(count.get(c) == 0){
            queue.add(c);
          }

        }

      }


      if(sb.length < counts.size()){
        return "";
      }

      return sb.toString();
        
   
        
    }
}