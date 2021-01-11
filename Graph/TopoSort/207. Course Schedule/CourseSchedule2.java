class Solution {
    /*
    courses are vertices and prerequisiste relations are the directional edge from pre-course -> course 
    1. Transfer problem into graph decribed above
    2. Top sort and count the courses completed
        * need indegree, adjatient list (outgoing edges)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        // transformation to a graph
        for (int[] schedule : prerequisites) {
            // schedule {course, pre-course}
            
            // every pre-course -> course mean a indegree for course
            indegrees[schedule[0]]++;
            edges[schedule[1]].add(schedule[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        //Top sort
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int nextCourse : edges[course]) {
                indegrees[nextCourse]--;
                if (indegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}