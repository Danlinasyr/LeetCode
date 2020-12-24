
// Bi-direction BFS. but it is only 5%
//1419 ms   70 MB 
class Solution {
    private final static int[][] directions = new int[][] {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    
    public class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minKnightMoves(int x, int y) {
        
        Queue<Position> forward_queue = new ArrayDeque<>();
        Queue<Position> backward_queue = new ArrayDeque<>();
        Set<String> forward_set = new HashSet<>();
        Set<String> backward_set = new HashSet<>();
        
        Position start = new Position(0, 0);
        Position end = new Position(x, y);
        
        if (start.equals(end)) {
            return 0;
        }
        forward_queue.offer(start);
        backward_queue.offer(end);
        forward_set.add("0,0");
        backward_set.add(x + "," + y);
        
        int distance = 0;
        
        while (!forward_queue.isEmpty() && !backward_queue.isEmpty()) {
            distance++;
            // System.out.println("?");
            if (extendQueue(forward_queue, forward_set, backward_set)) {
                return distance - 1;
            }
            distance++;
            if (extendQueue(backward_queue, backward_set, forward_set)) {
                return distance - 1;
            }
        }
        return -1;
    }
    
    private boolean extendQueue(Queue<Position> queue, Set<String> visited, Set<String> opposite_visited) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Position curPos = queue.poll();
            if (opposite_visited.contains(curPos.x + "," + curPos.y)) {
                return true;
            }
            for (int[] direction : directions) {
                int new_x = curPos.x + direction[0];
                int new_y = curPos.y + direction[1];
                if (visited.contains(new_x + "," + new_y)) {
                    continue;
                }
                queue.add(new Position(new_x, new_y));
                visited.add(new_x + "," + new_y);
            }
        }
        return false;
    }

}



/*
Runtime: 612 ms, faster than 30.09% of Java online submissions for Minimum Knight Moves.
Memory Usage: 49.3 MB, less than 36.62% of Java online submissions for Minimum Knight Moves.

*/


class Solution {
    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }
                
                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}