public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */

    private static final int[][] directions = new int[][] { {0,-1}, {0, 1}, {-1, 0}, {1, 0}};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.size() == 0) {
        	return res;
        }

        Set<String> dict = new HashSet<>();
        for (String word : words) {
        	dict.add(word);
        }	
        int[][] visited = new int[board.length][board[0].length];

		dfs(board, "", 0, 0, dict, visited, res);
        
        return res;

    }

 
    private void dfs(char[][] board, 
    				 String comb, 
    				 int x, int y, 
    				 Set<String> dict, 
    				 int[][] visited,
    				 List<String> res) {

    	if (dict.contains(comb)) {
    		res.add(comb);
    		return;
    	}

    	// stop condition???


    	for (int[] direction : directions) {
    		int nx = x + direction[0];
    		int ny = y + direction[1];
    		if (!isValidMove(nx, ny, visited)) {
    			continue;
    		}
    		visited[nx][ny] = 1;
    		dfs(board, comb+board[nx][ny], nx, ny, dict, visited, res);
    		visited[nx][ny] = 0;
    	}

    }

    private boolean isValidMove(int x, int y, int[][] visited) {
    	if (x < 0 || x >= visited.length) {
    		return false;
    	}

    	if (y < 0 || y >= visited[0].length) {
    		return false;
    	}

    	if (visited[x][y] == 1) {
    		return false;
    	}

    	return true;
    }
}