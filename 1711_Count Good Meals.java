class Solution {
    public int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness);
        System.out.println(deliciousness[deliciousness.length - 1]);
        int count = 0;
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (powerOf2(deliciousness[i] + deliciousness[j])) {
                    count++;
                }
            }
        }
        return (int) (count % (1e9 + 7));
    }
    
    private boolean powerOf2(int x) {
        return x!=0 && ((x&(x-1)) == 0);
    }
}



class Solution {
    public int countPairs(int[] deliciousness) {

        int count = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : deliciousness) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (int key : counter.keySet()) { // [1,1,1,3,3,3,7]
            System.out.println("key: " + key);
            if (powerOf2(key + key)) {
                int x = counter.get(key);
                count += x * (x - 1) / 2;
            }

            for (int power = 1; power < 1e7; power = power * 2) {
                if (power - key == key) {
                    continue;
                }
                // visited.add(power - key);
                // visited.add(key);
                if (counter.containsKey(power - key)) {
                    count += counter.get(key) * counter.get(power - key);
                }
            }
            System.out.println(count);
            System.out.println("-------");
        }
        return (int) (count % (1e9 + 7));
    }
    
    private boolean powerOf2(int x) {
        return x!=0 && ((x&(x-1)) == 0);
    }
}

// O(n^2)

// [1,1,1,3,3,3,5,5,7,9,9]






//         int n = deliciousness.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (powerOf2(deliciousness[i] + deliciousness[j])) {
//                     count++;
//                 }
//             }
//         }



class Solution {
    public int countPairs(int[] deliciousness) {

        long count = 0;
        int mod = 1000000007;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : deliciousness) {
            
            for (int power = 1; power < 1e7; power = power * 2) {

                if (counter.containsKey(power - num)) {
                    count += counter.get(power - num);
                    count = count % mod;
                }
            }
            counter.put(num, counter.getOrDefault(num, 0) + 1);
   
        }
        return (int) count;
    }
    

}
