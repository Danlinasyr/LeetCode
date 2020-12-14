class Solution {

    /* 
    [5,3,1,4,2]  Alice:       2            [5,3,1,4]                 min
    
    [5,3,1,4]    Bob          5            [3,1,4]                  5 - 4 < 3 - 2               [100, 3, 1, 4] 
    
    [3,1,4]      Alice        3            [1, 4]
    
    [1,4]        Bob          1            [4]
    
    [4]          Alice
    
    */
    
    
    /*
    [7,90,5,1,100,10,10,2]   Alice: 2  right        [7,90,5,1,100,10,10]     7
    
    [7, 90,5,1,100,10,10]    Bob:   7  left         [90,5,1,100,10,10]     
    
    [90,5,1,100,10,10]      Alice: 10  right         [90,5,1,100,10]          10
    
    [90,5,1,100,10]         Bob: 10    right         [90,5,1,100]           
    
    [90,5,1,100]            Alice: 90  left         [5,1,100]               5
    
    [5,1,100]               Bob : 5    left         [1,100]                 
    
    [1, 100]                Alice:  1   left        [100]                   100
    
    [100]                     Bob: 100
    
    */
    
    private int sum;
    public int stoneGameVII(int[] stones) {
        
       //  if (size <= 3) pick left if left < right
        sum = 0;
        decision(stones, 0, stones.length, true)
    }
    
    
    private void decision(int[] stones, int left, int right, boolean flag) {
        
        if (left == right) {
            return;
        }
        
        if (flag == true) {
            if (stones[left] < stones[right]) {
                sum += stones[left++];
            } else{
                sum += stones[right--];
            }
            
            flag = !flag;
            decision(stones, left, right, flag);
        } else {
            
        }
        
    }
    
    
    
}





















    
    /*
    
    Input: stones = [5,3,1,4,2]
    Output: 6
    Explanation: 
    - Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].   
    - Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].     Bob = 9 Alice = 13               [531]
    - Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].         Alice = 26 Bob = 9                [5,3]
    - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].                    Bob = 14  
    - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].                     Alice = 26 Bob = 14
    The score difference is 18 - 12 = 6.

        Max & Min problem
    
    */