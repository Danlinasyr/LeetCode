public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     
    
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        return dfs_dc(triangle, 0, 0, map);
    }
    
    private int dfs_dc(int[][] triangle, int x, int y, Map<Integer, Integer> map) {
        if (x == triangle.length) {
            return 0;
        }

        if (map.containsKey(x*triangle.length + y)) {
            return map.get(x * triangle.length + y);
        }
        
        int left = dfs_dc(triangle, x+1, y, map);
        int right = dfs_dc(triangle, x+1, y+1, map);
        int min = Math.min(left, right) + triangle[x][y];
        map.put(x*triangle.length + y, min);
        
        return min;
    }
}



public class Solution II {  // not working!!!
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     
    
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) return -1;
        int[][] map = new int[triangle.length][triangle[0].length];
        return dfs_dc(triangle, 0, 0, map);
    }
    
    private int dfs_dc(int[][] triangle, int x, int y, int[][] map) {
        if (x == triangle.length) {
            return 0;
        }

        if (map[x][y] != 0) {
            return map[x][y];
        }
        
        int left = dfs_dc(triangle, x+1, y, map);
        int right = dfs_dc(triangle, x+1, y+1, map);
        int min = Math.min(left, right) + triangle[x][y];
        map[x][y] = min;
        
        return min;
    }
}