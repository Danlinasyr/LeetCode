class Solution {
	public void solveSudoku(char[][] board) {
		dfs(board, 0);
	}

	private boolean dfs(char[][] board, int index) {
		// base case
		if (index == 81) {
			return true;
		}

		int r = index / 9;
		int c = index % 9;
		if (board[r][c] != '.') {
			return dfs(board, index + 1);
		}

		for (char num = '1'; num <= '9'; num++) {
			if (!isValid(board, r, c, num)) {
				continue;
			}
			board[r][c] = num;
			boolean res = dfs(board, index + 1);
			if (res) {
				return true;
			}
			board[r][c] = '.';
		}

		return false;
	}

	private boolean isValid(char[][] board, int r, int c, char num) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == num) {
				return false;
			}

			if (board[i][c] == num) {
				return false;
			}

			if (board[r / 3 * 3  + i / 3][c / 3 * 3 + i % 3] == num) {
				return false;
			}
		}
		return true;
	}
}