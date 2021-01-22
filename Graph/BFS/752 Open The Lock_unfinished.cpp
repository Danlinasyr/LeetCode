class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        if (target.compare("0000") == 0) {
            return 0;
        }

        unordered_map<string, int> turns;
        unordered_set<string> dead;
        for (string & d : deadends) {
            dead.insert(d);
        }
        queue<string> q;
        q.push("0000");
        turns.insert(("0000", 0))


        while (!q.empty()) {
            string l = q.front();
            q.pop();

            for (int i = 0; i < 4; i++) {
                int num = l[i] - '0';

            }
        }

        0000
        0001 0009  0010 0090 0100 0900 1000 9000

    }
};