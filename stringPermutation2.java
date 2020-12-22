public class Solution {

	// aabb

	public List<String> stringPermutation2(String str) {
		List<String> output = new ArrayList<>();
		if (str == null || str.length) return 

		boolean[] visited = boolean[str.length];
		dfs(str, 0, visited, output);
	}

	private void dfs(String str, StringBuilder sb, boolean[] visited, List<String> output) {
		if (str.length() == sb.length()) {
			output.add(sb.toString());
		}

		for (int i = 0; i < str.length; i++) {

			if (i > 0 && str.charAt(i) == str.charAt(i-1) && visited[i-1] == 0) {
				continue;
			}

			sb.append(str.charAt(i));
			dfs(str, sb, visited, output);
			sb.deleteCharAt(i);
		}
	}
}