class Solution {
public:
    bool canReach(vector<int> & arr, int start) {
        queue<int> q;
        q.push(start);
        unordered_set<int> fset;
        unordered_set<int> bset;
        while (!q.empty()) {
            int index = q.front();
            q.pop();
            if (arr[index] == 0) {
                return true;
            }

            int f = index + arr[index];
            int b = index - arr[index];
            if (fset.find(f) == fset.end() && f < arr.size()) {
                q.push(f);
                fset.insert(f);
            }

            if (bset.find(b) == bset.end() && b >= 0) {
                q.push(b);
                bset.insert(b);
            }
        }

        return false;
    }
};