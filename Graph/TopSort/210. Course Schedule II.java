class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]); 
            indegrees[pre[0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] res = new int[numCourses];
        int j = 0;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            res[j++] = currNode;
            for (int nextNode : graph[currNode]) {
                indegrees[nextNode]--;
                if (indegrees[nextNode] == 0) {
                    queue.offer(nextNode);
                } 
            }
        }
        
        if (j == numCourses) {
            return res;
        }
        return new int[] {};
    }
}