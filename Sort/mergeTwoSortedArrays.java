public class Solution {
	public int[] mergeTwoSortedArray(int[] A, int[] B) {
		int i = 0, j = 0, k = 0;
		int[] ans = new int[A.length + B.length];
		int k = 0;

		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				ans[k++] = A[i++];
			} else {
				ans[k++] = B[j++];
			}
		}

		while (i < A.length) {
			ans[k++] = A[i++];
		}

		while (j < B.length) {
			ans[k++] = B[j++];
		}

		return ans;
	}
}