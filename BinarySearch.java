class Solution {
    
    /**
     * Step 1 find a closest element to x in the arr
     *          Binary Search: target = x; target distance = closest (min)
                left = 0; right = length - 1; closest = arr[length - 1] - arr[0]
                base case: left > right  
                recurrence: mid = left + (right  - left)/2; distance = arr[mid] - x;
                            if(arr[mid] = target) return mid;
                            if(arr[mid] > target && distance < closest) closest = distance; f(left, mid, x, closest);
                            if(arr[mid] < target && distance < closest) closest = distance; f(mid, right, x, closest);
                            
                            return closest element index;
                    
     
     * Step 2 compare two sides of this element (< or >) w.r.t distance to x and add to result
                left = closest - 1; right = closest + 1;
                compare (distance(left), distance(right))
                if(dis(left) <= dis(right)) addFirst(arr[left]); left--;
                if(dis(left) > dis(right)) addLast(arr[right]); right++;
                
                
                Test case 1: 1,2,3,4,5  target=3
                                 |   
                                 
                Test case 2: 1, 5 , 6 , 6,  7 ,  10   target = 4             closest = 2
                                |   |
     */                          
    
    private int closestIdx;
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        LinkedList<Integer> res = new LinkedList<>();
        
        if(len < k) return res;
        if(len == 1 && k == 1){
            res.add(arr[0]);
            return res;
        }
        

        closestIdx = binarySearch(arr, 0, len-1, x);
        
        if(closestIdx >= len) return Arrays.asList(Arrays.copyOfRange(arr, len - k, len));
        
        if(arr[closestIdx] != x) return Arrays.asList(Arrays.copyOfRange(arr, 0, k));       
        
        int left = closestIdx;
        int right = closestIdx+1;
        
        while(k > 0){
            if(left < 0 && right > len - 1) break;
            if(left < 0){
               res.addLast(arr[right]); 
                right = right + 1;
                k = k -1;
                continue; 
            } 
            if(right > len - 1){
                res.addFirst(arr[left]); 
                left = left - 1;
                k = k -1;
                continue;
            } 
            
            int distance1 = Math.abs ( arr[left] - x );
            int distance2 = Math.abs (arr[right] - x);
            if(distance1 <= distance2){
                res.addFirst(arr[left]);
                left = left - 1;
                k = k - 1;
            }else{
                res.addLast(arr[right]);
                right = right + 1;
                k = k - 1;
            }
            
        }
        
        return res;
    }
    
    private int binarySearch(int[] arr, int left, int right, int target){
        if(left > right) return left;
        
        int mid = left + (right - left)/2;
        if(arr[mid] == target) return binarySearch(arr, left, mid - 1, target);
        
        if(arr[mid] > target){
            return binarySearch(arr, left, mid - 1, target);
        }
        
        if(arr[mid] < target){
            return binarySearch(arr, mid + 1, right, target);
        }
    
    }
    
}