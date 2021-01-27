// highlevel algo : use Djikstra to get the shortest path to any key or lock from start, while updating the state of entire grid (lock/unlock)

class Solution {
	private static final int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final int INF = Integer.MAX_VALUE;

	public int shortestPathAllKeys(String[] grid) {
		/*
		- represent all keys and locks position as nodes
		- use BFS to calculate distance between nodes
		- keep a graph structure <key: start node  val <key: dest node, distance btw>>
		- keep a queue of each node with its states and shortest distance, prioritized by its shortest distance
		- manage each node's state using bit masking
		*/
		int m = grid.length;
		int n = grid[0].length();

		Map<Character, int[]> locations = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char letter = grid[i].charAt(j);
				if (letter != '#' && letter != '.') {
					locations.put(letter, new int[] {i, j});
				}
			}
		}
		Map<Character, Map<Character, Integer>> distances = new HashMap<>();
		for (char l : locations.keySet()) {
			distances.put(l, bfsFrom(l, grid, locations.get(l)[0], locations.get(l)[1]));
		}


		int targetState = (1 << (distances.size() / 2)) - 1;  // bit masking the state
		PriorityQueue<ANode> pq = new PriorityQueue<>((a1, a2)->(a1.d - a2.d));
		Map<Node, Integer> finalDist = new HashMap();
		pq.offer(new ANode(new Node('@', 0), 0));
		finalDist.put(new Node('@', 0), 0);

		while (!pq.isEmpty()) {
			ANode aNode = pq.poll();
			char l = aNode.n.l;
			int dist = aNode.d;
			if (aNode.n.s == targetState) {
				return dist;
			}

			for (char nextl : distances.get(aNode.n.l).keySet()) {

				int s = aNode.n.s;
				if (Character.isLowerCase(nextl)) {
					s |= (1 << (nextl - 'a'));
				}
				if (Character.isUpperCase(nextl)) {
					if ((aNode.n.s & (1 << (nextl - 'A'))) == 0) {
						continue;
					}
				}

				int d = distances.get(l).get(nextl); // from one letter node to another
				if (dist + d < finalDist.getOrDefault(new Node(nextl, s), INF)) {
					finalDist.put(new Node(nextl, s), dist + d);
					pq.offer(new ANode(new Node(nextl, s), dist + d));
				}
			}
		}

		return -1;
	}

	private Map<Character, Integer> bfsFrom(char l, String[] grid, int x, int y) {
		int R = grid.length;
		int C = grid[0].length();
		Map<Character, Integer> dist = new HashMap<>();
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] seen = new int[R][C];
		queue.offer(new int[] {x, y});
		seen[x][y] = 1;
		int distance = 0;

		while (!queue.isEmpty()) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				int[] pos = queue.poll();
				int r = pos[0];
				int c = pos[1];
				if (grid[r].charAt(c) != l && grid[r].charAt(c) != '.') {
					dist.put(grid[r].charAt(c), distance);
					continue;
				}

				for (int[] dir : dirs) {
					int nr = r + dir[0];
					int nc = c + dir[1];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || grid[nr].charAt(nc) == '#' || seen[nr][nc] == 1) {
						continue;
					}
					queue.offer(new int[] {nr, nc});
					seen[nr][nc] = 1;

				}
			}
			distance++;
		}

		return dist;
	}




	class Node {
		char l;
		int s;

		public Node(char letter, int state) {

			l = letter;
			s = state;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (!(o instanceof Node)) {
				return false;
			}
			Node other = (Node) o;
			return (this.l == other.l && this.s == other.s);
		}

		@Override
		public int hashCode() {
			return 256 * s + l;
		}
	}

	class ANode {
		Node n;
		int d;

		public ANode(Node node, int distance) {
			n = node;
			d = distance;
		}
	}
}