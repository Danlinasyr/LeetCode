class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n * n;
        Queue<Integer> queue = new ArrayDeque<>();
<<<<<<< HEAD
        int[] visited = new int[n*n + 1];
=======
        int[] visited = new int[n * n + 1];
>>>>>>> 8e296013bed7831c3c5eaa057823da0b6387dd95
        queue.offer(1);
        visited[1] = 1;
        int moves = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int square = queue.poll();
                if (square == dest) {
                    return moves;
                }

                for (int j = 1; j < 7 && square + j <= n * n; j++) {
                    int s = square + j;
                    int div = (s - 1) / n;
                    int rem = (s - 1) % n;
                    int r = (n - 1) - div;   //5 - (25 - 1) / 6 = 1;
                    int c = div % 2 == 1 ? n - 1 - rem : rem;   //(25 - 1) % 6 = 0
<<<<<<< HEAD
                    
                    if (board[r][c] != -1) {
                        visited[s] = 1;
                        s = board[r][c];
                    }
                    
                    if (visited[s] == 0) {
                        queue.offer(s);
                        visited[s] = 1;
                    } 
                    
=======

                    if (board[r][c] != -1) {
                        s = board[r][c];
                    }

                    if (visited[s] == 0) {
                        queue.offer(s);
                        visited[s] = 1;
                    }

>>>>>>> 8e296013bed7831c3c5eaa057823da0b6387dd95
                }
            }
            moves++;
        }
        return -1;
    }
}