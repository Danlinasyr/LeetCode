class Solution {
    public String removeDuplicates(String s, int k) {
        /*
        s = "deeedbbcccbdaa", k = 3
        
        
        ArrayDeque<Character> stack: last adjcent character   [p, b, b, c]
        HashMap <Character, Repeat> dup : how many LAC has repeated
        
        
        for(char c : s.toCharArray()) 
            if(stack.isEmpty() || c != stack.peek()){
                stack.add(c);
            }
            
        
            if (!stack.isEmpty() && c == stack.peek());
        
                if dup.get(c) >= k - 1 :
                    stack.pop();
                    dup.put(c, 0);
                else:
                    dup.put(c, dup.get(c)+1);
                    
                    
       
        */
        
        Deque<Character> stack = new ArrayDeque<>(); // d
        Map<Character, Integer> dup = new HashMap<>(); //[{e:0}, {d:1}]
        
        // Scan through the string
        for(char c : s.toCharArray()){ // d, e, e, e
            
            if(stack.isEmpty() || c != stack.peek()){
                stack.add(c);
                dup.put(c, 1); // carefully exam later
            }
            
        
            if (!stack.isEmpty() && c == stack.peek()){
                
        
                if (dup.get(c) >= k - 1) {
                    stack.pop();
                    dup.put(c, 0);
                    
                }else{
                    dup.put(c, dup.get(c)+1);
                }     
            }
        }
        
        return stack.toString();
              
        
    }
}