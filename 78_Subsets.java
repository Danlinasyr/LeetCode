
// Algo: bit masking

// bitmask      combination
// 000 => 0     []
// 001 => 1     [1]
// 010 => 2     [2]
// 011 => 3     [1,2]   
// 100 => 4     [3]
// 101 => 5     [1,3]
// 110 => 6     [2,3]
// 111 => 7     [1, 2, 3]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // << shift left   1 << n means, 2^n
        for (int i = 0; i < (1<<n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}

// Algo: BFS
class Solution {
    
            //                 []
            //     [1],       [2]       [3]
            //    [1,2][1,3] [2,3] 
            // [1,2,3]
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);
        
        // BFS 
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<Integer>());
        
        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            // System.out.println(subset);
            // System.out.println();
            results.add(subset);
            
            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new ArrayList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }
        
        return results;
    }
}

// Algo BFS, like above method but implemented Queue differently

class Solution {
    
            //                 []
            //     [1],       [2]       [3]
            //    [1,2][1,3] [2,3] 
            // [1,2,3]
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);
        
        // BFS 
        List<List<Integer>> queue = new ArrayList<>();          // use ArrayList + a index to replace queue
        int index = 0;
        queue.add(new ArrayList<Integer>());        
        while (index < queue.size()) {  // thus index is not beyond the size of the queue.
            List<Integer> subset = queue.get(index++);
            // System.out.println(subset);
            // System.out.println();
            results.add(subset);
            
            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new ArrayList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.add(nextSubset);
                }
            }
        }
        
        return results;
    }
}

// Algo BFS, a different BFS search tree, the subsets are the leaf nodes (total nodes : 2^n+1 - 1) (Note this is a Binary Tree)

   //               []
   //      []             [1]
   //  []    [2]      [1]    [1 2]
   // [][3] [2][23] [1][1 2] [1 2] [1 2 3]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);

        List<List<Integer>> queue = new ArrayList<>();
        queue.add(new ArrayList<Integer>());

        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<Integer>(queue.get(i));
                subset.add(num);
                queue.add(subset);
            }
        }

        return queue;
    }
}