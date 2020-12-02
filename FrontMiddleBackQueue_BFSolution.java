class FrontMiddleBackQueue {
    
    /*
    [1, 2, 3, 4, 5]
    [1, 2, 6, 3, 4, 5]
    
    
    */
    
    int[] queue;
    int size;
    
    public FrontMiddleBackQueue() {
        queue = new int[10000];
        size = 0;
    }
    
    public void pushFront(int val) {  // [1],  size = 1
        size = size + 1;
        for (int i = 1; i < size; i++) {
            queue[i] = queue[i-1];
        }
        queue[0] = val;
    }
    
    public void pushMiddle(int val) {
        // 1, 2, 3, 4, 5       6
        // 1 3 2
  //queue: 1  3 2
    
        size = size + 1;  //4
        int start = size / 2;  // 2
        for (int i = start; i < size; i++) {
            queue[i] = queue[i - 1];  
        }
        if (size % 2 == 0) {
            queue[start - 1] = val;
        } else {
            queue[start] = val; 
        }
    }
    
    public void pushBack(int val) { 
        queue[size] = val;
        size = size + 1;
    }
    
    public int popFront() {
        int first = queue[0];
        size = size - 1;
        for (int i = 0; i <size; i++) {
            queue[i] = queue[i+1];
        }
        return first;
    }
    
    public int popMiddle() {
        size = size - 1;
        int mid = queue[size/2];
        for (int i = size/2; i < size; i++) {
            queue[i] = queue[i+1];
        }
        return mid;
    }
    
    public int popBack() { // [2]  size = 1
        size = size - 1; 
        return queue[size];
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */