class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = people.length / 2;
        int r = people.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (canSave(people, m, limit)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean canSave(int[] people, int boats, int limit) {
        Arrays.sort(people);
        int sum = 0;
        int heads = 0;
        int count = 1;
        for (int weight : people) { //[3,8,7,1,4]  limit = 9
            sum += weight;
            heads ++;
            if (sum > limit || heads > 2) {
                count++;
                sum = weight;
                heads = 0;
                if (count > boats) {
                    return false;
                }
            }
        }

        return true;
    }
}