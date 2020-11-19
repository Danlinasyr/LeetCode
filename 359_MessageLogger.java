class Logger {
    
    String[] timeWindow;
    

    /** Initialize your data structure here. */
    public Logger() {
    timeWindow = new String[11];
    for(int i = 1; i < 11; i++){
        timeWindow[i] = "";
    }    
        
        /* 
         | foo | bar |   |   |   |  |   |   |   |   |
            1     2    3   4   5   6  7   8    9   10   11 & 10
         
        */
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        
        if(timestamp <= 10){ //1, 2, 3, 8
            for(int i = 1; i < 11; i++){
                if(timeWindow[i].equals(message)){
                    return false;
                }
            }
            timeWindow[timestamp] = message;
            return true;
        }
           
        int outdate = timestamp % 10;
        
        for(int i = 1; i < 11; i++){//10, 11
            if(i <= outdate){
                timeWindow[i] = "";
            }
            if(timeWindow[i].equals(message)){
                return false;
            }
        }
        timeWindow[outdate] = message;
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */