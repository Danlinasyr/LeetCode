class Solution {
    /*
    1. use three variables to keep track of result, number(operand) and the sign;
    2. if sees a '(' push the result into the stack and initialize the three variables;
    3. if sees a ')' pop the result and multiply the number
    */
    public int calculate(String s) { 
        int result = 0;
        int number = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // digit
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } 
            // +/- operator
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }   
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            // left parenthesis
            else if (c == '(') {
                // save the current result
                stack.push(result);
                // there always a sign before the '('
                stack.push(sign);
                
                // initialize a new operation inside of the "()"
                result = 0;
                sign = 1;
            }
            
            // right prenthesis
            else if (c == ')') {
                // there is always a number bofore the ')'
                result += sign * number;
                number = 0;
                // sign first
                result *= stack.pop();
                result += stack.pop();                
            }
            
        }
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }
}