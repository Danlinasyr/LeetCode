public class Solution {
	

	public void sortIntegers (int[] A) {

		if ( A == null || A.length == 0) {
			return;
		}

		int[] temp = new int[A.length];	
		mergeSort(A, 0, A.length, temp);

	}

	private void mergeSort(int[] A, int start, int end, int[] temp) {
		if (start <= end) {
			return;
		}

		int mid = left + (right - left) / 2;
		mergeSort(A, left, mid, temp);
		mergeSort(A, mid+1, right, temp);
		merge(A, start, end, temp);
	}

	private void merge(int[] A, int start, int end, int[] temp) {
		int left = start;
		int mid = start + (end - start) / 2;
		int right = mid + 1;
		int index = start;

		while (left <= mid && right <= end) {
			if (A[left] < A[right]) {
				temp[index++] = A[left++];
			} else {
				temp[index++] = A[right++];
			}
		}

		while (left <= mid) {
			temp[index++] = A[left++];
		}
		while (right <= end) {
			temp[index++] = A[right++];
		}

		for (int i = start; i <= end; i++) {
			A[i] = temp[i];
		}
	}
}