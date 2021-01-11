class Solution {
	public int createSortedArray(int[] instructions) {
		int n = instructions.length;
		if (n == 1) {
			return 0;
		}
		int[] res = new int[n];
		res[0] = instructions[0];
		int total = 0;
		for (int i = 1; i < n; i++) {
			int l = binarySearch_upper(res, i, instructions[i]);  // is the upper bound element index < target
			int r = binarySerach_lower(res, i, instructions[i]);  // is the lower bound elmenet index > target
			int less, bigger;
			if (l == -1) {
				less = 0;
			} else {
				less = l + 1;
			}

			if (r == -1) {
				bigger = 0;
			} else {
				bigger = i - r + 1;
			}

			if (bigger == 0 && less == 0) {
				res[i] = instructions[i];
			} else if (bigger == 0) {
				res[l + 1] = instructions[i];
			} else {
				res[r - 1] = instructions[i];
			}

			System.out.println("l: " + l  + " r: " + r + " res[i]: " + res[i]);
			total += Math.min(less, bigger);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
		return total;
	}

	private int binarySearch_upper(int[] res, int end, int target) { //[1,5,6] target = 2;
		int l = 0;
		int r = end;

		while (l + 1 < r) {
			int m = l + (r - l) / 2;
			if (res[m] < target) {
				l = m;
			} else {
				r = m;
			}
		}

		if (res[r] < target) {
			return r;
		}

		if (res[l] < target) {
			return l;
		}

		return -1;
	}

	private int binarySerach_lower(int[] res, int end, int target) {
		int l = 0;
		int r = end;

		while (l + 1 < r) {
			int m = l + (r - l) / 2;
			if (res[m] > target) {
				r = m;
			} else {
				l = m;
			}
		}

		if (res[l] > target) {
			return l;
		}

		if (res[r] > target) {
			return r;
		}

		return -1;
	}
}