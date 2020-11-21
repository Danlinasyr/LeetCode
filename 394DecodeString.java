class Solution {
    
    /*
    Use Stack: O(n)  space O(n)
    1. push all element onto stack until met a ']'   
    2. pop()  until first '['  -> repeat string
    3. pop()  until next on the stack a not a number -> repeat count
    
    
    "2[1[abc]3[cd]]ef"
    */
    
    public String decodeString(String s) {
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                int count = 0;
                int k = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count += k * (stack.pop() - '0');
                    k *= 10;
                }
                while (count > 0) {
                    for (int i = sb.length() - 1; i >= 0; i--) {
                        stack.push(sb.charAt(i));
                    }
                    count--;
                }
            }
        }
        
        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return new String(result);
    }
}