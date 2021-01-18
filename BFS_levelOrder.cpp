BFS_LevelOrder(TreeNode * root) {
	queue<TreeNode*> q;
	q.push(root);
	std::vector<T> v;
	while (!q.empty()) {
		int sz = q.size();
		for (int i = 0; i < sz; i++) {
			TreeNode* node = q.front();
			v.push_back(node->data);
			q.pop();
			for (TreeNode* childPtr : node->childenPtrs) {
				if (childPtr != nullptr) {
					q.push(childPtr);
				}
			}
		}
	}

	return v;

}
