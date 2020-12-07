class Solution {

    
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) return new int[] {};
        if (logs == null || logs.size() == 0) return new int[] {};
        
        int[] output = new int[n];
        
        
        
        /*
        "0:start:0"   [0 : 0]  
        "1:start:2"   {[1 : 2]} output[0] = 2 - 0 = 2;
        "1:end:5"     {}  
        "0:end:6"
        in each for loop :
            if it is start log, push onto stack int[] <id, start>
            if it is end log, stack.pop()  int[] <id, start>
                              output[id] = end - start; 
        
        */ 
        
        
        Stack<int[]> stack = new Stack<>();
        int interval = 0;
        for (String log : logs) {
            // some kind of method findout if start digit or digit and 
            // also what id of the function
            String[] s = log.split(":");
            int id = Integer.parseInt(s[0]);
            int timestamp = Integer.parseInt(s[2]);
            String status = s[1];
            
            if (s[1].equals("start")) {
                stack.push(new int[] {id, timestamp});  // {[0:0], [1:6], }`
                continue;
            }
            
            if (s[1].equals("end")) { // interval = 0, 4
                interval = timestamp - stack.pop()[1] + 1 - interval; //6 - 6 + 1 - 4
                output[id] = output[id] + interval;
            } 
        }
        
        
        return output;
    }
}





//  n = 3, logs = ["0:start:0","2:start:2","2:end:5","1:start:6","1:end:6","0:end:7"]
    
// id : 0   start  end
// id : 1   
    
//     |  |    | | |
//     0  2    6 7 8  
    
    
    
    
    
//     // start at time 0
// function () {
//                                     2
//     // at time 2                ------
//     function() {                    4
//         // end at time 5        
//         return                  ------
//     }                               0
                        
//     // start at time 6            ------
//     function() {
//                                     1
//         // end at time 6          -----
//         return 
//     }
//                                     1
//     // at time 7            
//     return 
// }