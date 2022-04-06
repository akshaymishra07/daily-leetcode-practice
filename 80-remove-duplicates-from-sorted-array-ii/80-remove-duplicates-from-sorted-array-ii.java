class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 1){
            return 1;
        }
        
        int i = 0;
        int idx = 0;
        
        while(i < nums.length){
            
            int num = nums[i];
            int count = 0;
            
            while(i < nums.length && nums[i] == num){
                i++;
                count++;
            }
            
            if(count>1){
                nums[idx++] = nums[i-1];
                nums[idx++] = nums[i-1];
                
            }else
               nums[idx++] = nums[i-1];
            
        }
        
        return idx;
    }
}