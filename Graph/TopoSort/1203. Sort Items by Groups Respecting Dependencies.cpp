class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int> & group, vector<vector<int>> & beforeItems) {
        unordered_map<int, unordered_set<int>> groupItems;
        int groupId = m;

        for (int i = 0; i < n; i++) {
            if (group[i] == - 1) {
                group[i] = groupId;
                groupId++;
            }

            groupItems[group[i]].insert(i);
        }

        // build graph inside of each group
        unordered_map<int, unordered_set<int>> graph;
        unordered_map<int, int> indegree;

        for (int i = 0; i < n; i++) {
            for (int item : beforeItems[i]) {

                if (group[i] != group[item]) {
                    continue;
                }
                if (graph[item].find(i) == graph[item].end()) {
                    graph[item].insert(i);
                    indegree[i]++;
                }
            }
        }

        // sort items of each group

        unordered_map<int, vector<int>> groupItemsSorted;
        for (auto x : groupItems) {
            int groupId = x.first;
            groupItemsSorted[groupId] = topoSort(groupItems[groupId], graph, indegree);
            if (groupItemsSorted[groupId].size() != groupItems[groupId].size()) {
                return {};
            }
        }

        // build graph among groups
        graph.clear();
        indegree.clear();
        for (int i = 0; i < n; i++) {
            for (int item : beforeItems[i]) {

                if (group[i] == group[item]) {
                    continue;
                }
                if (graph[group[item]].find(group[i]) == graph[group[item]].end()) {
                    graph[group[item]].insert(group[i]);
                    indegree[group[i]]++;
                }
            }

        }

        // sort groups
        unordered_set<int> groups;
        for (int i = 0; i < n; i++) {
            groups.insert(group[i]);
        }

        vector<int> groupIdSorted = topoSort(groups, graph, indegree);

        vector<int> ret;
        for (int groupId : groupIdSorted) {
            for (auto item : groupItemsSorted[groupId]) {
                ret.push_back(item);
            }
        }

        return ret;

    }

    vector<int> topoSort(unordered_set<int> & nodes, unordered_map<int, unordered_set<int>> & graph, unordered_map<int, int> & indegree) {
        queue<int> q;
        vector<int> ret;

        for (auto node : nodes) {
            if (indegree[node] == 0) {
                q.push(node);
            }
        }

        while (!q.empty()) {
            int currNode = q.front();
            q.pop();
            ret.push_back(currNode);

            for (auto next : graph[currNode]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.push(next);
                }
            }
        }

        if (ret.size() == nodes.size()) {
            return ret;
        }

        return {};
    }
};