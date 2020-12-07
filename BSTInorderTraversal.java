public class Soluction {


	// comparing the line 22 and 29, we can observe that if there is no right substree from node, we pop, 
	// further more if the next element the stack's right subtree is the node, we continue pop

	// iterative method for inorder traversal
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> res = new ArrayList<>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			// add stack top to result;
			TreeNode node = stack.peek();
			res.add(node.val);

			// if the stack top right subtree is empty
			if (node.right == null) {
				node = stack.pop();
				// current popped node is the stack top right subtree, keep popping!!!
				// until find a node in stack top that has left subtree relation with the node
				while (!stack.isEmpty() && stack.peek().right == node) {
					node = stack.pop();
				}
			} else {
				node = node.right;
				// add all the left tree node
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}

		return res;
	}
}