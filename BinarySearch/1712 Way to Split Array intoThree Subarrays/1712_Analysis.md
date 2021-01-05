# [Ways to Split Array Into Three Subarrays](https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/)
1. What is the algorithm for this problem? 
   Binary Search / Sliding Window + Binary Search
2. How to analyze the problem to narrow down to this algorithm?
   One way to narrow down this algorithm is:
   a. This is a subarray problem, subarray problem usually involves with prefix sum, sliding window techniques etc
   b. Based the "good way" that the problem has defined, a valid partiation of array would required prefix sum to be non-decreasing.
   c. If we look at the prefix sum arrays, it is actually a sorted array which implies binary search.
   Another clue occurs after we check the condition and translate them to prefix sum that: 
   1. sum[0 : i] <= sum[i+1 : j];  
   		-----> preSum[i] <= preSum[j] - preSum[i];  
   		-----> 2* preSum[i] <= preSum[j] 
   2. sum[i+1, k] <= sum[k+1 : n-1]   (where j <= k)     
   		-----> preSum[k] <= (preSum[n-1] + preSum[i])/ 2

3. What else algorithm are there to solve this problem?

4. What’s comparison among different algorithms?

5. What’s the time and space complexity? 
	TC: O(n * logn)
	SC: O(1)

6. **Important Notes About Find Lower Bound and Upper Bound using Binary Search**
	When look for a **last** element in the array that is less and equal than target : 

	`private int binarySearch_UpperBound(long[] arr, int start, int end, double target) {
        int left = start;
        int right= end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] <= target) {
            return right;
        }
        if (arr[left] <= target) {
            return left;
        }
        return -1;
    }`

    When look for a **first** element in the array that is greater and equal than target :
    `    private int binarySearch_LowerBound(long[] arr, int start, int end, double target) {
        int left = start;
        int right= end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (arr[left] >= target) {
            return left;
        }
        if (arr[right] >= target) {
            return right;
        }
        return end;
    }`

