class Solution {
    
    /*
                                                1229
                                432219   132219   143219   143229    143221
                                32219   12219   13219   13229   13221
                                2219    1219    1229    1221
                                
                                
                                10200
                                200 1200 1000 1020
                                
                                1204909  3
                                204909 104909 124909 120909 120409 120499 120490
                                4909    14909 10909 10409 10499 10490
                               909 409 499 490
                               
                               
     1. remove a digit each round/loop  -> new num
     2. find the remaining min of all new nums
     
     String removeDigit (String num, int k)
     k = 0 return 
     
     k--
     
     // 1204909
     int min = Integer.parseInt(num);
     String minStr = num;
     for (int i = 0; i < num.length; i++) {
        String newStr = num.substring(0, i) + num.substring(i+1)
        if (Integer.parseInt(newStr) < min) {
            min = Integer.parseInt(newStr);
            minStr = newStr;
        }
     }

     
     XXXXOOO
     
    */
    public String removeKdigits(String num, int k) { 
        
        if (num == null || num.length() == 0) return "0";
        if (num.length() == k) return "0";
        
        LinkedList<Character> stack = new LinkedList<>();
        
        //[1001001]  k = 1
        
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > ch) { // top <= ch not execute
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);    
        }
        
        // if k > 0 and there left with mono stack
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }
        
        while(stack.size() > 1 && stack.peekFirst() == '0') {
            stack.removeFirst();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        //0100
        
        // ***have to remove leading zero before return result
        // System.out.println(sb.toString());
        // for (int i = sb.length() - 1; i >= 0; i--) {
        //     if (sb.charAt(i) != 0) {
        //         break;
        //     }
        //     sb.deleteCharAt(i);
        // }
        
        return sb.toString();
    }
    
}