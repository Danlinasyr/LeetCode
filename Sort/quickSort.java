
public class Solution {
	

	public void sortIntegers (int[] A) {

		if ( A == null || A.length == 0) {
			return;
		}

		quickSort(A, 0, A.length - 1);
	}

	private void quickSort(int[] A, int start, int end) {
		if (start >= end) {  // start == end means there is only one number, doesn't need to sort anymore
			return;
		}

		int left = start;
		int right = end;

		// 1. pivot should not be A[start] or A[end]
		int pivot = A [left + (right - left) / 2];  // or use Java.Random
		while (left <= right) {  // why left <=  right instead of left < right ???  to make we deal with the number on the index (when left == right, which can be only go to either left side or right side)
			// for example if we write left < right 
			// and we excute for the following case
			// 3 2 1 4 5    pivot = 1
			// l       r	
			// 3 2 1 4 5    pivot = 1
			// l   r	
			// 1 2 3 4 5    pivot = 1
			//   l	
			//   r			l == r break the while loop 
			// recuisive call: quicksort([1, 2]) + quicsort([2,3,4,5])  notes: there is also intersection between two intervals
			// in [1, 2]  pivot = 1 ->  quicksort([1, 2]) again and again  == > stack overflow
			//     l
			//     r		
			while (left <= right && A[left] < pivot) {// this has to be A[left] < pivot NOT <=
				left++;
			}

			while (left <= right && A[right] > pivot) {  // this has to be A[right] > pivot NOT >=
				right--;
			}

			if (left <= right) {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				left++;
				right--;
			}
		}

		quickSort (A, start, right); // when out of while loop left > right meaning left and right have been switched
		quickSort (A, left, end);
	}
}