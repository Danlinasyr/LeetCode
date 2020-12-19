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

        Map<String, Boolean> isPrefix = getAllPrefix(words);
        int[][] visited = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (visited[i][j] != 1) {
                    visited[i][j] = 1;
                    dfs(board, "", 0, 0, isPrefix, visited, res);
                }
            }
        }

        return res;

    }

    private Map<String, Boolean> getAllPrefix(List<String> words) {
        Map<String, Boolean> map = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix = word.substring(0, i+1);
                if (!map.containsKey(prefix)) {
                    map.put(prefix, false);
                }
            }
            map.put(word, true);
        }

        return map;
    }

 
    private void dfs(char[][] board, 
    				 String comb, 
    				 int x, 
                     int y, 
    				 Map<String, Boolean> isPrefix, 
    				 int[][] visited,
    				 List<String> res) {

    	// stop condition: comb is not a prefix for any word
        if (!isPrefix.containsKey(comb)) {
            return;
        }


        if (isPrefix.get(comb)) {
    		res.add(comb);
    	}


    	for (int[] direction : directions) {
    		int nx = x + direction[0];
    		int ny = y + direction[1];
    		if (!isValidMove(nx, ny, visited)) {
    			continue;
    		}
    		visited[nx][ny] = 1;
    		dfs(board, comb+board[nx][ny], nx, ny, isPrefix, visited, res);
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