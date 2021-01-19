class Solution {
    // poll the cell from minheap
    // check up,down,left,right 4 diretional neighbors  (valid && not visited)
    // accumulate the water if neighbors' height < cell height
    // update neighbors' height based on new water level max (cell, neighbor)
    // offer neighbor


    // min heap    ex. int[] c = {x, y, height}
    private static final int[][] directions = new int[][] {{1, 0}, { -1, 0}, {0, -1}, {0, 1}};

    public int trapRainWater(int[][] heightMap) {


        int m = heightMap.length;
        int n = heightMap[0].length;


        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> (c1[2] - c2[2]));
        Set<Integer> visited = new HashSet<>();
        // initially store cells on the boundary
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {i, 0, heightMap[i][0]});
            pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
            visited.add(i * n + 0);
            visited.add(i * n + n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[] {0, j, heightMap[0][j]});
            pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
            visited.add(0 * n + j);
            visited.add((m - 1) * n + j);
        }
        int volume = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int h = cell[2];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited.contains(nx * n + ny)) {
                    continue;
                }

                // System.out.println(diff);
                volume += Math.max(0, h - heightMap[nx][ny]);
                int nh = Math.max(h, heightMap[nx][ny]);

                pq.offer(new int[] {nx, ny, nh});
                visited.add(nx * n + ny);


            }


        }

        return volume;

    }
    class Solution {
        // poll the cell from minheap
        // check up,down,left,right 4 diretional neighbors  (valid && not visited)
        // accumulate the water if neighbors' height < cell height
        // update neighbors' height based on new water level max (cell, neighbor)
        // offer neighbor


        // min heap    ex. int[] c = {x, y, height}
        private static final int[][] directions = new int[][] {{1, 0}, { -1, 0}, {0, -1}, {0, 1}};

        public int trapRainWater(int[][] heightMap) {


            int m = heightMap.length;
            int n = heightMap[0].length;


            PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> (c1[2] - c2[2]));
            Set<Integer> visited = new HashSet<>();
            // initially store cells on the boundary
            for (int i = 0; i < m; i++) {
                pq.offer(new int[] {i, 0, heightMap[i][0]});
                pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
                visited.add(i * n + 0);
                visited.add(i * n + n - 1);
            }

            for (int j = 1; j < n - 1; j++) {
                pq.offer(new int[] {0, j, heightMap[0][j]});
                pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
                visited.add(0 * n + j);
                visited.add((m - 1) * n + j);
            }
            int volume = 0;
            while (!pq.isEmpty()) {
                int[] cell = pq.poll();
                int x = cell[0];
                int y = cell[1];
                int h = cell[2];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited.contains(nx * n + ny)) {
                        continue;
                    }

                    // System.out.println(diff);
                    volume += Math.max(0, h - heightMap[nx][ny]);
                    int nh = Math.max(h, heightMap[nx][ny]);

                    pq.offer(new int[] {nx, ny, nh});
                    visited.add(nx * n + ny);


                }


            }

            return volume;

        }
    }