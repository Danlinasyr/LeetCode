class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] output = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for (String log : logs) {
            String[] s = log.split(":");
            int id = Integer.parseInt(s[0]);
            int timestamp = Integer.parseInt(s[2]);

            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    output[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp; 
                }
                
                stack.push(new int[] {id, timestamp});
            } else { // “end”
                int start = stack.pop()[1];
                output[id] += timestamp - start + 1;
                
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1; 
                }
                
            }
        }
        
        return output;
        
    }
}