class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
       List<Integer>[] graph = new ArrayList[org.length];
        for (int i = 0; i < org.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        int[] indegrees = new int[org.length+1];
        for (List<Integer> seq : seqs) {
            int currNode = seq.get(0);
            seq.size();
            for (int i = 1; i < seq.size(); i++) {
                indegrees[seq.get(i)]++;
                graph[currNode].add(seq.get(i));
                currNode = seq.get(i);
            }
            
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < org.length+1; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] sort = new int[org.length];
        int j = 0;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (sort[j++] != currNode) {
                return false;
            }

            for (int node : graph[currNode]) {
                indegrees[node]--;
                if (indegrees[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        
        if (j == org.length) {
            return true;
        }
        
        return false;
    }
}
