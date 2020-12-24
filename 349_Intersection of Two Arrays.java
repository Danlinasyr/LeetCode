class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hash1 = new HashSet<>();
        for (int num : nums1) {
            hash1.add(num);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (hash1.contains(num)) {
                intersect.add(num);
            }
        }
 
        int[] res = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            res[index++] = num;
        }
        return res;
    }
}