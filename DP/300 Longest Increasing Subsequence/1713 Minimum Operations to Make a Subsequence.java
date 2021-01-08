class Solution {
    public int minOperations(int[] target, int[] arr) {
        int k = target.length;
        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < k; i++) {
            num2Index.put(target[i], i);
        }
        
        List<Integer> queue = new ArrayList<>();
        for (int num : arr) {
            if (!num2Index.containsKey(num)) {
                continue;
            }
            
            int index = num2Index.get(num);
            int pos = binarySearch(queue, index);
            if (pos == queue.size()) {
                queue.add(index);
            }
            queue.set(pos, index);
        }
        
        return k - queue.size();
    }
    
    
    private int binarySearch (List<Integer> queue, int target) {
        if (queue.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = queue.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (queue.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (queue.get(left) >= target) {
            return left;
        } 

        if (queue.get(right) >= target) {
            return right;
        }

        return queue.size();
    }
}

// ----------------------------------------- first transformation
// [X,X,X]
// [O,X,*,O,X,O]
//      ^
//      |   
//     insertion
    
// LCS + MO = target.size()
         
// -----------------------------------------  second transformation
// LCS (longest common subsequence) ==> LIS (longest increasing subsequence)
    
// idx_t:    0 1 2 3 
// target:   5 2 4 3 
// arr:      1 6 5 2 3 4    
// idx_t:        0 1 3 2



    public int minOperations(int[] target, int[] A) {
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < target.length; ++i)
            h.put(target[i], i);

        ArrayList<Integer> stack = new ArrayList<>();
        for (int a : A) {
            if (!h.containsKey(a)) continue;
            if (stack.size() == 0 || h.get(a) > stack.get(stack.size() - 1)) {
                stack.add(h.get(a));
                continue;
            }
            int left = 0, right = stack.size() - 1, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (stack.get(mid) < h.get(a))
                    left = mid + 1;
                else
                    right = mid;
            }
            stack.set(left, h.get(a));
        }
        return target.length - stack.size();
    }