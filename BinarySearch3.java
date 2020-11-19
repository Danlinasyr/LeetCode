class Solution {
    
    /**
     * Step 1 find first element in arr that is smaller or equal to x;   idx
     
     * Step 2 two pointers on each side of the found element from step1:
            if(idx >= len) return  arr[len - k, len)
            if(idx == 0)  return arr[0, k)
     
            left >= 0, right <= len - 1;
            (x - arr[left]) < (arr[right] - x) : res.addFirst(arr[left]); left--; k--;
            else: res.addLast(arr[right]); right++; k--;
            
                            1 3 3 3 3 5 6 7       x = 2    k = 3
                              |
     */                          
    

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0;
        int right = arr.length-1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == x){
                right = mid - 1;
            }else if(arr[mid] < x){
                left = mid + 1;
            }else if(arr[mid] > x){
                right = mid - 1;
            }
            
        }
        
        if(left == 0) return Arrays.stream(arr, 0, 0 + k).boxed().collect(Collectors.toList());
        if(left >= arr.length) return Arrays.stream(arr, arr.length-k, arr.length).boxed().collect(Collectors.toList());
        
        LinkedList<Integer> res = new LinkedList<>();
        System.out.println(left);
        res.add(arr[left]);
        right = left+1;
        left = left-1;
        while(k > 1){
            if(left < 0 && right > arr.length - 1) break;
            if(left < 0){
               res.addLast(arr[right]); 
                right = right + 1;
                k = k -1;
                continue; 
            } 
            if(right > arr.length - 1){
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


    
}