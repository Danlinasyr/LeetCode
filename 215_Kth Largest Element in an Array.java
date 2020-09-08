class Solution {
    Random r = new Random();
    public int findKthLargest(int[] nums, int k) {
        return qSelect(nums, k);
    }
    
    public int qSelect(int[] nums, int k){
        int len = nums.length;
        int pivot = r.nextInt(len);
        int p_val = nums[pivot];
        int[] left = new int[len];
        int[] right = new int[len];
        int[] p_list = new int[len];
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i= 0; i < len; i++){
            if (nums[i] < p_val){
                left[x] = nums[i];
                x++;
            }else if (nums[i] > p_val){
                right[y] = nums[i];
                y++;
            }else{
                p_list[z] = nums[i];
                z++;
            }
        }
        
        if(x > k){
            qSelect((Arrays.copyOfRange(left, 0, x+1)), k);
        }else if(x < k){
            qSelect((Arrays.copyOfRange(right, 0, y+1)), k-x-1);
        }
        
        return p_list[0];
        
    }
    
    
}