class Solution {
    public int findTheLongestSubstring(String s) {
        int max_len = 0;
        // HahsTable is <key = binary key represent the state of five vowels (even or odd) : value = index of the string
        Map<Integer, Integer> map = new HashMap<>();  
        map.put(0, -1);
        int[] count = new int[5];
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == 'a') {
                count[0]++;
            } else if (c == 'e') {
                count[1]++;
            } else if (c == 'i') {
                count[2]++;
            } else if (c == 'u') {
                count[3]++;
            } else if (c == 'o') {
                count[4]++;
            }
            
            int key = count2key(count);
            if (map.containsKey(key)) {
                max_len = Math.max(max_len, j - map.get(key));
            } else {
                map.put(key, j);
            }
        }
        return max_len;
    }

    private int count2key(int[] count) {
        int key = 0;
        for (int i = 0; i < 5; i++) {
            if (count[i] % 2 == 1) {
                key += (1 << i);
            }
        }
        return key;
    }
    
}

// X X X [X X X] X X
//         valid
// ^          ^
//            |
//            j
// a

// even = valid

// prefix[i] =  [0, i-1] 
// prefix[j] = [0, j-1]  -> even

// [i, j] = even - even = odd - odd = even

// prefix[j+1] - prefix[i] = []
// [0, j]  - [0, i-1] = [i, j]