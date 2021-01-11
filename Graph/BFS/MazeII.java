public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    int[][] DIRECTIONS = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        Queue<Integer> queue = new LinkedList<>();
        int n = maze.length, m = maze[0].length;
        Map<Integer, Integer> distance = new HashMap<>();
        
        queue.offer(start[0] * m + start[1]);
        distance.put(start[0] * m + start[1], 0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / m;
            int y = index % m;
            
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                int count = 0;
                while (isVaild(newX, newY, maze)) {
                    newX += direction[0];
                    newY += direction[1];
                    count += 1;
                }
                newX -= direction[0];
                newY -= direction[1];
                int newDistance = distance.getOrDefault(newX * m + newY, Integer.MAX_VALUE >> 1);
                if (newDistance > distance.get(x * m + y) + count) {
                    distance.put(newX * m + newY, distance.get(x * m + y) + count);
                    queue.offer(newX * m + newY);
                }
            }
            
        }
        
        if (!distance.containsKey(destination[0] * m + destination[1])) {
            return -1;
        }
        
        return distance.get(destination[0] * m + destination[1]);
    }
    
    private boolean isVaild(int x, int y, int[][] maze) {
        if (x < 0 || x >= maze.length) {
            return false;
        }
        if (y < 0 || y >= maze[0].length) {
            return false;
        }
        return maze[x][y] != 1;
    }
}