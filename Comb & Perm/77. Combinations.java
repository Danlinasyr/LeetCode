class Solution {

    /*
    example: n = 5, k = 3

                                <1,2,3,4,5> k =3
     k =2           1           2            3             4            5
               2    3   4   5   1 3 4 5       1 2 4 5        1 2 3 5    1 2 3  4
            3 4 5  245  235 234
    Set<Integer> nums, manage n numbers

    base case: k == 0 --> 2Dlist.add(combList)
    recurrence: for each num in nums
                    add num to combList;
                    remove num from the nums set
                    call combine(k--)
                    remove num from combList
                    add num back to the nums
    */

    List<List<Integer>> res;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) return null;
        this.k = k;
        res = new ArrayList<>();
        combine(1, n - k + 1, new LinkedList<Integer>());
        return res;
    }

    public void combine(int start, int end, LinkedList<Integer> combList) {
        if (combList.size() == k) {
            res.add(new LinkedList<Integer> (combList));
            return;
        }
        for (int i = start; i <= end; ++i) {
            combList.add(i);
            combine(i + 1, end + 1, combList);
            combList.removeLast();
        }
    }
}