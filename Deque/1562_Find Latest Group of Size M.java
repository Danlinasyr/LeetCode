class Solution {
    public int findLatestStep(int[] arr, int m) {
        /*
        algorithm:
        1. create a preprocess array days[i] to record the turning day of the each index i of the binary string; 
        2. scan through the binary string with a sliding window size of m;
        3. for each sliding window find the max/latest day[x], then check if the left/right neighbors 
        day[i-1] and day[j+1] of the sliding window are larger/later than day[x]
        4. record the min(day[i-1], day[j-1]) - 1 of each valid sliding window
        5. return max of the record
        * use sliding window with deque (mono quue) technique to keep a the dynamic max of the sliding window
        */
        int n = arr.length;
        if (n == m) {
            return n;
        }
        int[] day = new int[n];  // day range from 0 to n-1
        for (int i = 0; i < n; i++) {
            day[arr[i] - 1] = i;
        }
        Deque<Integer> deq = new ArrayDeque<>();
        int latest = -1;
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.peek() + m <= i) {
                deq.poll();  
            }
            while (!deq.isEmpty() && day[deq.peekLast()] < day[i]) {
                deq.pollLast();
            }
            
            deq.offer(i);
            int t = day[deq.peek()];
            
            if (i < m - 1) {
                continue;
            }           
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if (i - m >= 0) {
                left = day[i-m];
            }
            if (i + 1 < n) {
                right = day[i+1];
            }
            
            if (left > t && right > t) {
                latest = Math.max(latest, Math.min(left, right));
            }   
        }
        return latest;
    }
}




// Input: arr = [3,5,1,2,4], m = 1
// Output: 4
// Explanation

// Step 1: "00100", groups: ["1"]
// Step 2: "00101", groups: ["1", "1"]
// Step 3: "10101", groups: ["1", "1", "1"]
// Step 4: "11101", groups: ["111", "1"]
// Step 5: "11111", groups: ["11111"]
// The latest step at which there exists a group of size 1 is step 4.

// arr[i] = at day i, the 0 at arr[i] index of the binary string will be turn to 1
// day[j] = the 0 at the j index of the binary string will turn to 1 at the day[j]
    
    
    
// Observation : 
// 1. The index of the array is the step or we can call it the sequence when certain position of the binary string turn from 0 to 1;
// 2. The continous m of ones in binary string is formed when last of these coninous ones turn from 0 to 1, also we this continous ones has to been surround by 0; (so the left or right of the ones did not turn from 0 to 1 yet)

// 01100[111]00
//      |   |
//      i   j
     
// 3. search within the sliding window with size of m (from i to j) to find the index that has latest date turning from 0 to 1;

// 01100[111]00
//     |     |
//    i-1   j+1

// 4. check if the day[i - 1] and day[j + 1] both has date of turning from 0 to 1 that is later than day[x]
// 5. then find the min of the day[i-1] and day[j+1]