class Solution {
    public int calculate(String s) {
        if (s.length() == 1) return s.charAt(0) - '0';
        
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char operator = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                number = number * 10 + (c - '0');
            }
            
            // 1 + 2
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (operator == '+') {
                    stack.push(number);
                } else if (operator == '-') {
                    stack.push(-number);
                } else if (operator == '*') {
                    stack.push(stack.pop() * number);
                } else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                operator = c;
                number = 0;
            }
        }
        
        return stack.stream().mapToInt(x -> x).sum();
    }
}