class Solution {
    
    /*
    | (f, t)
    
    1. record operator
    2. open a stack when sees a '('
    3. push all 't' or 'false' onto stack
    4. when sees ')', pop all and accumulate result based on operator

    example: "|(&(t,f,t),!(t))"
    */
    
    class Pair {
        boolean res;
        int index;
        
        public Pair (boolean res, int index) {
            this.res = res;
            this.index = index;
        }
    }
    
    
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.charAt(0) == 't' ? true : false;
        }
        
        return helper(expression, 2, expression.charAt(0)).res;

    }
    
    private Pair helper(String expression, int start, char operator) { // "|(&(t,f,t),!(t))"
        Stack<Boolean> stack = new Stack<>();
        int i = start;
        while (i < expression.length()) {
            char c = expression.charAt(i++);
            if (c == '!' || c == '&' || c == '|') {
                Pair p = helper(expression, i+1, c);
                stack.push(p.res);
                i = p.index;
            } else if (c == 't') {
                stack.push(true);
            } else if (c == 'f') {
                stack.push(false);
            } else if (c == ')') {
                break;
            }
        }
        
        return new Pair (calculate(stack, operator), i);
    }
    
    
 
    private boolean calculate(Stack<Boolean> stack, char operator) {
        boolean res;
        if (operator == '&') {
            res = true;
            while (!stack.isEmpty()) {
                res &= stack.pop();
            }
        } else if (operator == '|') {
            res = false;
            while (!stack.isEmpty()) {
                res |= stack.pop();
            }
        } else {
            res = ! stack.pop();
        }
        
        return res;
    }
}