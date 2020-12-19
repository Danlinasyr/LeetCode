class Solution {
    
    /*
    {{{a},{b}}{c}{{d},{e}}{f}}
    
    */
    
    public String[] expand(String S) {

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                sb.append('{');
                sb.append(c);
                sb.append('}');
            } else {
                sb.append(c);
            }
        }
        sb.append('}');   // verify test case :  S = "a"
        String s = sb.toString();
        
        Stack<Integer> stackOp = new Stack<>();  //
        Stack<List<String>> stackStr = new Stack<List<String>>();
        List<String> curr = new ArrayList<String>();
        
        for (int i = 0; i < s.length(); i++) {  //    {{{a},{b}}{c}{{d},{e}}{f}}
            char c = s.charAt(i);
            if (c == '{') {
                stackOp.push(0);
                stackStr.push(curr);
                curr = new ArrayList<String>();
            }
            
            else if (c == ',') {
                stackOp.push(1);
                stackStr.push(curr);
                curr = new ArrayList<String>();
            }
            
            else if (Character.isLetter(c)) {
                StringBuilder str = new StringBuilder();
                str.append(c);
                curr.add(str.toString());
            }
            
            else if (c == '}') {
                
                while (stackOp.peek() == 1) {
                    curr = combine(stackStr.peek(), curr);
                    stackStr.pop();
                    stackOp.pop();
                }
                if (stackOp.peek() == 0) {
                    curr = crossProduct(stackStr.peek(), curr);
                    stackStr.pop();
                    stackOp.pop();
                }
            }

        }
        Collections.sort(curr);
        return curr.toArray(new String[curr.size()]);
        
    }

    private List<String> combine(List<String> l1, List<String> l2) {
        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < l1.size(); i++) {
            ret.add(l1.get(i));
        }

        for (int i = 0; i < l2.size(); i++) {
            ret.add(l2.get(i));
        }

        return ret;
    }

    private List<String> crossProduct(List<String> l1, List<String> l2) {
        List<String> ret = new ArrayList<String>();
        if (l1.size() == 0) {
            l1.add("");
        }
        if (l2.size() == 0) {
            l2.add("");
        }
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                ret.add(l1.get(i) + l2.get(j));
            }
        }

        return ret;
    }
}



