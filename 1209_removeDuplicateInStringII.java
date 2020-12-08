class Solution {
    /*
    
    ex: acbc;  k=2
    loop through the string s : 

        1. check if stack is emptycheck the top stack char's counter == k
            if yes, then we pop k times;
        2. check if top stack char equals new character, if yes :  push <char,counter+1> onto stack
                                                            no: push <char, 1> onto stack
            
    */
    
    class Pair {
        char ch;
        int counter;
        public Pair(char ch, int counter) {
            this.ch = ch;
            this.counter = counter;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 1) return "";
        
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {  //"deeedbbcccbdaa"

            
            int counter = 1;
            if (!stack.isEmpty() && stack.peek().ch == s.charAt(i)) {
                counter = stack.peek().counter + 1;
            }
            
            stack.push(new Pair(s.charAt(i), counter));
            
            
            if (!stack.isEmpty() && stack.peek().counter == k) {
                int j = 0;
                while (j < k) {
                    stack.pop();
                    j++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }
        
        return sb.reverse().toString();
        
              
        
    }
}