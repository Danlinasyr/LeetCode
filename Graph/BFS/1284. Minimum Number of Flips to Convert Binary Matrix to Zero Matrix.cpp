class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        const int m = mat.size();
        const int n = mat[0].size();
        const vector<int> dirs{0, 1, 0, -1,  0, 0};

        auto flip = [&](int s, int x, int y) {
            for (int i = 0; i < 5; i++) {
                const int tx = x + dirs[i];
                const int ty = y + dirs[i + 1];
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }
                s ^= (1 << (ty * n + tx));
            }
            return s;
        };

        int steps = 0;
        queue<int> q;
        vector<int> seen (1 << (m * n));
        int start = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                start |= (mat[y][x] << (y * n + x));
            }
        }
        q.push(start);
        seen[start] = 1;

        while (!q.empty()) {
            int sz = q.size();
            while (sz--) {
                int s = q.front();
                if (s == 0) return steps;
                q.pop();
                for (int y = 0; y < m; y++) {
                    for (int x = 0; x < n; x++) {
                        int t = flip(s, x, y);
                        if (seen[t]) {
                            continue;
                        }
                        q.push(t);
                        seen[t] = 1;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
};