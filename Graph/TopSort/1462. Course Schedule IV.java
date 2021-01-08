class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // build a graph and indegree count with prerequisites 2-D array
        // topological sort it and create a map for each course sorting order
        // check each query, which index 0 has order smaller than index 1

        Set<Integer>[] graph = new HashSet[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }


        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        Set<Integer>[] precourses = new HashSet[n];
        for (int i = 0; i < n; i++) {
            precourses[i] = new HashSet<Integer>();
        }

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int course = queue.poll();

                for (int nextCourse : graph[course]) {
                    precourses[nextCourse].add(course);
                    for (int pre : precourses[course]) {
                        precourses[nextCourse].add(pre);
                    }
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (precourses[queries[i][1]].contains(queries[i][0])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }
}